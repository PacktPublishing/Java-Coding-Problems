package modern.challenge;

public final class ShoppingAddicted {

    private ShoppingAddicted() {
        throw new AssertionError("Cannot be instantiated");
    }

    // old API
    public static int fetchBestPriceAsInt(String[] products) {

        float realprice = 399.99F; // code to query the prices in stores
        int price = (int) realprice;

        return price;
    }

    public static boolean debitCardAsInt(int amount) {

        return true;
    }

    // new API    
    public static float fetchBestPriceAsFloat(String[] products) {

        float realprice = 399.99F; // code to query the prices in stores

        return realprice;
    }

    public static boolean debitCardAsFloat(float amount) {

        return true;
    }
}
