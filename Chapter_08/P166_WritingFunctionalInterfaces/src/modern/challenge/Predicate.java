package modern.challenge;

@FunctionalInterface
public interface Predicate<T> {
    
    boolean test(T t);
}
