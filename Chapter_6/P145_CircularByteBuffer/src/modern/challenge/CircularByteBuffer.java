package modern.challenge;

public class CircularByteBuffer {

    private int capacity;
    private byte[] buffer;
    private int readPointer;
    private int writePointer;
    private int available;

    CircularByteBuffer(int capacity) {
        this.capacity = capacity;
        buffer = new byte[capacity];
    }

    public synchronized int available() {
        return available;
    }

    public synchronized int capacity() {
        return capacity;
    }

    public synchronized int slots() {
        return capacity - available;
    }

    public synchronized int get() {

        if (available == 0) {
            return -1;
        }

        byte value = buffer[readPointer];
        readPointer = (readPointer + 1) % capacity;
        available--;
        return value;
    }

    public synchronized boolean put(int value) {

        if (available == capacity) {
            return false;
        }

        buffer[writePointer] = (byte) value;
        writePointer = (writePointer + 1) % capacity;
        available++;

        return true;
    }

    public int get(byte[] dest) {
        return get(dest, 0, dest.length);
    }

    public int put(byte[] source) {
        return put(source, 0, source.length);
    }

    public synchronized int get(byte[] dest, int offset, int len) {

        if (available == 0) {
            return 0;
        }

        int maxPointer = capacity;
        if (readPointer < writePointer) {
            maxPointer = writePointer;
        }

        int countBytes = Math.min(maxPointer - readPointer, len);
        System.arraycopy(buffer, readPointer, dest, offset, countBytes);
        readPointer = readPointer + countBytes;

        if (readPointer == capacity) {
            int remainingBytes = Math.min(len - countBytes, writePointer);
            if (remainingBytes > 0) {
                System.arraycopy(buffer, 0, dest, offset + countBytes, remainingBytes);
                readPointer = remainingBytes;
                countBytes = countBytes + remainingBytes;
            } else {
                readPointer = 0;
            }
        }

        available = available - countBytes;

        return countBytes;
    }

    public synchronized int put(byte[] source, int offset, int len) {

        if (available == capacity) {
            return 0;
        }

        int maxPointer = capacity;
        if (writePointer < readPointer) {
            maxPointer = readPointer;
        }

        int countBytes = Math.min(maxPointer - writePointer, len);
        System.arraycopy(source, offset, buffer, writePointer, countBytes);
        writePointer = writePointer + countBytes;

        if (writePointer == capacity) {
            int remainingBytes = Math.min(len - countBytes, readPointer);
            if (remainingBytes > 0) {
                System.arraycopy(source, offset + countBytes, buffer, 0, remainingBytes);
                writePointer = remainingBytes;
                countBytes = countBytes + remainingBytes;
            } else {
                writePointer = 0;
            }
        }

        available = available + countBytes;

        return countBytes;
    }

    public synchronized int skip(int skipBytes) {

        if (skipBytes > available) {
            skipBytes = available;
        }

        readPointer = (readPointer + skipBytes) % capacity;
        available = available - skipBytes;

        return skipBytes;
    }

    public synchronized int peek() {

        if (available > 0) {
            return buffer[readPointer];
        }

        return -1;
    }

    public synchronized void resize() {
        
        byte[] newBuffer = new byte[capacity * 2];
        if (readPointer < writePointer) {            
            System.arraycopy(buffer, readPointer, newBuffer, 0, available);
        } else {            
            int bytesToCopy = capacity - readPointer;
            System.arraycopy(buffer, readPointer, newBuffer, 0, bytesToCopy);         
            System.arraycopy(buffer, 0, newBuffer, bytesToCopy, writePointer);
        }

        buffer = newBuffer;
        capacity = buffer.length;
        readPointer = 0;
        writePointer = available;
    }

    public synchronized void clear() {
        readPointer = 0;
        writePointer = 0;
        available = 0;
    }
}
