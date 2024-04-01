package com.example.chatsystem.Model;

import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;

public interface Model
{
    String login(String nickname, String password) throws IOException, InterruptedException;
    void disconnect();
    void addPropertyChangeListener(PropertyChangeListener listener);
}
