package com.library.dao.impl;
import com.library.dao.BookDAO;
import com.library.model.Book;
import com.library.util.DBUtil;
import java.sql.*;
/*
// JDBC + SQL logic
 */

import java.sql.SQLException;

public class BookDAOImpl implements BookDAO {
    @Override
    public Book getBookById(int bookId){
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM books WHERE book_id = ?")) {
            ps.setInt(1, bookId);

            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return new Book(
                        rs.getInt("book_id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("category"),
                        rs.getInt("total_count"),
                        rs.getInt("available_count")
                );
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return null;    // book not found
    }

    @Override
    public boolean addBook(Book book) {
        try(Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO books (book_id, title, author, category, total_count, available_count) VALUES(?,?,?,?,?,?")) {
            ps.setInt(1, book.getId());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());
            ps.setString(4, book.getCategory());
            ps.setInt(5, book.getTotalCount());
            ps.setInt(6, book.getAvailableCount());

            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                System.out.println("Book added Successfully");
                return true;
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteBook(int bookId) {
        try(Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM books WHERE book_id = ?")) {
            ps.setInt(1, bookId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                System.out.println("Book deleted Successfully");
                return true;
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateBook(int bookId, Book book) {
        try(Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE books SET title=?, author=?, category=?, total_count=?, available_count=? WHERE book_id = ?")) {

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getCategory());
            ps.setInt(4, book.getTotalCount());
            ps.setInt(5, book.getAvailableCount());

            return ps.execute();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
