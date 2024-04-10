package com.example.chatsystem.Model;

import com.example.chatsystem.Client.ChatClient;
import com.example.chatsystem.Client.ChatClientImplementation;
import javafx.application.Platform;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;

public class ModelManager implements Model, PropertyChangeListener
{
    private final PropertyChangeSupport support;
    private final ChatClient client;
    public ModelManager() throws IOException{
        this.client = new ChatClientImplementation("localhost", 5678);
        this.support = new PropertyChangeSupport(this);
        this.client.addPropertyChangeListener(this);
    }

    @Override
    public void disconnect() throws IOException {
        try {
            this.client.disconnect();
        } catch (IOException e) {
        throw new RuntimeException();
        }
    }

    @Override
    public void login(String username, String password) throws IOException {
        client.login(username, password);
    }

    @Override
    public void sendMsg(String msg, User user) throws IOException, InterruptedException {
        Message message = new Message(msg);
        this.client.sendMessage(message.getMsg(), user);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Platform.runLater(() -> {
            if ("UserAdded".equals(evt.getPropertyName())) {
                support.firePropertyChange("UserAdded", null, evt.getNewValue());
            } else if ("MessageSent".equals(evt.getPropertyName())) {
                support.firePropertyChange("MessageSent", null, evt.getNewValue());
            } else if ("UserLoggedIn".equals(evt.getPropertyName())){
                support.firePropertyChange("UserLoggedIn", null, evt.getNewValue());
            } else if("broadcast".equals(evt.getPropertyName())){
                support.firePropertyChange("broadcast",null,evt.getNewValue());
            }
        });
    }
}
