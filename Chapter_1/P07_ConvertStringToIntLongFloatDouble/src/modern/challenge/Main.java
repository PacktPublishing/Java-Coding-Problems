package modern.challenge;

public class Main {

    private static final String TO_INT = "453";
    private static final String TO_LONG = "45234223233";
    private static final String TO_FLOAT = "45.823F";
    private static final String TO_DOUBLE = "13.83423D";
    
    public static void main(String[] args) {

        // convert String to int/Integer
        Integer toInt1 = Integer.valueOf(TO_INT);        // returns Integer
        int toInt2 = Integer.parseInt(TO_INT);           // returns int

        // convert String to long/Long
        Long toLong1 = Long.valueOf(TO_LONG);            // returns Long
        long toLong2 = Long.parseLong(TO_LONG);          // returns long
        
        // convert String to float/Float
        Float toFloat1 = Float.valueOf(TO_FLOAT);        // returns Float
        float toFloat2 = Float.parseFloat(TO_FLOAT);     // returns float
        
        // convert String to double/Double
        Double toDouble1 = Double.valueOf(TO_DOUBLE);    // returns Double
        double toDouble2 = Double.parseDouble(TO_DOUBLE); // returns double
        
        System.out.println("\"" + TO_INT + "\"" + " as int is " 
                + toInt1 + " and as Integer is " + toInt2);
        System.out.println("\"" + TO_LONG + "\"" + " as long is " 
                + toLong1 + " and as Long is " + toLong2);
        System.out.println("\"" + TO_FLOAT + "\"" + " as float is " 
                + toFloat1 + " and as Float is " + toFloat2);
        System.out.println("\"" + TO_DOUBLE + "\"" + " as double is " 
                + toDouble1 + " and as Double is " + toDouble2);
    }            
}
