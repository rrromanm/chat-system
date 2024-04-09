package com.example.chatsystem.Client;

import com.example.chatsystem.Model.User;
import com.example.chatsystem.Server.StreamsFactory;
import com.google.gson.Gson;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClientImplementation implements ChatClient
{
    private final Socket socket;
    private final PrintWriter writer;
    private final BufferedReader reader;
    private final Gson gson;
    private final PropertyChangeSupport support;
    private final MessageListener listener;
    private String username;

    public ChatClientImplementation(String host, int port) throws IOException{
        socket = new Socket(host, port);
        writer = StreamsFactory.createWriter(socket);
        reader = StreamsFactory.createReader(socket);
        gson = new Gson();
        username = null;
        support = new PropertyChangeSupport(this);

        listener = new MessageListener(this, "230.0.0.0", 8888);
        Thread thread = new Thread(listener);
        thread.start();
    }


    @Override
    public void disconnect() throws IOException {

    }

    @Override
    public boolean login(String username, String password) throws IOException {
        return false;
    }

    @Override
    public void sendMessage(String msg, User user) throws IOException {

    }

    @Override
    public void addUser(User user) throws IOException {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {

    }

    @Override
    public void receiveBroadcast(String message) {

    }
}
