package com.example.chatsystem.Client;

import com.example.chatsystem.View.ViewHandler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    private Socket socket;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;
    private ViewHandler viewHandler; // Add ViewHandler instance

    public Client(String serverAddress, int serverPort, ViewHandler viewHandler) {
        this.viewHandler = viewHandler; // Initialize ViewHandler instance
        try {
            socket = new Socket(serverAddress, serverPort);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
            System.out.println("Connected to server.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        // You may implement additional functionality as required by your application
    }

    public void sendMessage(String message) throws IOException {
        outputStream.writeObject(message);
    }
}
