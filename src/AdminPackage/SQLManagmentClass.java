package AdminPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static AdminPackage.DatabaseConnection.getConnection;

public class SQLManagmentClass
{
    public void getCinemaData() throws Exception
    {
    try
    {
    Connection connection = getConnection();

    String sql;
    //other statement
    PreparedStatement statement = connection.prepareStatement("SELECT * FROM cinemaHalls");
    ResultSet result = statement.executeQuery();
    ArrayList<String> arrayList = new ArrayList<>();
    while (result.next())
    {

    }
    }
    catch (Exception e)
    {
        System.out.println(e);
    }
    }
}
