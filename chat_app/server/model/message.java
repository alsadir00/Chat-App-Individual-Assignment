package client.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Message implements Serializable {

    private String sender;
    private String content;
    private LocalDateTime time;

    public Message(String sender, String content) {
        this.sender = sender;
        this.content = content;
        this.time = LocalDateTime.now();
    }

    public String toString() {
        return sender + ": " + content;
    }
}
