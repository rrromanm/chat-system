package com.example.chatsystem.View;

import com.example.chatsystem.ViewModel.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;

import java.io.IOError;
import java.io.IOException;

public class ViewFactory {
    public static final String START_VIEW_ID = "start";
    public static final String CHAT_VIEW_ID = "chat";
    private final ViewHandler viewHandler;
    private final ViewModelFactory viewModelFactory;
    private LogInViewController logInViewController;
    private ChatViewController chatViewController;
    public ViewFactory(ViewHandler viewHandler, ViewModelFactory viewModelFactory){
        this.viewHandler = viewHandler;
        this.viewModelFactory = viewModelFactory;
        this.logInViewController = null;
        this.chatViewController = null;
    }

    public Region loadLogInView(){
        if (logInViewController == null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/example/chatsystem/LogInView.fxml"));
            try {
                Region root = loader.load();
                logInViewController = loader.getController();
                logInViewController.init(viewHandler, viewModelFactory.getLogInViewModel(), root);
            } catch (IOException e) {
                throw new IOError(e);
            }
        }
        logInViewController.reset();
        return logInViewController.getRoot();
    }
    public Region loadChatView(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/example/chatsystem/ChatView.fxml"));
        try {
            Region root = loader.load();
            ChatViewController chatViewController = loader.getController(); // Create a new instance
            chatViewController.init(viewHandler, viewModelFactory.getChatViewModel(), root);
            chatViewController.reset();
            return root;
        } catch (IOException e) {
            throw new IOError(e);
        }
    }

    public Region loadView(String id){
        return switch (id){
            case START_VIEW_ID -> loadLogInView();
            case CHAT_VIEW_ID -> loadChatView();

            default -> throw new IllegalArgumentException("Unknown view: " + id);
        };
    }
}
