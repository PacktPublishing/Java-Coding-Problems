package modern.challenge;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        CustomerOrder co1 = new CustomerOrder(1);
        CustomerOrder co2 = new CustomerOrder(2);
        CustomerOrder co3 = new CustomerOrder(3);

        new Thread(co1).start();
        new Thread(co2).start();
        new Thread(co3).start();
    }

}
