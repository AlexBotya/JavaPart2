package Serever;

public class ChatServerException extends RuntimeException{
    public ChatServerException() {
    }

    public ChatServerException(String message, Throwable cause) {
        super(message, cause);
    }
}
