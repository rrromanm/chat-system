package com.example.chatsystem.View;

import com.example.chatsystem.ViewModel.ViewModelFactory;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class ViewHandler
{
    private final Scene currentScene;
    private Stage primaryStage;
    private final ViewFactory viewFactory;

    public ViewHandler(ViewModelFactory viewModelFactory)
    {
        this.viewFactory = new ViewFactory(this, viewModelFactory);
        this.currentScene = new Scene(new Region());
    }

    public void start(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        openView(ViewFactory.CHAT_VIEW_ID);
    }

    public void openView(String id)
    {
        Region root = viewFactory.loadView(id);
        currentScene.setRoot(root);
        if(root.getUserData() == null)
            primaryStage.setTitle("");
        else
            primaryStage.setTitle(root.getUserData().toString());
        primaryStage.setScene(currentScene);
        primaryStage.sizeToScene();
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void closeView()
    {
        primaryStage.close();
    }
}