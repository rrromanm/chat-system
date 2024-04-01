package com.example.chatsystem.View;

import com.example.chatsystem.Client.Client;
import com.example.chatsystem.Server.Server;
import com.example.chatsystem.ViewModel.ChatViewModel;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ChatViewController{
    @FXML private Button button_send;
    @FXML private TextField message;
    @FXML private VBox vBox_message;
    @FXML private ScrollPane scrollPane;

    private int basePort = 12345; // Initial port number
    private final int numClients = 3; // Number of clients
    private final Server server;

    private ViewHandler viewHandler;
    private ChatViewModel viewModel;
    private Region root;
    public ChatViewController() {
        this.server = new Server(basePort);
        startServer();
    }
    public void startServer() {
        new Thread(() -> {
            server.start();
        }).start();
    }
    public void startMultipleServers() {
        for (int i = 0; i < numClients; i++) {
            int port = basePort + i;
            new Thread(() -> {
                Server server = new Server(port); // Use different port for each server
                server.start();
            }).start();
        }
    }
    public void reset() {

    }

    public Region getRoot() {
        return root;
    }
    public void init(ViewHandler viewHandler, ChatViewModel viewModel, Region root){
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        this.root = root;

        startServer();
    }

    public void appendMessage(String message) {
        Platform.runLater(() -> {
            Label label = new Label(message);
            vBox_message.getChildren().add(label);
        });
    }
    @FXML
    private void sendMessage() {
        String messageText = message.getText();
        if (!messageText.isEmpty()) {
            try {
                server.broadcastMessage(messageText);
                message.clear();  // Clear the message text field after sending
                appendMessage("You: " + messageText);  // Display the sent message in UI
            } catch (IOException e) {
                e.printStackTrace();
                // Handle error while sending message
            }
        }
    }
}
