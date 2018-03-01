package my_dbapp;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created on 20.06.17.
 */
public class ConnectDB {


    private static Connection connection;

    public static void main(String[] args) throws SQLException {


    }

    public void connect(String conn_string, String username, String password) {

        try {
            connection = DriverManager.getConnection(conn_string, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
