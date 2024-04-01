package com.example.chatsystem.ViewModel;

import com.example.chatsystem.Model.Model;
import com.example.chatsystem.View.ChatViewController;

public class ViewModelFactory {
    private LogInViewModel logInViewModel;
    private ChatViewModel chatViewModel;
    public ViewModelFactory(Model model){
        this.chatViewModel = new ChatViewModel(model);
        this.logInViewModel = new LogInViewModel(model);
    }

    public LogInViewModel getLogInViewModel() {
        return logInViewModel;
    }

    public ChatViewModel getChatViewModel() {
        return chatViewModel;
    }
}
