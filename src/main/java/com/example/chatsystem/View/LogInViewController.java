package com.example.chatsystem.View;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class LogInViewController implements ViewController{

    @FXML private TextField username;
    @FXML private TextField password;
    @FXML private Label error;

    private ViewHandler viewHandler;
    private LogInViewModel model;
    private Region region;

    @Override
    public void reset() {

    }

    @Override
    public Region getRoot() {
        return null;
    }
}
