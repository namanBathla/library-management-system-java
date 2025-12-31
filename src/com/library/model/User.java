package com.library.model;

public abstract class User {
    protected int userId;
    protected String name;
    protected String email;
    protected String mobile;

    public User(int userId, String name, String email, String mobile) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

    public int getUserId() { return this.userId; }
    public String getUsername() { return this.name; }
    public String getUserEmail() { return this.email; }
    public String getUserMobile() { return this.mobile; }

    public abstract String getRole();
}
