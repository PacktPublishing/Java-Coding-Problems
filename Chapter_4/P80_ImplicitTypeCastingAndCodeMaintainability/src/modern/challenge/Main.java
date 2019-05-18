package modern.challenge;

public class Main {

    public static void main(String[] args) {

        boolean payed = purchaseCart(1L);
        System.out.println("Success: " + payed);
    }

    public static boolean purchaseCart(long customerId) {

        var price = ShoppingAddicted.fetchBestPriceAsInt(new String[0]);
        var payed = ShoppingAddicted.debitCardAsInt(price);

        return payed;
    }
}
