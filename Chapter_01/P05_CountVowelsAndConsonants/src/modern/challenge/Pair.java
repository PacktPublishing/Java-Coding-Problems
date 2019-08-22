package modern.challenge;

public final class Pair<V, C> {

    final V vowels;
    final C consonants;

    public Pair(V vowels, C consonants) {
        this.vowels = vowels;
        this.consonants = consonants;
    }

    static <V, C> Pair<V, C> of(V vowels, C consonants) {
        return new Pair<>(vowels, consonants);
    }

    @Override
    public int hashCode() {
        return vowels.hashCode() ^ consonants.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) {
            return false;
        }
        
        Pair obj = (Pair) o;
        return this.vowels.equals(obj.vowels)
                && this.consonants.equals(obj.consonants);
    }
}