package com.example.chatsystem.View;

import com.example.chatsystem.ViewModel.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;

import java.io.IOError;
import java.io.IOException;

public class ViewFactory
{
    public static final String LOGIN = "login";
    public static final String CHAT = "chat";
    private final ViewHandler viewHandler;
    private final ViewModelFactory viewModelFactory;
    private LogInViewController loginViewController;
    private ChatViewController chatViewController;

    public ViewFactory(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
        this.viewHandler = viewHandler;
        this.viewModelFactory = viewModelFactory;
        this.loginViewController = null;
        this.chatViewController = null;
    }

    public Region loadStartView(){
        if(loginViewController == null){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/example/chatsystem/LogInView.fxml"));
            try {
                Region root = loader.load();
                loginViewController = loader.getController();
                loginViewController.init(viewHandler, viewModelFactory.getLoginViewModel(), root);
                return root;
            } catch (IOException e) {
                throw new IOError(e);
            }
        }
        return loginViewController.getRoot();
    }

    public Region loadChatView(){
        if(chatViewController == null){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/example/chatsystem/ChatView.fxml"));
            try {
                Region root = loader.load();
                chatViewController = loader.getController();
                chatViewController.init(viewHandler, viewModelFactory.getChatViewModel(), root);
                return root;
            } catch (IOException e) {
                throw new IOError(e);
            }
        }
        return chatViewController.getRoot();
    }


    public Region loadView(String id){
        return switch (id){
            case LOGIN -> loadStartView();
            case CHAT -> loadChatView();
            default -> throw new IllegalArgumentException("Unknown view: " + id);

        };
    }
}
