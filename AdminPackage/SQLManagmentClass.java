package AdminPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static AdminPackage.DatabaseConnection.getConnection;
import static java.lang.String.valueOf;

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
            connection.close();
        }

        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public void sendNewMovie(String query)
    {
        try
        {
            Connection connection = getConnection();
            PreparedStatement update = connection.prepareStatement(query);
            update.executeUpdate();

            connection.close();
        }
        catch (Exception e)
        {
        System.out.println("Wyjątek! "+e);
        }
    }
    public void deleteMovie(String MovieName)
    {
        try
        {
            Connection connection = getConnection();
            PreparedStatement delete = connection.prepareStatement("DELETE FROM harmonogram WHERE nazwa_filmu='"+MovieName+"'");
            delete.executeUpdate();

            connection.close();
        }

        catch (Exception e)
        {
            System.out.println("Wyjątek! "+e);
        }
    }
    public void getMovieList(int idHall)
    {
        try
        {
            Connection connection = getConnection();
            String sql;
            //other statement
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM harmonogram WHERE sale_id = "+idHall);
            ResultSet result = statement.executeQuery();
            ArrayList<String> arrayList = new ArrayList<>();
            while (result.next())
            {
                id_movie = result.getString("id_filmu");
                movieName = result.getString("nazwa_filmu");
                id_hall = result.getInt("sale_id");
                time = result.getString("godzina");
            }
            connection.close();
        }

        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public static void changeDate(int idMovie, String hour)
    {
        try
        {
            Connection connection = getConnection();
            PreparedStatement delete = connection.prepareStatement("UPDATE harmonogram SET godzina = '"+hour +"' WHERE id_filmu='"+idMovie+"'");
            delete.executeUpdate();

            connection.close();
        }
        catch (Exception e)
        {
            System.out.println("Wyjątek! "+e);
        }
    }

    public static void addHall(String id_HALL) throws Exception {
        Connection connection = getConnection();
        PreparedStatement delete = connection.prepareStatement("INSERT INTO sale VALUES (?,?,?,?)");
        try
        {
            String name = "Sala "+id_HALL;
            delete.setString(1,id_HALL);
            delete.setString(2,id_HALL);
            delete.setString(3,name);
            delete.setString(4,valueOf(150));
            delete.executeUpdate();

            connection.close();
            System.out.println("Sukces!");
        }
        catch (Exception e)
        {
            System.out.println("Wyjątek! "+e);
        }
    }

    public static void deleteHall(String id_HALL)
    {
        try
        {
            Connection connection = getConnection();
            PreparedStatement delete = connection.prepareStatement("DELETE FROM sale WHERE id_sale ='"+id_HALL +"';");
            delete.executeUpdate();

            connection.close();
        }
        catch (Exception e)
        {
            System.out.println("Wyjątek! "+e);
        }
    }
}
