/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sait.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sait.domain.User;

/**
 *
 * @author awarsyle
 */
public class UsersDB {

    public static void addUser(String username, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        //Open special database connection...
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users?allowMultiQueries=true", "root", "password");

        Statement st = conn.createStatement();
        String sql = "insert into users set username='" + username + "', password='" + password + "';";
        st.executeUpdate(sql);

        st.close();
        conn.close();
    }

    public static void deleteUser(String username) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        //Open special database connection...
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users?allowMultiQueries=true", "root", "password");

        Statement st = conn.createStatement();
        String sql = "delete from users where username='" + username + "'";
        st.executeUpdate(sql);

        st.close();
        conn.close();
    }

    public static List<User> getUsers() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "password");

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
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "password");

            String sql = "select admin from users where username='" + username + "';";

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                isAdmin = rs.getBoolean(1);
            }

            rs.close();
            st.close();
            conn.close();
        } catch (Exception ex) {
        }
        return isAdmin;
    }

    public static boolean validate(String username, String password) {
        try {
            boolean valid = false;

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "password");

            String sql = "select * from users where username='" + username + "' and password='" + password + "';";

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            int count = 0;

            while (rs.next()) {
                count++;
            }

            rs.close();
            st.close();
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
