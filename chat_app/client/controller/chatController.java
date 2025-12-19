package client.controller;


import client.network.ClientSocket;
import client.model.Message;


public class ChatController {
        private ClientSocket socket;


        public ChatController(ClientSocket socket) {
            this.socket = socket;
        }


        public void sendMessage(String sender, String content) throws Exception {
            socket.sendMessage(new Message(sender, content));
        }
}