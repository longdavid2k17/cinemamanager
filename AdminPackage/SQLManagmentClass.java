package AdminPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static AdminPackage.DatabaseConnection.getConnection;

public class SQLManagmentClass
{
    public String id_movie ;
    public String movieName;
    public int id_hall;
    public String time;

    public void getCinemaData(String query) throws Exception
    {
        try
        {
            Connection connection = getConnection();
            String sql;
            //other statement
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            ArrayList<String> arrayList = new ArrayList<>();
            while (result.next())
            {
                id_movie = result.getString("id_filmu");
                movieName = result.getString("nazwa_filmu");
                id_hall = result.getInt("sale_id");
                time = result.getString("godzina");
            }
        }

        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
