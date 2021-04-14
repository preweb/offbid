/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FarmCon.com.connection;

import FarmCon.com.utilities.DBParamProvider;
import FarmCon.com.utilities.PropertyReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Pratipp
 */
public class ConnectionManager 
{
    private static Connection con=null;
    private ConnectionManager()
    {
         
    }
    public static Connection getConnection(String propertiesFilePath) throws ClassNotFoundException, IOException, SQLException
    {
        DBParamProvider dbpp=PropertyReader.readProperty(propertiesFilePath);
        Class.forName(dbpp.getDriver());
        if(con==null)
            con=DriverManager.getConnection(dbpp.getDb_URL()+dbpp.getDb_name(),dbpp.getDb_username(),dbpp.getDb_password());
        return con;
    }
    public static Connection getConnection(InputStream inputFile)
    {
        DBParamProvider dbpp;
        try 
        {
            dbpp = PropertyReader.readProperty(inputFile);
            Class.forName(dbpp.getDriver());
            if(con==null)
            con=DriverManager.getConnection(dbpp.getDb_URL()+dbpp.getDb_name(),dbpp.getDb_username(),dbpp.getDb_password());
        } 
        catch (IOException ex) 
        {
            System.out.println(ex);
        }
        
        catch (ClassNotFoundException ex) 
        {
            System.out.println(ex);
        }
         
        catch (SQLException ex) 
        {
            System.out.println(ex);
        }
        return con;
    }
    private static Connection getConnection() throws URISyntaxException, SQLException {
    URI dbUri = new URI(System.getenv("DATABASE_URL"));

    String username = dbUri.getUserInfo().split(":")[0];
    String password = dbUri.getUserInfo().split(":")[1];
    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";

    return DriverManager.getConnection(dbUrl, username, password);
}
    public static void closeConnection()
    {
        try 
        {
            con.close();
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex);
        }
    }
}
