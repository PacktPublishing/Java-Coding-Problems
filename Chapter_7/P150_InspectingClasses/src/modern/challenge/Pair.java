package modern.challenge;

public final class Pair<L, R> extends Tuple implements Comparable {

    final L left;
    final R right;

    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public class Entry<L, R> {
    }

    static <L, R> Pair<L, R> of(L left, R right) {
        return new Pair<>(left, right);
    }

    @Override
    public int hashCode() {
        return left.hashCode() ^ right.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) {
            return false;
        }

        Pair obj = (Pair) o;
        return this.left.equals(obj.left)
                && this.right.equals(obj.right);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
