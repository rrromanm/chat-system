package com.example.chatsystem.ViewModel;

import com.example.chatsystem.Model.Model;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LogInViewModel implements PropertyChangeListener{
    private final Model model;
    private final StringProperty userName;
    private final StringProperty password;
    private StringProperty message;
    private final PropertyChangeSupport support;

    public LogInViewModel(Model model)
    {
        this.model = model;
        this.userName = new SimpleStringProperty("");
        this.password = new SimpleStringProperty("");
        this.message = new SimpleStringProperty("");
        this.support = new PropertyChangeSupport(this);
    }
    public void login()
    {
        try
        {
            model.login(userName.get(), password.get());

        }
        catch (Exception e)
        {
            message.setValue(e.getMessage());
        }
    }
    public void bindUsername(StringProperty property)
    {
        userName.bindBidirectional(property);
    }
    public void bindPassword(StringProperty property)
    {
        password.bindBidirectional(property);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        support.addPropertyChangeListener(listener);
    }
    public void removePropertyChangeListener(PropertyChangeListener listener){
        support.removePropertyChangeListener(listener);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Platform.runLater(() -> {
            if ("UserLoggedIn".equals(evt.getPropertyName())){
                support.firePropertyChange("UserLoggedIn", null, evt.getNewValue());
            }
        });
    }
}
