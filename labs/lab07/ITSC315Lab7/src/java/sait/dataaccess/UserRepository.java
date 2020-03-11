package sait.dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sait.domainmodel.User;

public class UserRepository {
   
    public int insert(User user) throws Exception  {
        Connection conn = DBUtil.getConnection();
        String query = "INSERT INTO user values (?,?,?,?,?);";
        
        PreparedStatement stmt;
        int rows = 0;
        try {
            stmt = conn.prepareStatement(query);
            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getFirstName());
            stmt.setString(3, user.getLastName());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getPassword());
            rows = stmt.executeUpdate();
        } finally {
            conn.close();
        }
        
        return rows;
    }

    public int update(User user) throws Exception {
        Connection conn = DBUtil.getConnection();
        String query = "UPDATE user " +
                "SET firstname=?," +
                "lastname=?," +
                "email=?," +
                "password=? " +
                "WHERE username=?;";
        
        PreparedStatement stmt;
        int rows = 0;
        try {
            stmt = conn.prepareStatement(query);
            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPassword());
            stmt.setString(5, user.getUserName());
            rows = stmt.executeUpdate();
        } finally {
            conn.close();
        }
        
        return rows;
    }

    public List<User> getAll() throws Exception  {
        List<User> users = new ArrayList<>();
        
        Connection conn = DBUtil.getConnection();
        String query = "SELECT * FROM user;";
        
        Statement stmt;
        int rows = 0;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                User user = new User(
                        rs.getString("username"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("email"),
                        rs.getString("password"));
                users.add(user);
            }
        } finally {
            conn.close();
        }
        
        return users;
    }

    public User getUser(String username) throws Exception  {
        User user = null;
        
        Connection conn = DBUtil.getConnection();
        String query = "SELECT * FROM user WHERE username=?;";
        
        PreparedStatement stmt;
        int rows = 0;
        try {
            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user = new User(
                        rs.getString("username"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("email"),
                        rs.getString("password"));
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        } finally {
            conn.close();
        }
        
        return user;
    }

    public int delete(User user) throws Exception  {
        Connection conn = DBUtil.getConnection();
        String query = "DELETE FROM user WHERE username=?;";
        
        PreparedStatement stmt;
        int rows = 0;
        try {
            stmt = conn.prepareStatement(query);
            stmt.setString(1, user.getUserName());
            rows = stmt.executeUpdate();
        } finally {
            conn.close();
        }
        
        return rows;
    }
}
