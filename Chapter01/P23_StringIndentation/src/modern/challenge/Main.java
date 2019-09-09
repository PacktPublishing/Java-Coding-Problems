package modern.challenge;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String daysString = "Sunday\n"
                + "Monday\n"
                + "Tuesday\n"
                + "Wednesday\n"
                + "Thursday\n"
                + "Friday\n"
                + "Saturday";

        System.out.print(daysString.indent(10));

        System.out.println("--------------------------------------------");

        List<String> daysList = Arrays.asList(
                "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");

        for (int i = 0; i < daysList.size(); i++) {
            System.out.print(daysList.get(i).indent(i));
        }

        System.out.println("--------------------------------------------");

        daysList.stream()
                .forEachOrdered(d -> System.out.print(d.indent(d.length())));

        System.out.println("--------------------------------------------");

        String html = "<html>";
        String body = "<body>";
        String h2 = "<h2>";
        String text = "Hello world!";
        String closeH2 = "</h2>";
        String closeBody = "</body>";
        String closeHtml = "</html>";

        System.out.println(html.indent(0) + body.indent(4) + h2.indent(8)
                + text.indent(12)
                + closeH2.indent(8) + closeBody.indent(4) + closeHtml.indent(0));
    }

}
