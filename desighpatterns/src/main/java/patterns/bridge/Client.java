package patterns.bridge;

import patterns.bridge.impl.CommonMessageSender;
import patterns.bridge.impl.MessageEmail;
import patterns.bridge.impl.MessageSMS;
import patterns.bridge.impl.UrgentMessageSender;

/*
*   桥接模式的本质是分离抽象和实现
*   Abstraction 通过接口操作具体的实现
*   两边可以独立的变化扩展
*/
public class Client {

    public static void main(String[] args) {
        AbstractMessageSender sender = new CommonMessageSender(new MessageSMS());
        sender.sendMessage("123");

        sender = new UrgentMessageSender(new MessageEmail());
        sender.sendMessage("haha");
    }
}
