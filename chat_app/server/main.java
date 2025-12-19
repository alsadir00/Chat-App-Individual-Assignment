package server;

import server.network.SocketServer;

public class MainServer {
    public static void main(String[] args) {
        SocketServer server = new SocketServer(5000);
        server.start();
    }
}
