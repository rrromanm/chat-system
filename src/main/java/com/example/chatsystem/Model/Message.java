package com.example.chatsystem.Model;

public class Message {
    private final String msg;
    public Message(String message){
        this.msg = message;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}
