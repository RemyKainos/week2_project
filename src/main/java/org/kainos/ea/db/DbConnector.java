package org.kainos.ea.db;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnector {
    private static Connection conn;

    public static Connection getConnection() throws SQLException{
        String user, password, host, name;

        if (conn != null && !conn.isClosed())
        {
            return conn;
        }
        try {
            FileInputStream propsStream = new FileInputStream("src/db.properties");

            Properties props = new Properties();
            props.load(propsStream);

            user = props.getProperty("user");
            password = props.getProperty("password");
            host = props.getProperty("host");
            name = props.getProperty("name");

            if (user == null || password == null || host == null) {
                throw new IllegalAccessException("Properties files must exist");
            }

            conn = DriverManager.getConnection("jdbc:mysql://" + host + "/" + name + "?useSSL=false", user, password);
            return conn;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        finally {
            System.out.println("I will always run.");
        }
        return null;
    }
}