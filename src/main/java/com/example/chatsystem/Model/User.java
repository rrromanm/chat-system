package com.example.chatsystem.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable
{
    private final String username;
    private final String password;
    private final ArrayList<Message> messages;
    private final ArrayList<String> friends;
    public User (String username, String password){
        this.username = username;
        this.password = password;
        this.messages = new ArrayList<Message>();
        this.friends = new ArrayList<String>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void addMessages(Message message){
        messages.add(message);
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void addFriends(User friend){
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).equals(friend)){
                return;
            }
        }
        friends.add(friend.getUsername());
    }
    public ArrayList<String> getFriends() {
        return friends;
    }

    public boolean equals(Object obj){
        if (obj == null || obj.getClass() != getClass())
        {
            return false;
        }

        User other = (User) obj;
        return this.username.equals(other.username);
    }
}
