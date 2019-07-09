package modern.challenge;

public class Main {

    private static final String LS = System.lineSeparator();

    public static void main(String[] args) {

        String text1 = new StringBuilder()
                .append("My high school, ").append(LS)
                .append("the Illinois Mathematics and Science Academy,").append(LS)
                .append("showed me that anything is possible ").append(LS)
                .append("and that you're never too young to think big.")
                .toString();
        System.out.println("--------------------------------------------");
        System.out.println("Text 1:" + LS + text1);
        System.out.println("--------------------------------------------");

        String text2 = String.join(LS,
                "My high school, ",
                "the Illinois Mathematics and Science Academy,",
                "showed me that anything is possible ",
                "and that you're never too young to think big.");        
        System.out.println("Text 2:" + LS + text2);
        System.out.println("--------------------------------------------");        
                
        String text3 = "My high school, " + LS
                + "the Illinois Mathematics and Science Academy," + LS
                + "showed me that anything is possible " + LS
                + "and that you're never too young to think big.";        
        System.out.println("Text 3:" + LS + text3);
        System.out.println("--------------------------------------------");

        String text4 = String.format("%s" + LS + "%s" + LS + "%s" + LS + "%s",
                "My high school, ",
                "the Illinois Mathematics and Science Academy,",
                "showed me that anything is possible ",
                "and that you're never too young to think big.");        
        System.out.println("Text 4:" + LS + text4);
        System.out.println("--------------------------------------------");

        // JDK 13 text blocks
        /*
        String text5 = """My high school, 
                        the Illinois Mathematics and Science Academy,
                        showed me that anything is possible
                        and that you're never too young to think big.""";
        System.out.println("Text 5:" + LS + text5);
        System.out.println("--------------------------------------------");
        */
    }
   
}
