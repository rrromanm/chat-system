package com.example.chatsystem.View;

import com.example.chatsystem.ViewModel.LogInViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class LogInViewController {

    @FXML private TextField username;
    @FXML private TextField password;
    @FXML private Button register;
    @FXML private Button login;
    @FXML private Label error;

    private ViewHandler viewHandler;
    private LogInViewModel viewModel;
    private Region root;

    public void init(ViewHandler viewHandler, LogInViewModel viewModel, Region root){
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        this.root = root;
    }

    @FXML public void onLOGIN(){
        viewModel.start();
        viewHandler.openView(ViewFactory.CHAT_VIEW_ID);
    }

    public void reset() {

    }

    public Region getRoot() {
        return root;
    }

    // Add setter method for the username field
    @FXML
    public void setUsername(TextField username) {
        this.username = username;
    }
}
