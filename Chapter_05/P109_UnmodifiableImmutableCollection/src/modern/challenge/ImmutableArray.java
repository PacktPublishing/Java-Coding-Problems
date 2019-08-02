package modern.challenge;

import java.util.Arrays;

public final class ImmutableArray<T> {

    private final T[] array;

    private ImmutableArray(T[] a) {
        array = Arrays.copyOf(a, a.length);
    }

    public static <T> ImmutableArray<T> from(T[] a) {
        return new ImmutableArray<>(a);
    }

    public T get(int index) {
        return array[index];
    }

    @Override
    public boolean equals(Object obj) {
        
        if (this == obj) {
            return true;
        }
        
        if (obj == null) {
            return false;
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final ImmutableArray<?> other = (ImmutableArray<?>) obj;
        
        return Arrays.deepEquals(this.array, other.array);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Arrays.deepHashCode(this.array);
        return hash;
    }

    @Override
    public String toString() {
        return "ImmutableArray{" 
                + "array=" + Arrays.deepToString(array)
                + '}';
    }
}
