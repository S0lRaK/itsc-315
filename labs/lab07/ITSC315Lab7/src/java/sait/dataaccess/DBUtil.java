package sait.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

    public static Connection getConnection() throws Exception {
        Connection conn;
        Class.forName ("com.mysql.jdbc.Driver").newInstance ();
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itsc315lab7", "itsc315", "password");
        return conn;
    }
}
