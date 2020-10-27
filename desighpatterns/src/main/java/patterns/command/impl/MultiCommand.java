package patterns.command.impl;

import patterns.command.Command;
import patterns.command.Receiver;

public class MultiCommand implements Command {

    Receiver receiver;

    public MultiCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.multi();
    }
}
