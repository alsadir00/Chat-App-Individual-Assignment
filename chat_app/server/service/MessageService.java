package server.service;


import server.model.Message;
import server.network.SocketServer;
import server.network.ClientHandler;


import java.io.IOException;


public class MessageService {


    public static void broadcast(Message message) {
        for (ClientHandler client : SocketServer.clients) {
            try {
                client.send(message);
            } catch (IOException e) {
                SocketServer.clients.remove(client);
            }
        }
    }
}