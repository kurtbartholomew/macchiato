package message;

import message.Message;
import message.MessageListener;

public interface MessageProducer {

    void addMessageListener(MessageListener listener);
    void removeMessageListener(MessageListener listener);
    void sendMessage(Message message);
}
