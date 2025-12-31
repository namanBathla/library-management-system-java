package com.library.dao.impl;
import java.sql.*;
import com.library.dao.UserDAO;
import com.library.model.Librarian;
import com.library.model.Student;
import com.library.model.User;
import com.library.util.DBUtil;
import java.sql.PreparedStatement;

public class UserDAOImpl implements UserDAO {
    @Override
    public boolean addUser(User user) {
        try(Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO users(user_id, name, email, mobile, role) VALUES(?,?,?,?,?")) {

            ps.setInt(1, user.getUserId());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getUserEmail());
            ps.setString(4, user.getUserMobile());
            ps.setString(5, user.getRole());

            ResultSet rs = ps.executeQuery();
            if(rs.next()) return true;
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    @Override
    public boolean deleteUser(int userId) {
        try(Connection con = DBUtil.getConnection();
        PreparedStatement ps = con.prepareStatement("DELETE FROM users WHERE user_id = ?")) {
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                System.out.println("User" + userId + "deleted successfully");
                return true;
            }
        }

        catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User getUserById(int userId) {
        try(Connection con = DBUtil.getConnection();
        PreparedStatement ps = con.prepareStatement("")) {
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                String role = rs.getString("role");
                if(role.equals("Student")) {
                    return new Student(rs.getInt("user_id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("mobile"));
                }
                else if(role.equals("Librarian")) {
                    return new Librarian(rs.getInt("user_id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("mobile"));
                }
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
