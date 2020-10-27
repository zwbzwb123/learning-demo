package patterns.bridge.impl;

import patterns.bridge.AbstractMessageSender;
import patterns.bridge.MessageImplementor;

public class CommonMessageSender extends AbstractMessageSender {

    public CommonMessageSender(MessageImplementor implementor) {
        super(implementor);
    }

    @Override
    public void sendMessage(String message) {
        message = "普通消息：" + message;
        super.sendMessage(message);
    }
}
