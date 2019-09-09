package modern.challenge;

public class Main {

    public static void main(String[] args) {

        Float f1 = 4.5f;
        boolean f1f = Float.isFinite(f1);

        Float f2 = f1 / 0;
        boolean f2f = Float.isFinite(f2);
        
        Float f3 = 0f / 0f;
        boolean f3f = Float.isFinite(f3);

        System.out.println("Finite floats:\n-------------------");
        System.out.println(f1 + " is finite? " + f1f);
        System.out.println(f2 + " is finite? " + f2f);
        System.out.println(f3 + " is finite? " + f3f);

        Double d1 = 0.000333411333d;
        boolean d1f = Double.isFinite(d1);
        
        Double d2 = d1 / 0;
        boolean d2f = Double.isFinite(d2);
        
        Double d3 = Double.POSITIVE_INFINITY * 0;
        boolean d3f = Double.isFinite(d3);
        
        System.out.println("\nFinite doubles:\n-------------------");
        System.out.println(d1 + " is finite? " + d1f);
        System.out.println(d2 + " is finite? " + d2f);
        System.out.println(d3 + " is finite? " + d3f);
    }

}
