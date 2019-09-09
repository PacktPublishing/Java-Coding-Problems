package modern.challenge;

import java.util.ArrayList;
import java.util.List;

public class Sequence {

    private final List<Command> commands = new ArrayList<>();

    public void recordSequence(Command cmd) {
        commands.add(cmd);
    }

    public void runSequence() {
        commands.forEach(Command::execute);
    }
    
    public void clearSequence() {
        commands.clear();
    }
}
