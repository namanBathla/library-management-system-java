package com.library.model;

abstract class User {
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

    int getUserId() { return this.userId; }
    String getUsername() { return this.name; }
    String getUserEmail() { return this.email; }
    String getUserMobile() { return this.mobile; }

    public abstract String getRole();
}
