package modern.challenge;

public class Main {

    public static void main(String[] args) {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        String[] forks = {"Fork-1", "Fork-2", "Fork-3", "Fork-4", "Fork-5"};
        Philosopher[] philosophers = {
            new Philosopher(forks[0], forks[1]),
            new Philosopher(forks[1], forks[2]),
            new Philosopher(forks[2], forks[3]),
            new Philosopher(forks[3], forks[4]),
            new Philosopher(forks[0], forks[4])
        };

        Thread threadPhilosopher1 = new Thread(philosophers[0], "Philosopher-1");
        Thread threadPhilosopher2 = new Thread(philosophers[1], "Philosopher-2");
        Thread threadPhilosopher3 = new Thread(philosophers[2], "Philosopher-3");
        Thread threadPhilosopher4 = new Thread(philosophers[3], "Philosopher-4");
        Thread threadPhilosopher5 = new Thread(philosophers[4], "Philosopher-5");

        threadPhilosopher1.start();
        threadPhilosopher2.start();
        threadPhilosopher3.start();
        threadPhilosopher4.start();
        threadPhilosopher5.start();
    }

}
