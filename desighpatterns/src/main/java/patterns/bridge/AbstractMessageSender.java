package patterns.bridge;

public class AbstractMessageSender {

    MessageImplementor implementor;

    public AbstractMessageSender(MessageImplementor implementor) {
        this.implementor = implementor;
    }

    public void sendMessage(String message){
        this.implementor.send(message);
    }
}
