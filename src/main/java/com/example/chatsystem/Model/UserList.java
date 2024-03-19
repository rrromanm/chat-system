package com.example.chatsystem.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class UserList implements Serializable
{
    private static UserList instance;
    private final ArrayList<User> users;
    private final ArrayList<String> usernames;
    public UserList(){
        this.users = new ArrayList<>();
        this.usernames = new ArrayList<>();
    }

    public static UserList getInstance() {
        if (instance == null){
            instance = new UserList();
        }
        return instance;
    }

    public synchronized void addUsers(User user){
        for (int i = 0; i < users.size(); i++)
        {
            if (users.get(i).equals(user))
            {
                return;
            }
        }
        users.add(user);
        usernames.add(user.getUsername());
    }

    public synchronized void ChangePerson(User user){
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).equals(user)){
                users.remove(users.get(i));
                users.add(user);
                break;
            }
        }
    }

    public synchronized ArrayList<String> getUsernames() {
        return usernames;
    }

    public synchronized ArrayList<User> getUsers() {
        return users;
    }
    public synchronized String toString()
    {
        String temp = "";
        for (int i = 0; i < users.size(); i++)
        {
            temp += users.get(i) + "\n";
        }
        return temp;
    }
}
