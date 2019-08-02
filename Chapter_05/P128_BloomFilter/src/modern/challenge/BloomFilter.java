package modern.challenge;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.BitSet;
import java.util.Collection;

// Inspired by the SimpleBloomFilter-class written by Ian Clarke
public class BloomFilter<T> implements Serializable {

    // Useful formulas
    // Number of items in the filter (can be estimated based on m, k and p)
    // n = ceil(m / (-k / log(1 - exp(log(p) / k))))
    // Probability of false positives, fraction between 0 and 1 or a number indicating 1-in-p
    // p = pow(1 - exp(-k / (m / n)), k)
    // Number of bits in the filter (or a size with KB, KiB, MB, Mb, GiB, etc)
    // m = ceil((n * log(p)) / log(1 / pow(2, log(2))));
    // Number of hash functions (can be estimated based on m and n)
    // k = round((m / n) * log(2));
    private BitSet bitset;

    private int bitSetSize;
    private int expectedNumberOfElements;
    private int numberOfAddedElements;
    private int numberOfHashFunctions;

    private double bitsPerElement;

    private static final long serialVersionUID = -41L;

    private static MessageDigest messageDigest;
    private static DecimalFormat formatter = new DecimalFormat("#.0");

    private static final String JVM_TYPE = System.getProperty("sun.arch.data.model");
    private static final String MESSAGE_DIGEST_ALG = "SHA-256";
    private static final String JVM_64 = "64";
    private static final Charset CHARSET = StandardCharsets.UTF_8;
    private static final long MURMUR_SEED = 012345L;

    static {
        try {
            messageDigest = MessageDigest.getInstance(MESSAGE_DIGEST_ALG);
        } catch (NoSuchAlgorithmException ex) {
            messageDigest = null;
        }
    }

    public BloomFilter(double bitsPerElement, int expectedNumberOfElements, int numberOfHashFunctions) {

        this.bitsPerElement = bitsPerElement;
        this.expectedNumberOfElements = expectedNumberOfElements;
        this.numberOfHashFunctions = numberOfHashFunctions;

        this.bitSetSize = (int) Math.ceil(bitsPerElement * expectedNumberOfElements);
        this.bitset = new BitSet(bitSetSize);

        this.numberOfAddedElements = 0;
    }

    public BloomFilter(int bitSetSize, int expectedNumberOElements) {
        this(bitSetSize / (double) expectedNumberOElements,
                expectedNumberOElements,
                (int) Math.round((bitSetSize / (double) expectedNumberOElements) * Math.log(2.0d)));
    }

    public BloomFilter(double falsePositiveProbability, int expectedNumberOfElements) {
        this(Math.ceil(-(Math.log(falsePositiveProbability) / Math.log(2))) / Math.log(2),
                expectedNumberOfElements,
                (int) Math.ceil(-(Math.log(falsePositiveProbability) / Math.log(2))));
    }

    public BloomFilter(int bitSetSize, int expectedNumberOfFilterElements,
            int actualNumberOfFilterElements, BitSet filterData) {
        this(bitSetSize, expectedNumberOfFilterElements);
        this.bitset = filterData;
        this.numberOfAddedElements = actualNumberOfFilterElements;
    }

