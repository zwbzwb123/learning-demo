package patterns.bridge.impl;

import patterns.bridge.AbstractMessageSender;
import patterns.bridge.MessageImplementor;

public class UrgentMessageSender extends AbstractMessageSender {

    public UrgentMessageSender(MessageImplementor implementor) {
        super(implementor);
    }

    @Override
    public void sendMessage(String message) {
        message = "紧急消息:" + message;
        super.sendMessage(message);
    }
}
