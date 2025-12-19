package client.network;


import java.io.*;
import java.net.Socket;
import client.model.Message;


public class ClientSocket {
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;


    public ClientSocket(String host, int port) throws IOException {
        socket = new Socket(host, port);
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
    }


    public void sendMessage(Message msg) throws IOException {
        out.writeObject(msg);
        out.flush();
    }


    public Message receiveMessage() throws IOException, ClassNotFoundException {
        return (Message) in.readObject();
    }
}