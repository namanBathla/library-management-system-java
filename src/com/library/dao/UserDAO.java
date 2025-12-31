package com.library.dao;
import com.library.model.User;

public interface UserDAO {

    public boolean addUser(User user);
    public User getUserById(int userId);
    public boolean deleteUser(int userId);
}
