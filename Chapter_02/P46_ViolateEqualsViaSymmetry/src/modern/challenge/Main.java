package modern.challenge;

public class Main {

    public static void main(String[] args) {

        // bad
        modern.challenge.bad.Vehicle vBad = new modern.challenge.bad.Vehicle("air", 1967);
        modern.challenge.bad.JumpJet jjBad = new modern.challenge.bad.JumpJet("air", 1967, "Harrier");

        System.out.println("jjBad equal vBad: " + jjBad.equals(vBad));
        System.out.println("vBad equal jjBad: " + vBad.equals(jjBad));        
        
        System.out.println();
                
        // good
        modern.challenge.good.Vehicle vGood = new modern.challenge.good.Vehicle("air", 1967);
        modern.challenge.good.JumpJet jjGood = new modern.challenge.good.JumpJet("air", 1967, "Harrier");

        System.out.println("jjGood equal vGood: " + jjGood.equals(vGood));
        System.out.println("vGood equal jjGood: " + vGood.equals(jjGood)); 
    }

}
