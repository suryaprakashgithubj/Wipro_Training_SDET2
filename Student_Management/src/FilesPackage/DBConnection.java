package FilesPackage;

import java.sql.*;

public class DBConnection 
{

    public static Connection getConnection() throws Exception 
    {

        String url = "jdbc:mysql://localhost:3306/mydata";
        String user = "root";
        String password = "root123";

        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(url, user, password);
    }
}