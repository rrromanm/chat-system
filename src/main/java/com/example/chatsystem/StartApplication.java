package com.example.chatsystem;

import com.example.chatsystem.Client.ChatClient;
import com.example.chatsystem.Client.ChatClientImplementation;
import com.example.chatsystem.Model.Model;
import com.example.chatsystem.Model.ModelManager;
import com.example.chatsystem.View.ViewHandler;
import com.example.chatsystem.ViewModel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class StartApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ChatClient client = new ChatClientImplementation("localhost", 5678);
        Model model = new ModelManager();
        ViewModelFactory viewModelFactory = new ViewModelFactory(model);
        ViewHandler viewHandler = new ViewHandler(viewModelFactory);
        viewHandler.start(stage);
    }
}
