package AdminPackage;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection
{
    public static Connection getConnection() throws Exception
    {
        try
        {
            ///24.196.52.166
            String driver = "com.mysql.jdbc.Driver";
            ///// adres do hostingu !!! potrzebny dostep zdalny do bazy
            String url = "jdbc:mysql://localhost:3306/cinema";
            String username = "root";
            String password = "";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        return null;
    }
}
