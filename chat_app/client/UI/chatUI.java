import client.controller.ChatController;
import client.network.ClientSocket;
import client.model.Message;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ChatUI extends Application {
        private TextArea chatArea;
        private TextField input;


        public ChatUI() {
            launch();
        }


        @Override
        public void start(Stage stage) throws Exception {
            ClientSocket socket = new ClientSocket("localhost", 5000);
            ChatController controller = new ChatController(socket);


            chatArea = new TextArea();
            chatArea.setEditable(false);


            input = new TextField();
            input.setOnAction(e -> {
                try {
                    controller.sendMessage("User", input.getText());
                    input.clear();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });

            new Thread(() -> {
                try {
                    while (true) {
                        Message msg = socket.receiveMessage();
                        chatArea.appendText(msg.getSender() + ": " + msg.getContent() + "\n");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

            VBox root = new VBox(chatArea, input);
            stage.setScene(new Scene(root, 400, 500));
            stage.setTitle("Java Socket Chat");
            stage.show();

        }
}