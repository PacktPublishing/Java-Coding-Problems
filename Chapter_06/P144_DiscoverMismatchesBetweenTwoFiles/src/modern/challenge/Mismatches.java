package modern.challenge;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;

public final class Mismatches {

    private static final int MAP_SIZE = 5242880; // 5 MB in bytes

    private Mismatches() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static boolean haveMismatches(Path p1, Path p2) throws IOException {

        if (p1 == null || p2 == null) {
            throw new IllegalArgumentException("The given paths cannot be null");
        }

        try ( FileChannel channel1 = (FileChannel.open(p1,
                EnumSet.of(StandardOpenOption.READ)))) {
            try ( FileChannel channel2 = (FileChannel.open(p2,
                    EnumSet.of(StandardOpenOption.READ)))) {

                long length1 = channel1.size();
                long length2 = channel2.size();

                if (length1 != length2) {
                    return true;
                }

                int position = 0;

                while (position < length1) {
                    long remaining = length1 - position;
                    int bytestomap = (int) Math.min(MAP_SIZE, remaining);
                    MappedByteBuffer mbBuffer1 = channel1.map(
                            MapMode.READ_ONLY, position, bytestomap);
                    MappedByteBuffer mbBuffer2 = channel2.map(
                            MapMode.READ_ONLY, position, bytestomap);

                    while (mbBuffer1.hasRemaining()) {
                        if (mbBuffer1.get() != mbBuffer2.get()) {
                            return true;
                        }
                    }

                    position += bytestomap;
                }
            }
        }

        return false;
    }

}