    private static int[] hash(byte[] data, int hashno) {

        byte salt = 0;
        int[] hashes = new int[hashno];

        for (int j = 0; j < hashno; j++) {
            messageDigest.update(salt++);
            byte[] bytehash = messageDigest.digest(data);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytehash.length; ++i) {
                String hex = Integer.toHexString(bytehash[i]);
                if (hex.length() == 1) {
                    sb.append(0);
                    sb.append(hex.charAt(hex.length() - 1));
                } else {
                    sb.append(hex.substring(hex.length() - 2));
                }

                hashes[j] = hashCode(sb.toString());
            }
        }
        return hashes;
    }

    private static int hashCode(String s) {
        int g = 31;
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = g * hash + s.charAt(i);
        }
        return hash;
    }

    private static long[] hashMurmur(byte[] data) {
        if (JVM_64.equals(JVM_TYPE)) {
            return Murmur.hash_x64_128(data, data.length, MURMUR_SEED);
        }

        return new long[]{Murmur.hash_x86_32(data, data.length, MURMUR_SEED)};
    }

    public void addAllViaMurmur(Collection<? extends T> c) {
        for (T element : c) {
            addViaMurmur(element);
        }
    }

    public void addAll(Collection<? extends T> c) {
        for (T element : c) {
            add(element);
        }
    }

    public void add(T element) {
        add(element.toString().getBytes(CHARSET));
    }

    public void addViaMurmur(T element) {

        long[] hashes = hashMurmur(element.toString().getBytes(CHARSET));
        for (long hash : hashes) {
            bitset.set(Math.abs((int) (hash % (long) bitSetSize)), true);
        }

        numberOfAddedElements++;

    }

    public void add(byte[] bytes) {
        int[] hashes = hash(bytes, numberOfHashFunctions);
        for (int hash : hashes) {
            bitset.set(Math.abs(hash % bitSetSize), true);
        }

        numberOfAddedElements++;
    }

    public void addAlreadyHashed(int hash) {

        bitset.set(Math.abs(hash % bitSetSize), true);
        numberOfAddedElements++;
    }

    public boolean contains(T element) {
        return contains(element.toString().getBytes(CHARSET));
    }

    public boolean contains(byte[] bytes) {
        int[] hashes = hash(bytes, numberOfHashFunctions);
        for (int hash : hashes) {
            if (!bitset.get(Math.abs(hash % bitSetSize))) {
                return false;
            }
        }

        return true;
    }

    public boolean containsViaMurmur(T element) {
        return containsViaMurmur(element.toString().getBytes(CHARSET));
    }

    public boolean containsViaMurmur(byte[] bytes) {
        long[] hashes = hashMurmur(bytes);
        for (long hash : hashes) {
            if (!bitset.get(Math.abs((int) (hash % (long) bitSetSize)))) {
                return false;
            }
        }

        return true;
    }

    public double getFalsePositiveProbability(double numberOfElements) {
        // (1 - e^(-k * n / m)) ^ k
        //  p = pow(1 - exp(-k / (m / n)), k)
        return Math.pow((1 - Math.exp(-numberOfHashFunctions * (double) numberOfElements
                / (double) bitSetSize)), numberOfHashFunctions);

    }

    public double expectedFalsePositiveProbability() {
        return getFalsePositiveProbability(expectedNumberOfElements);
    }

    public double getFalsePositiveProbability() {
        return getFalsePositiveProbability(numberOfAddedElements);
    }

    public String getFalsePositiveProbabilityAsPercent(double numberOfElements) {
        return formatter.format(getFalsePositiveProbability(numberOfElements) * 100) + "%";
    }

    public String getFalsePositiveProbabilityAsPercent() {
        return formatter.format(getFalsePositiveProbability(numberOfAddedElements) * 100) + "%";
    }

    public String expectedFalsePositiveProbabilityAsPercent() {
        return formatter.format(getFalsePositiveProbability(expectedNumberOfElements) * 100) + "%";
    }

    public int getNumberOfHashFunctions() {
        return numberOfHashFunctions;
    }

    public boolean getBit(int bit) {
        return bitset.get(bit);
    }

    public void setBit(int bit, boolean value) {
        bitset.set(bit, value);
    }

    public int size() {
        return this.bitSetSize;
    }

    public int count() {
        return this.numberOfAddedElements;
    }

    public int getExpectedNumberOfElements() {
        return expectedNumberOfElements;
    }

    public double getExpectedBitsPerElement() {
        return this.bitsPerElement;
    }

    public double getBitsPerElement() {
        return this.bitSetSize / (double) numberOfAddedElements;
    }

    public void clear() {
        bitset.clear();
        numberOfAddedElements = 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final BloomFilter<T> other = (BloomFilter<T>) obj;
        if (this.expectedNumberOfElements != other.expectedNumberOfElements) {
            return false;
        }

        if (this.numberOfHashFunctions != other.numberOfHashFunctions) {
            return false;
        }

        if (this.bitSetSize != other.bitSetSize) {
            return false;
        }

        if (this.bitset != other.bitset && (this.bitset == null || !this.bitset.equals(other.bitset))) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 33 * hash + (this.bitset != null ? this.bitset.hashCode() : 0);
        hash = 33 * hash + this.expectedNumberOfElements;
        hash = 33 * hash + this.bitSetSize;
        hash = 63 * hash + this.numberOfHashFunctions;
        return hash;
    }

    // Murmur 3 implementation copy-paste from here
    // https://github.com/sangupta/murmur/tree/master/src/main/java/com/sangupta/murmur    
    private static class Murmur {

        private static final int UNSIGNED_MASK = 0xff;

        private static final long UINT_MASK = 0xFFFFFFFFl;

        private static final int X86_32_C1 = 0xcc9e2d51;

        private static final int X86_32_C2 = 0x1b873593;

        private static final long X64_128_C1 = 0x87c37b91114253d5L;

        private static final long X64_128_C2 = 0x4cf5ad432745937fL;

        public static long hash_x86_32(final byte[] data, int length, long seed) {
            final int nblocks = length >> 2;
            long hash = seed;

            for (int i = 0; i < nblocks; i++) {
                final int i4 = i << 2;

                long k1 = (data[i4] & UNSIGNED_MASK);
                k1 |= (data[i4 + 1] & UNSIGNED_MASK) << 8;
                k1 |= (data[i4 + 2] & UNSIGNED_MASK) << 16;
                k1 |= (data[i4 + 3] & UNSIGNED_MASK) << 24;

                // int k1 = (data[i4] & 0xff) + ((data[i4 + 1] & 0xff) << 8) + 
                // ((data[i4 + 2] & 0xff) << 16) + ((data[i4 + 3] & 0xff) << 24);
                k1 = (k1 * X86_32_C1) & UINT_MASK;
                k1 = rotl32(k1, 15);
                k1 = (k1 * X86_32_C2) & UINT_MASK;

                hash ^= k1;
                hash = rotl32(hash, 13);
                hash = (((hash * 5) & UINT_MASK) + 0xe6546b64l) & UINT_MASK;
            }

            int offset = (nblocks << 2); // nblocks * 2;
            long k1 = 0;

            switch (length & 3) {
                case 3:
                    k1 ^= (data[offset + 2] << 16) & UINT_MASK;

                case 2:
                    k1 ^= (data[offset + 1] << 8) & UINT_MASK;

                case 1:
                    k1 ^= data[offset];
                    k1 = (k1 * X86_32_C1) & UINT_MASK;
                    k1 = rotl32(k1, 15);
                    k1 = (k1 * X86_32_C2) & UINT_MASK;
                    hash ^= k1;
            }

            hash ^= length;
            hash = fmix32(hash);

            return hash;
        }

        public static long[] hash_x64_128(final byte[] data, final int length, final long seed) {
            long h1 = seed;
            long h2 = seed;

            ByteBuffer buffer = ByteBuffer.wrap(data);
            buffer.order(ByteOrder.LITTLE_ENDIAN);

            while (buffer.remaining() >= 16) {
                long k1 = buffer.getLong();
                long k2 = buffer.getLong();

                h1 ^= mixK1(k1);

                h1 = Long.rotateLeft(h1, 27);
                h1 += h2;
                h1 = h1 * 5 + 0x52dce729;

                h2 ^= mixK2(k2);

                h2 = Long.rotateLeft(h2, 31);
                h2 += h1;
                h2 = h2 * 5 + 0x38495ab5;
            }

            buffer.compact();
            buffer.flip();

            final int remaining = buffer.remaining();
            if (remaining > 0) {
                long k1 = 0;
                long k2 = 0;
                switch (buffer.remaining()) {
                    case 15:
                        k2 ^= (long) (buffer.get(14) & UNSIGNED_MASK) << 48;

                    case 14:
                        k2 ^= (long) (buffer.get(13) & UNSIGNED_MASK) << 40;

                    case 13:
                        k2 ^= (long) (buffer.get(12) & UNSIGNED_MASK) << 32;

                    case 12:
                        k2 ^= (long) (buffer.get(11) & UNSIGNED_MASK) << 24;

                    case 11:
                        k2 ^= (long) (buffer.get(10) & UNSIGNED_MASK) << 16;

                    case 10:
                        k2 ^= (long) (buffer.get(9) & UNSIGNED_MASK) << 8;

                    case 9:
                        k2 ^= (long) (buffer.get(8) & UNSIGNED_MASK);

                    case 8:
                        k1 ^= buffer.getLong();
                        break;

                    case 7:
                        k1 ^= (long) (buffer.get(6) & UNSIGNED_MASK) << 48;

                    case 6:
                        k1 ^= (long) (buffer.get(5) & UNSIGNED_MASK) << 40;

                    case 5:
                        k1 ^= (long) (buffer.get(4) & UNSIGNED_MASK) << 32;

                    case 4:
                        k1 ^= (long) (buffer.get(3) & UNSIGNED_MASK) << 24;

                    case 3:
                        k1 ^= (long) (buffer.get(2) & UNSIGNED_MASK) << 16;

                    case 2:
                        k1 ^= (long) (buffer.get(1) & UNSIGNED_MASK) << 8;

                    case 1:
                        k1 ^= (long) (buffer.get(0) & UNSIGNED_MASK);
                        break;

                    default:
                        throw new AssertionError("Code should not reach here!");
                }

                h1 ^= mixK1(k1);
                h2 ^= mixK2(k2);
            }

            h1 ^= length;
            h2 ^= length;

            h1 += h2;
            h2 += h1;

            h1 = fmix64(h1);
            h2 = fmix64(h2);

            h1 += h2;
            h2 += h1;

            return (new long[]{h1, h2});
        }

        private static long mixK1(long k1) {
            k1 *= X64_128_C1;
            k1 = Long.rotateLeft(k1, 31);
            k1 *= X64_128_C2;

            return k1;
        }

        private static long mixK2(long k2) {
            k2 *= X64_128_C2;
            k2 = Long.rotateLeft(k2, 33);
            k2 *= X64_128_C1;

            return k2;
        }

        private static long rotl32(long original, int shift) {
            return ((original << shift) & UINT_MASK) | ((original >>> (32 - shift)) & UINT_MASK);
        }

        private static long fmix32(long h) {
            h ^= (h >> 16) & UINT_MASK;
            h = (h * 0x85ebca6bl) & UINT_MASK;
            h ^= (h >> 13) & UINT_MASK;
            h = (h * 0xc2b2ae35) & UINT_MASK;
            h ^= (h >> 16) & UINT_MASK;

            return h;
        }

        private static long fmix64(long k) {
            k ^= k >>> 33;
            k *= 0xff51afd7ed558ccdL;
            k ^= k >>> 33;
            k *= 0xc4ceb9fe1a85ec53L;
            k ^= k >>> 33;

            return k;
        }

    }
}
