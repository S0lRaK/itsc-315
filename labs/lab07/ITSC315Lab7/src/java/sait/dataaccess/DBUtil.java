package sait.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.naming.Context;
import javax.naming.InitialContext;

public class DBUtil {

    public static Connection getConnection() throws Exception {
        Connection conn;
        Class.forName ("com.mysql.jdbc.Driver").newInstance ();
        
        Context env = (Context)new InitialContext().lookup("java:comp/env");
        String username = (String)env.lookup("db-username");
        String password = (String)env.lookup("db-password");
        
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itsc315lab7", username, password);
        return conn;
    }
}
