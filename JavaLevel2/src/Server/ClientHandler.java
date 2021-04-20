package Server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientHandler {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private int timeOut = 120000;

    private String name;
    private ChatServer chatServer;

    public ClientHandler(Socket socket, ChatServer chatServer) {
        this.socket = socket;
        this.chatServer = chatServer;
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            throw new ChatServerException("Something went wrong during connection establishment", e);
        }
        new Thread(() -> {
            try {
                doAuthentication();
            } catch (IOException e) {
                e.printStackTrace();
            }
            listen();
        })
                .start();
    }

    public String getName() {
        return name;
    }

    private void listen() {
        receiveMessage();

    }

    private void doAuthentication() throws IOException {
        sendMessage("Welcome! Please, do authentication.");
        while (true) {
            try {
                socket.setSoTimeout(timeOut);
                String message = in.readUTF();
                /**
                 * login pattern
                 * -auth l1 p1
                 */
                if (message.startsWith("-auth")) {
                    String[] credentialsStructure = message.split("\\s"); // s - space
                    String login = credentialsStructure[1];
                    String password = credentialsStructure[2];
                    Optional<Entry> mayBeCredentials
                            = chatServer.getAuthenticationService().findEntryCredentials(login, password);
                    if (mayBeCredentials.isPresent()) {
                        Entry credentials = mayBeCredentials.get();
                        if (!chatServer.isLoggedIn(credentials.getName())) {
                            name = credentials.getName();
                            chatServer.broadcast(String.format("User [%s] entered the chat.", name));
                            chatServer.writeToHistoryFile("User with name: " + name + " - entered the chat.");
                            loadChatHistory();
                            socket.setSoTimeout(0);
                            chatServer.subscribe(this);
                            return;
                        } else {
                            sendMessage(String.format("User with name: %s is already logged in", credentials.getName()));

                            loadChatHistory();
                        }

                    } else {
                        sendMessage("Incorrect login or password.");
                    }
                } else {
                    sendMessage("Incorrect authentication message. Please use valid command\n" +
                            "-auth your_login your_password");
                }
            } catch (IOException e) {
                throw new ChatServerException("Something went wrong during authentication", e);
            }
        }
    }

    public void receiveMessage() {
        while (true) {

            try {
                String message = in.readUTF();
                if (message.startsWith("/w")) {
                    String[] uniCastMessageSplit = message.split("\\s");
                    String destinationName = uniCastMessageSplit[1];
                    chatServer.uniCast(destinationName, "/private message from " + name + "/: " + message);

                } else {
                    chatServer.broadcast(name + ": " + message);
                    chatServer.writeToHistoryFile(name + ": " + message);
                }
            } catch (IOException e) {
                throw new ChatServerException("Something went wrong during receiving the message", e);
            }
        }
    }

    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            throw new ChatServerException("Something went wrong during sending the message", e);
        }
    }

    public void loadChatHistory() {

        File file = new File("JavaLevel2/src/Server/history.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            List<String> historyList = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                historyList.add(line);
            }
            System.out.println();
            if (historyList.size() > 100) {
                for (int i = historyList.size() - 100; i < historyList.size(); i++) {
                    sendMessage(historyList.get(i));
                }
            } else {
                for (int i = 0; i < historyList.size(); i++) {
                    sendMessage(historyList.get(i));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
