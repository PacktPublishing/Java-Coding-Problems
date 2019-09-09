package modern.challenge;

import java.math.RoundingMode;
import java.text.NumberFormat.Style;
import java.text.ParseException;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws ParseException {

        System.out.println("Formatting");
        System.out.println("----------------------------------------------");

        System.out.println("\nLocale US, format SHORT: ");
        String ussk = NumberFormatters.forLocaleStyle(Locale.US, Style.SHORT, 1_000);
        String ussm = NumberFormatters.forLocaleStyle(Locale.US, Style.SHORT, 1_000_000);
        String ussb = NumberFormatters.forLocaleStyle(Locale.US, Style.SHORT, 1_000_000_000);
        System.out.println(ussk);
        System.out.println(ussm);
        System.out.println(ussb);

        System.out.println("\nLocale US, format LONG: ");
        String uslk = NumberFormatters.forLocaleStyle(Locale.US, Style.LONG, 1_000);
        String uslm = NumberFormatters.forLocaleStyle(Locale.US, Style.LONG, 1_000_000);
        String uslb = NumberFormatters.forLocaleStyle(Locale.US, Style.LONG, 1_000_000_000);
        System.out.println(uslk);
        System.out.println(uslm);
        System.out.println(uslb);

        System.out.println("\nLocale ITALIAN, format SHORT: ");
        String itsk = NumberFormatters.forLocaleStyle(Locale.ITALIAN, Style.SHORT, 1_000);
        String itsm = NumberFormatters.forLocaleStyle(Locale.ITALIAN, Style.SHORT, 1_000_000);
        String itsb = NumberFormatters.forLocaleStyle(Locale.ITALIAN, Style.SHORT, 1_000_000_000);
        System.out.println(itsk);
        System.out.println(itsm);
        System.out.println(itsb);

        System.out.println("\nLocale ITALIAN, format LONG: ");
        String itlk = NumberFormatters.forLocaleStyle(Locale.ITALIAN, Style.LONG, 1_000);
        String itlm = NumberFormatters.forLocaleStyle(Locale.ITALIAN, Style.LONG, 1_000_000);
        String itlb = NumberFormatters.forLocaleStyle(Locale.ITALIAN, Style.LONG, 1_000_000_000);
        System.out.println(itlk);
        System.out.println(itlm);
        System.out.println(itlb);

        System.out.println("\nRounding");
        System.out.println("----------------------------------------------");

        String rounddef1 = NumberFormatters.forLocaleStyle(Locale.US, Style.LONG, 1_200);
        String rounddef2 = NumberFormatters.forLocaleStyle(Locale.US, Style.LONG, 1_600);
        System.out.println("Rounding half-even 1_200: " + rounddef1);
        System.out.println("Rounding half-even 1_600: " + rounddef2);
        
        String roundup = NumberFormatters.forLocaleStyleRound(Locale.US, Style.LONG, RoundingMode.UP, 1_200);
        String rounddown = NumberFormatters.forLocaleStyleRound(Locale.US, Style.LONG, RoundingMode.DOWN, 1_600);
        System.out.println("Rounding up 1_200: " + roundup);
        System.out.println("Rounding down 1_600: " + rounddown);
        
        System.out.println("\nParsing");
        System.out.println("----------------------------------------------");
        
        Number fiveSThousand = NumberFormatters.parseLocaleStyle(Locale.US, Style.SHORT, "5K");
        Number fiveLThousand = NumberFormatters.parseLocaleStyle(Locale.US, Style.LONG, "5 thousand");
        System.out.println("Parsing (short) 5K: " + fiveSThousand);
        System.out.println("Parsing (long) 5K: " + fiveLThousand);
        
        Number fiveSGThousand = NumberFormatters.parseLocaleStyleRound(Locale.US, Style.SHORT, true, "5,50K");
        Number fiveLGThousand = NumberFormatters.parseLocaleStyleRound(Locale.US, Style.LONG, true, "5,50 thousand");
        System.out.println("Parsing & grouping (short) 5,50K: " + fiveSGThousand);
        System.out.println("Parsing & grouping (long) 5,50 thousand: " + fiveLGThousand);        
    }
}
