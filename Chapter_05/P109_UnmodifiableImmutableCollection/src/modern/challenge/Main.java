package modern.challenge;

public class Main {

    public static void main(String[] args) {

        System.out.println("\nUnmodifiable List Of MutableMelon But Not Immutable Via Collections.unmodifiableList():");
        UnmodifiableListOfMutableMelonButNotImmutableViaUnmodifiableList ex1
                = new UnmodifiableListOfMutableMelonButNotImmutableViaUnmodifiableList();
        ex1.proof();

        System.out.println("\nUnmodifiable List Of MutableMelon But Not Immutable Via Arrays.asList():");
        UnmodifiableListOfMutableMelonButNotImmutableViaArraysAsList ex2
                = new UnmodifiableListOfMutableMelonButNotImmutableViaArraysAsList();
        ex2.proof();

        System.out.println("\nUnmodifiable List Of MutableMelon But Not Immutable Via Static Block:");
        UnmodifiableListOfMutableMelonButNotImmutableViaStaticBlock ex3
                = new UnmodifiableListOfMutableMelonButNotImmutableViaStaticBlock();
        ex3.proof();

        System.out.println("\nUnmodifiable List Of MutableMelon But Not Immutable Via List.of():");
        UnmodifiableListOfMutableMelonButNotImmutableViaListOf ex4
                = new UnmodifiableListOfMutableMelonButNotImmutableViaListOf();
        ex4.proof();

        System.out.println("\nImmutable List Of ImmutableMelon Via Collections.unmodifiableList():");
        ImmutableListOfImmutableMelonViaUnmodifiableList ex51
                = new ImmutableListOfImmutableMelonViaUnmodifiableList();
        ex51.proof();

        System.out.println("\nImmutable List Of ImmutableMelon Via List.of():");
        ImmutableListOfImmutableMelonViaListOf ex52
                = new ImmutableListOfImmutableMelonViaListOf();
        ex52.proof();

        System.out.println("\n-----------------------------");
        System.out.println("Define an immutable array: ");

        ImmutableArray<String> sample = ImmutableArray.from(new String[]{"a", "b", "c"});
        System.out.println(sample);
    }
}
