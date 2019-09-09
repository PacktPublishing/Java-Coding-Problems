package modern.challenge;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] arrI = new int[2];
        arrI[0] = 5;
        arrI[1] = 1;
        
        System.out.println("Initial array (arrI): " + Arrays.toString(arrI));
        
        System.out.println("\nAdd number 2 in the initial array");
        int[] arrIAfterAdd = ResizableArray.add(arrI, 2);
        System.out.println("Result: " + Arrays.toString(arrIAfterAdd));
        
        System.out.println("\nRemove last number from the initial array (1):");
        int[] arrIAfterRemove = ResizableArray.remove(arrI);
        System.out.println("Result: " + Arrays.toString(arrIAfterRemove));
        
        System.out.println("\nResize the initial array to 12:");
        int[] arrIResized = ResizableArray.resize(arrI, 10);
        System.out.println("Result: " + Arrays.toString(arrIResized));
        
        String[] arrS = new String[2];
        arrS[0] = "abc";
        arrS[1] = "def";
        
        System.out.println("\n\nInitial array (arrS): " + Arrays.toString(arrS));
        
        System.out.println("\nAdd string 'ghi' in the initial array");
        String[] arrSAfterAdd = ResizableArray.addObject(arrS, "ghi");
        System.out.println("Result: " + Arrays.toString(arrSAfterAdd));
        
        System.out.println("\nRemove last string from the initial array ('def'):");
        String[] arrSAfterRemove = ResizableArray.removeObject(arrS);
        System.out.println("Result: " + Arrays.toString(arrSAfterRemove));
        
        System.out.println("\nResize the initial array to 12:");
        String[] arrSResized = ResizableArray.resize(arrS, 10);
        System.out.println("Result: " + Arrays.toString(arrSResized));        
    }
    
}
