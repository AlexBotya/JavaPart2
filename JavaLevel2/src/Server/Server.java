package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public Server(){
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is ready");
            System.out.println("Waiting connection...");
            Socket accept = serverSocket.accept();
            System.out.println("Connection established: " + accept);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
