package patterns.bridge.impl;

import patterns.bridge.MessageImplementor;

public class MessageEmail implements MessageImplementor {

    @Override
    public void send(String message) {
        System.out.println("邮箱发送：" + message);
    }
}
