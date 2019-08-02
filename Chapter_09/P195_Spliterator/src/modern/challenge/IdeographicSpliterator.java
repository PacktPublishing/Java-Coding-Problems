package modern.challenge;

import java.util.Spliterator;
import java.util.function.Consumer;

public class IdeographicSpliterator implements Spliterator<Character> {

    private final String str;
    private int position;

    public IdeographicSpliterator(String str) {
        this.str = str;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Character> c) {
       
        c.accept(str.charAt(position));
        position++;

        return position < str.length();
    }

    @Override
    public Spliterator<Character> trySplit() {
        int remLength = str.length() - position;

        if (remLength < 5) { // cannot split under 5 characters
            return null;
        }

        for (int splitPosition = remLength / 2 + position;
                splitPosition < str.length(); splitPosition++) {

            if (Character.isIdeographic(str.charAt(splitPosition))) {

                Spliterator<Character> spliterator
                        = new IdeographicSpliterator(str.substring(position, splitPosition));
                System.out.println("Split successfully at character: " + str.charAt(splitPosition));

                position = splitPosition;

                return spliterator;
            }
        }

        return null;
    }

    @Override
    public long estimateSize() {
        return str.length() - position;
    }

    @Override
    public int characteristics() {
        return ORDERED + IMMUTABLE + NONNULL + SIZED + SUBSIZED;
    }
}
