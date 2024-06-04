package org.example.schoolmanager.models;

import org.example.schoolmanager.interfaces.UserInterfaces;

public class User implements UserInterfaces {
    private int id;
    private String email;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void register(User user) {

    }

    @Override
    public int signIn(User user) {
        return 0;
    }
}
