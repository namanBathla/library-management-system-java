package com.library.model;

public class Student extends User{
    public Student(int userId, String name, String email, String mobile) {
        super(userId, name, email, mobile);
    }

    public String getRole() {
        return "Student";
    }
}
