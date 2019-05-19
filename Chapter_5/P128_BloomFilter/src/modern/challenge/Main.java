package modern.challenge;

public class Main {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        // use one of the available constructors
        // 0.3 = 30% false positives probability expected, 10 elements expected
        BloomFilter bf = new BloomFilter(0.3, 10);

        bf.add("Octavia");
        bf.add("Anghel");
        bf.add("Jonnhy");
        bf.add("Marua");
        bf.add("Maria");
        bf.add("Mary");
        bf.add("Qunto");
        bf.add("Alexander");
        bf.add("Alin");
        bf.add("Myrriad");

        System.out.println("False positive probability between 0 and 1: "
                + bf.getFalsePositiveProbability());
        System.out.println("False positive probability in percent: "
                + bf.getFalsePositiveProbabilityAsPercent());
        System.out.println("Number of hash functions: "
                + bf.getNumberOfHashFunctions());

        System.out.println("Marua is there? " + bf.contains("Marua")); // expected true
        System.out.println("Alexandra is there? " + bf.contains("Alexandra")); // expected false
    }

}
