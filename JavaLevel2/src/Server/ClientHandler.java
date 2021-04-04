package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Optional;

public class ClientHandler {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

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
        new Thread(()->{
            doAuthentication();
            listen();
        })
                .start();

    }

    public String getName() {
        return name;
    }

    private void listen(){
        receiveMessage();

    }

    private void doAuthentication(){
        sendMessage("Welcome! Please, do authentication.");
         while (true){
             try {
                 String message = in.readUTF();
                 /**
                  * login pattern
                  * -auth l1 p1
                  */
                 if (message.startsWith("-auth")){
                     String[] credentialsStructure = message.split("\\s"); // s - space
                     String login = credentialsStructure[1];
                     String password = credentialsStructure[2];

                     Optional<AuthenticationService.Entry> mayBeCredentials
                             = chatServer.getAuthenticationService().findEntryCredentials(login, password);
                     if(mayBeCredentials.isPresent()){
                         AuthenticationService.Entry credentials = mayBeCredentials.get();
                         if (!chatServer.isLoggedIn(credentials.getName())){
                             name = credentials.getName();
                             chatServer.broadcast(String.format("User [%s] entered the chat.", name ));
                             chatServer.subscribe(this);
                             return;
                         }
                         else{
                             sendMessage(String.format("User with name: %s is already logged in", credentials.getName()));
                         }


                     }else {
                         sendMessage("Incorrect login or password.");
                     }
                 }else {
                     sendMessage("Incorrect authentication message. Please use valid command\n" +
                             "-auth your_login your_password");
                 }
             } catch (IOException e) {
                 throw new ChatServerException("Something went wrong during authentication", e);
             }

         }
    }
    public void receiveMessage(){
        while (true){

            try {
                String message = in.readUTF();
                if (message.startsWith("/w")){
                    String[] uniCastMessageSplit = message.split("\\s"); // s - space
                    String destinationName = uniCastMessageSplit[1];
                    chatServer.uniCast(destinationName ,"/private message from " + name + "/: " + message);

                } chatServer.broadcast(name+": " + message);
            } catch (IOException e) {
                throw new ChatServerException("Something went wrong during receiving the message", e);
            }
        }

    }

    public void sendMessage(String message){
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            throw new ChatServerException("Something went wrong during sending the message", e);
        }

    }
}
