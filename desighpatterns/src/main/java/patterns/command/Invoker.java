package patterns.command;

public class Invoker {

    private Command addCommand;

    private Command multiCommand;

    public void  setMultiCommand(Command command){
        this.multiCommand = command;
    }

    public void setAddCommand(Command command) {
        this.addCommand = command;
    }


    public void add(){
        if (addCommand == null)
            throw new RuntimeException("?");
        addCommand.execute();
    }

    public void multi(){
        if (multiCommand == null)
            throw new RuntimeException("?");
        multiCommand.execute();
    }
}
