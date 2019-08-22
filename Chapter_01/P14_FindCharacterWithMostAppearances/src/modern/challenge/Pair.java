package modern.challenge;

public final class Pair<V, C> {

    final V character;
    final C occurrences;

    public Pair(V character, C occurrences) {
        this.character = character;
        this.occurrences = occurrences;
    }

    static <V, C> Pair<V, C> of(V character, C occurrences) {
        return new Pair<>(character, occurrences);
    }

    @Override
    public int hashCode() {
        return character.hashCode() ^ character.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) {
            return false;
        }

        Pair obj = (Pair) o;
        return this.character.equals(obj.character)
                && this.occurrences.equals(obj.occurrences);
    }
}
