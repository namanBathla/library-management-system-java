import java.sql.*;
public class Main {
    public static void main(String[] args) {

        System.out.println("Hello, World!");
        String url = "jdbc:mysql://localhost:3306/phonebook";
        String user = "root";
        String password = "Mysql@1234";

        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM contacts");

            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}