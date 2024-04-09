package com.example.chatsystem.Model;

import java.util.ArrayList;

public class UserList
{
    private static UserList instance;
    private ArrayList<User> users;
    private ArrayList<String> usernames;
    public UserList(){
        this.users = new ArrayList<>();
        this.usernames = new ArrayList<>();
    }

    public static synchronized UserList getInstance(){
        if (instance == null)
        {
            instance = new UserList();
        }
        return instance;
    }

    public synchronized void addUser(User user){
        if (!users.contains(user)) {
            users.add(user);
            usernames.add(user.getUsername());
        }
    }
    public synchronized int getSize()
    {
        return users.size();
    }

    public synchronized ArrayList<String> getUsernames(){
        return usernames;
    }

    @Override
    public String toString() {
        String users = "";
        for(int i = 0; i < usernames.size(); i++){
            users += usernames.get(i) + "\n";
        }
        return users;
    }
}
