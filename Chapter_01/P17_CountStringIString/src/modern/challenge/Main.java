package modern.challenge;

import java.time.Clock;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final String STRING = "111111";
    private static final String SUBSTRING = "11";

    public static void main(String[] args) {

        Clock clock = Clock.systemUTC();
        long startTimeV1 = clock.millis();
        int countV1 = Strings.countStringInStringV1(STRING, SUBSTRING);
        displayExecutionTime(clock.millis() - startTimeV1);
        System.out.println("V1: '" + SUBSTRING + "' has occured " + countV1 + " times in '" + STRING + "'");

        long startTimeV2 = clock.millis();
        int countV2 = Strings.countStringInStringV2(STRING, SUBSTRING);
        displayExecutionTime(clock.millis() - startTimeV2);
        System.out.println("V2: '" + SUBSTRING + "' has occured " + countV2 + " times in '" + STRING + "'");

        long startTimeV3 = clock.millis();
        int countV3 = Strings.countStringInStringV3(STRING, SUBSTRING);
        displayExecutionTime(clock.millis() - startTimeV3);
        System.out.println("V3: '" + SUBSTRING + "' has occured " + countV3 + " times in '" + STRING + "'");
    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ms" + " ("
                + TimeUnit.SECONDS.convert(time, TimeUnit.MILLISECONDS) + " s)");
    }

}
