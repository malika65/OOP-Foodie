package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionClass {
    private static Connection conn;
    private static Statement stat;
    private static ResultSet rs;
    public  Connection getConnection(){

        String dbName="mydatabase1";
        String userName="malika65";
        String password="password";
        String url = "jdbc:mysql://localhost:3306/mydatabase1?useTimezone=true&serverTimezone=GMT";
        String query = "SELECT";

        try {
            conn = DriverManager.getConnection(url,userName,password);
            stat = conn.createStatement();
            if(!conn.isClosed()){
                System.out.println("Connected");
            }else{
                System.out.println("Not Connected");
            }

        } catch (Exception e) {
            System.out.println("Error");
        }


        return conn;
    }

}