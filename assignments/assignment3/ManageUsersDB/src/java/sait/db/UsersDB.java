/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sait.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import sait.domain.User;

/**
 *
 * @author awarsyle
 */
public class UsersDB {

    public static void addUser(String username, String password) throws ClassNotFoundException, SQLException, NamingException {
        Class.forName("com.mysql.jdbc.Driver");

        Context env = (Context)new InitialContext().lookup("java:comp/env");
        String dbUsername = (String)env.lookup("db-username");
        String dbPassword = (String)env.lookup("db-password");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", dbUsername, dbPassword);

        String sql = "insert into users set username=?, password=?;";
        PreparedStatement preparedStatement;
        
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
        } finally {
            conn.close();
        }
    }

    public static void deleteUser(String username) throws ClassNotFoundException, SQLException, NamingException {
        Class.forName("com.mysql.jdbc.Driver");

        Context env = (Context)new InitialContext().lookup("java:comp/env");
        String dbUsername = (String)env.lookup("db-username");
        String dbPassword = (String)env.lookup("db-password");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", dbUsername, dbPassword);

        String sql = "delete from users where username=?;";
        PreparedStatement preparedStatement;
        
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();
        } finally {
            conn.close();
        }
    }

    public static List<User> getUsers() throws ClassNotFoundException, SQLException, NamingException {
        Class.forName("com.mysql.jdbc.Driver");
        Context env = (Context)new InitialContext().lookup("java:comp/env");
        String dbUsername = (String)env.lookup("db-username");
        String dbPassword = (String)env.lookup("db-password");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", dbUsername, dbPassword);

        String sql = "select * from users;";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        List<User> users = new ArrayList<User>();

        while (rs.next()) {
            User user = new User(rs.getString(1), rs.getString(2), rs.getBoolean(3));
            users.add(user);
        }

        rs.close();
        st.close();
        conn.close();

        return users;
    }

    public static boolean isAdmin(String username) {
        boolean isAdmin = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Context env = (Context)new InitialContext().lookup("java:comp/env");
            String dbUsername = (String)env.lookup("db-username");
            String dbPassword = (String)env.lookup("db-password");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", dbUsername, dbPassword);

            String sql = "select admin from users where username=?;";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                isAdmin = rs.getBoolean(1);
            }

            rs.close();
            preparedStatement.close();
            conn.close();
        } catch (Exception ex) {
        }
        return isAdmin;
    }

    public static boolean validate(String username, String password) {
        boolean valid = false;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Context env = (Context)new InitialContext().lookup("java:comp/env");
            String dbUsername = (String)env.lookup("db-username");
            String dbPassword = (String)env.lookup("db-password");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", dbUsername, dbPassword);

            String sql = "select * from users where username=? and password=?;";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet rs = preparedStatement.executeQuery();

            int count = 0;

            while (rs.next()) {
                count++;
            }

            rs.close();
            preparedStatement.close();
            conn.close();

            if (count > 0) {
                valid = true;
            }

            return valid;
        } catch (Exception ex) {
            return false;
        }

    }
}
