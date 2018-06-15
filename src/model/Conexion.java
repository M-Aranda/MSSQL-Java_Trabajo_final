package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;        
import java.sql.SQLException;
import java.sql.Statement;      
 
public class Conexion {
    private Statement sen;
    private ResultSet rs;
    private Connection con;
   
    public Conexion(String server, String bd) throws ClassNotFoundException, SQLException{
        String protocolo = "jdbc:sqlserver://";
        String iSecurity = ";integratedSecurity=true";
        
        //server= nombre del server
        //bd=nombre de la base de datos
        //conexion realizada con windows authentication
       
        String url = protocolo +
                server + ";" +
                "databaseName=" + bd +iSecurity;
       
        System.out.println(url);
       
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
        con = DriverManager.getConnection(url);
    }
   
    public void ejecutar(String query) throws SQLException{
        System.out.println(query);
       
        sen = con.createStatement();
        sen.executeUpdate(query);
        close();
    }
   
    public ResultSet ejecutarSelect(String query) throws SQLException{
        System.out.println(query);
       
        sen = con.createStatement();
        rs = sen.executeQuery(query);
        return rs;
    }
   
    public void close() throws SQLException{
        sen.close();
    }
}