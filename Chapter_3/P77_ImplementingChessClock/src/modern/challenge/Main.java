package modern.challenge;

import java.time.Duration;
import java.time.Instant;
import modern.challenge.ChessClock.Player;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ChessClock chessClock = new ChessClock(Player.LEFT);

        Instant start = chessClock.gameStart();
        System.out.println("Game started:" + start);

        Thread.sleep(2000);
        System.out.println("\nLeft moved first after 2 seconds: " + chessClock.instant());
        Thread.sleep(5000);
        System.out.println("Right moved after 5 seconds: " + chessClock.instant());
        Thread.sleep(6000);
        System.out.println("\nLeft moved after 6 seconds: " + chessClock.instant());
        Thread.sleep(1000);
        System.out.println("Right moved after 1 second: " + chessClock.instant());
        Thread.sleep(2000);
        System.out.println("\nLeft moved after 2 second: " + chessClock.instant());
        Thread.sleep(3000);
        System.out.println("Right moved after 3 seconds: " + chessClock.instant());
        Thread.sleep(10000);
        System.out.println("\nLeft moved after 10 seconds: " + chessClock.instant());
        Thread.sleep(11000);
        System.out.println("Right moved after 11 seconds and win: " + chessClock.instant());

        Instant end = chessClock.gameEnd();
        System.out.println("\nGame ended:" + end);

        System.out.println("\n Game duration: " + Duration.between(start, end).getSeconds() + " seconds");
    }

}
