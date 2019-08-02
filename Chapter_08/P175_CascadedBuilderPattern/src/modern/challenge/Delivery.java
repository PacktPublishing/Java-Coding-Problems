package modern.challenge;

import java.util.function.Consumer;

public final class Delivery {

    public Delivery firstname(String firstname) {
        System.out.println(firstname);
        return this;
    }

    public Delivery lastname(String lastname) {
        System.out.println(lastname);
        return this;
    }

    public Delivery address(String address) {
        System.out.println(address);
        return this;
    }

    public Delivery content(String content) {
        System.out.println(content);
        return this;
    }

    public static void deliver(Consumer<Delivery> parcel) {

        Delivery delivery = new Delivery();
        parcel.accept(delivery);

        System.out.println("\nDone ...");
    }

}
