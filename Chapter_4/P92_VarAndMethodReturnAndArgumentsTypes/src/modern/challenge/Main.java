package modern.challenge;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        System.out.println(checkPlayer());
    }

    public static Report checkPlayer() {

        var player = new Player();
        var timestamp = new Date();

        var report = fetchReport(player, timestamp);

        return report;
    }

    public static Report fetchReport(Player player, Date timestamp) {
        return new Report();
    }
}
