package com.library.model;

public class Librarian extends User{
    public Librarian(int userId, String name, String email, String mobile) {
        super(userId, name, email, mobile);
    }

    public String getRole() { return "Librarian"; }
}
