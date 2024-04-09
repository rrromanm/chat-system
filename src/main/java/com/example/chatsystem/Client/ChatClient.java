package com.example.chatsystem.Client;

import com.example.chatsystem.Model.User;

import java.beans.PropertyChangeListener;
import java.io.IOException;

public interface ChatClient
{
    void disconnect() throws IOException;
    boolean login(String username, String password) throws IOException;
    void sendMessage(String msg, User user) throws IOException;

    void addUser(User user) throws IOException;
    void addPropertyChangeListener(PropertyChangeListener listener);
    void removePropertyChangeListener(PropertyChangeListener listener);
    void receiveBroadcast(String message);
}
