package Client;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public Client() {
        try {
            Socket socket = new Socket("127.0.0.1", 8080);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
