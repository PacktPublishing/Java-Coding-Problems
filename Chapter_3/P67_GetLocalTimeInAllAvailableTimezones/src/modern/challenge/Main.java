package modern.challenge;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> datetimes8 = DateTimes.localTimeToAllTimeZones8();
        datetimes8.forEach(System.out::println);
    }
    
}
