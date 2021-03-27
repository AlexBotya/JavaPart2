package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public Client() {
        try {

            Socket socket = new Socket("127.0.0.1", 8080);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            new Thread(() -> {
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    try {
                        out.writeUTF(scanner.nextLine());
                    } catch (IOException e) {
                        System.out.println("Server down...");
                        System.out.println("Connection closed.");
                        break;
                    }
                }
            })
                    .start();
            while (true) {
                try {
                    String message = in.readUTF();
                    System.out.println("server: " + message);
                }catch (IOException e){
                    System.out.println("Pipe is closed");
                    System.out.println("Please press ENTER...");
                    break;

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
