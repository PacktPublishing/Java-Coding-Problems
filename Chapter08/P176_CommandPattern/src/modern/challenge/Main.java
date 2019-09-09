package modern.challenge;

public class Main {

    public static void main(String[] args) {

        HardDisk hd = new HardDisk();
        Sequence sequence = new Sequence();

        System.out.println("Classic:");

        sequence.recordSequence(new CopyCommand(hd));
        sequence.recordSequence(new DeleteCommand(hd));
        sequence.recordSequence(new MoveCommand(hd));
        sequence.recordSequence(new DeleteCommand(hd));

        sequence.runSequence();

        sequence.clearSequence();

        System.out.println("\nLambda:");
        sequence.recordSequence(hd::copy);
        sequence.recordSequence(hd::delete);
        sequence.recordSequence(hd::move);
        sequence.recordSequence(hd::delete);        
        sequence.runSequence();
    }
}
