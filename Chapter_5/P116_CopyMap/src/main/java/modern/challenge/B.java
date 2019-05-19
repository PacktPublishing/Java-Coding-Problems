package modern.challenge;

import java.util.Objects;

public class B {

    private final A a;
    private final int b;

    public B(A a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.a);
        hash = 47 * hash + this.b;
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
        final B other = (B) obj;
        if (this.b != other.b) {
            return false;
        }
        if (!Objects.equals(this.a, other.a)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "B{" + "a=" + a + ", b=" + b + '}';
    }
}
