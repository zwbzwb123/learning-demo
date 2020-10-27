package patterns.bridge.impl;

import com.sun.xml.internal.ws.api.model.MEP;
import patterns.bridge.MessageImplementor;

public class MessageSMS implements MessageImplementor {

    @Override
    public void send(String message) {
        System.out.println("SMS发送 "+ message);
    }
}
