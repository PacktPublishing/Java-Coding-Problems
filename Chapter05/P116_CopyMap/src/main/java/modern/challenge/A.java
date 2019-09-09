package modern.challenge;

public class A {

    private final int a;

    public A(int a) {
        this.a = a;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.a;
        return hash;
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
        final A other = (A) obj;
        if (this.a != other.a) {
            return false;
        }
        return true;
    }
        
    @Override
    public String toString() {
        return "A{" + "a=" + a + '}';
    }
}
