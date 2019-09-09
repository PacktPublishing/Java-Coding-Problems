package modern.challenge;

import java.util.Objects;

public final class Book {

    private final int price;
    private final String name;

    public Book(int price, String name) {
        this.price = price;
        this.name = name;
    }        

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }   

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.price;
        hash = 89 * hash + Objects.hashCode(this.name);
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
        
        final Book other = (Book) obj;
        if (this.price != other.price) {
            return false;
        }
        
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
       
}
