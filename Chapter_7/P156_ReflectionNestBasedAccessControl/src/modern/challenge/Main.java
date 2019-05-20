package modern.challenge;

import java.util.Arrays;

public class Main {    

    public static void main(String[] args) {
                         
        Class<Melon> clazzMelon = Melon.class;
        Class<Melon.Slice> clazzSlice = Melon.Slice.class;
        Class<Melon.Juicer> clazzJuicer = Melon.Juicer.class;
        Class<Melon.Slice.Peeler> clazzPeeler = Melon.Slice.Peeler.class;
        
        Class<?> nestClazzOfMelon = clazzMelon.getNestHost();
        System.out.println("\nNested host of Melon: " + nestClazzOfMelon);        
        Class<?> nestClazzOfSlice = clazzSlice.getNestHost();
        System.out.println("Nested host of Slice: " + nestClazzOfSlice);        
        Class<?> nestClazzOfPeeler = clazzPeeler.getNestHost();
        System.out.println("Nested host of Peeler: " + nestClazzOfPeeler);        
        Class<?> nestClazzOfJuicer = clazzJuicer.getNestHost();
        System.out.println("Nested host of Juicer: " + nestClazzOfJuicer);
        
        Class<?>[] nestMembersOfMelon = clazzMelon.getNestMembers();
        System.out.println("\nNested members of Melon: " + Arrays.toString(nestMembersOfMelon));                
        Class<?>[] nestMembersOfSlice = clazzSlice.getNestMembers();
        System.out.println("Nested members of Slice: " + Arrays.toString(nestMembersOfSlice));        
        Class<?>[] nestMembersOfJuicer = clazzJuicer.getNestMembers();
        System.out.println("Nested members of Juicer: " + Arrays.toString(nestMembersOfJuicer));        
        Class<?>[] nestMembersOfPeeler = clazzPeeler.getNestMembers();
        System.out.println("Nested members of Peeler: " + Arrays.toString(nestMembersOfPeeler));        
        
        boolean melonIsNestmateOfSlice = clazzMelon.isNestmateOf(clazzSlice);
        boolean melonIsNestmateOfJuicer = clazzMelon.isNestmateOf(clazzJuicer);
        boolean melonIsNestmateOfPeeler = clazzMelon.isNestmateOf(clazzPeeler);
        boolean sliceIsNestmateOfJuicer = clazzSlice.isNestmateOf(clazzJuicer);
        boolean sliceIsNestmateOfPeeler = clazzSlice.isNestmateOf(clazzPeeler);
        boolean juicerIsNestmateOfPeeler = clazzJuicer.isNestmateOf(clazzPeeler);
        System.out.println("\nIs Melon nestmate of Slice? " + melonIsNestmateOfSlice);
        System.out.println("Is Melon nestmate of Juicer? " + melonIsNestmateOfJuicer);
        System.out.println("Is Melon nestmate of Peeler? " + melonIsNestmateOfPeeler);
        System.out.println("Is Slice nestmate of Juicer? " + sliceIsNestmateOfJuicer);
        System.out.println("Is Slice nestmate of Peeler? " + sliceIsNestmateOfPeeler);
        System.out.println("Is Juicer nestmate of Peeler? " + juicerIsNestmateOfPeeler);                                 
    }
}
