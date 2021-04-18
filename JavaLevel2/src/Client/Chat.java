package Client;

import Client.GUI.API.Receiver;
import Client.GUI.ChatFrame;

public class Chat {
    private final ChatFrame frame;
    private final ChatCommunication communication;


    public Chat(String host, int port){
        communication = new ChatCommunication(host, port);
        frame = new ChatFrame(
                data -> communication.transmit(data));


        new Thread(()->{
            Receiver receiver = frame.getReceiver();
            while (true){
                String message = communication.receive();
                if (!message.isBlank()){
                    receiver.receive(message);
                }

            }
        })
                .start();
    }
}
