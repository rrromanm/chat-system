package com.example.chatsystem.Application;

import com.example.chatsystem.Client.Client;
import com.example.chatsystem.Model.Model;
import com.example.chatsystem.Model.ModelManager;
import com.example.chatsystem.View.ViewHandler;
import com.example.chatsystem.ViewModel.ViewModelFactory;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.io.IOException;

public class MyApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Model model = new ModelManager();
        ViewModelFactory viewModelFactory = new ViewModelFactory(model);
        ViewHandler viewHandler = new ViewHandler(viewModelFactory);
        viewHandler.start(stage);

        startMultipleClients("localhost", 12345, 3, viewHandler); // Example: 3 clients connecting to localhost:1234
    }
    public void startMultipleClients(String serverAddress, int serverPort, int numClients, ViewHandler viewHandler) {
        for (int i = 0; i < numClients; i++) {
            new Thread(() -> {
                Client client = new Client(serverAddress, serverPort, viewHandler); // Pass the ViewHandler instance
                client.start();
            }).start();
        }
    }
}
