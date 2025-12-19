package server.network;


import java.io.*;
import java.net.Socket;
import server.model.Message;


public class ClientHandler implements Runnable {
    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;


    public ClientHandler(Socket socket) {
        this.socket = socket;
    }


    public void run() {
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());


            while (true) {
            Message message = (Message) in.readObject();
            server.service.MessageService.broadcast(message);
            }
        } catch (Exception e) {
            SocketServer.clients.remove(this);
        }
        }


    public void send(Message message) throws IOException {
        out.writeObject(message);
        out.flush();
    }
}