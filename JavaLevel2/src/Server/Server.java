package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public Server() {
        Scanner scanner = new Scanner(System.in);
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is ready");
            System.out.println("Waiting connection...");
            Socket accept = serverSocket.accept();
            System.out.println("Connection established: " + accept);

            DataInputStream in = new DataInputStream(accept.getInputStream());
            DataOutputStream out = new DataOutputStream(accept.getOutputStream());

            new Thread(() -> {
                while (true) {
                    try {
                        String message = in.readUTF();
                        if (message.equals("-quit")) {
                            System.out.println("Client shut downed server. Bye bye )");
                            System.exit(01);
                        }
                        System.out.println("client: " + message);
                    } catch (IOException e) {
                        System.out.println("Client disconnected, server down. Bye bye");
                        System.out.println("Please press ENTER...");
                        break;
                    }
                }
            })
                    .start();

            while (true) {
                try {

                    out.writeUTF(scanner.nextLine());
                } catch (IOException e) {
                    System.out.println("Client disconnected, server down. Bye bye");
                    break;
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
