package com.example.chatsystem.Client;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler extends Thread {
    private Socket socket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    public ClientHandler(Socket socket) {
        this.socket = socket;
        try {
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (!socket.isClosed()) {
                Object receivedObject = inputStream.readObject();
                // Process receivedObject
            }
        } catch (EOFException e) {
            // Handle EOF (end of stream) gracefully
            System.out.println("End of stream reached.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void sendMessage(String message) throws IOException {
        outputStream.writeObject(message);
    }
}
