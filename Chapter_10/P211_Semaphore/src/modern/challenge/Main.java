package modern.challenge;

public class Main {

    public static void main(String[] args) {

        System.setProperty("java.util.logging.SimpleFormatter.format",
              "[%1$tT] [%4$-7s] %5$s %n");
        
        Barbershop bs = new Barbershop(3);

        for (int i = 1; i <= 10; i++) {
            BarbershopCustomer bc = new BarbershopCustomer(bs, i);
            new Thread(bc).start();
        }                
    }

}
