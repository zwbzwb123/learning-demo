package patterns.command.impl;

import patterns.command.Command;
import patterns.command.Receiver;

public class AddCommand implements Command {

    private Receiver receiver;

    public AddCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.add();
    }
}
