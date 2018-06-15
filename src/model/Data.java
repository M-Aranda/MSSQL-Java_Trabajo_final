package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Data {

    private final Conexion con;
    private String query;
    private ResultSet rs;


    public Data() throws ClassNotFoundException, SQLException {
        con = new Conexion("MARCELO", "soporteAPDI");
        System.out.println("En linea");
    }


    public void hacerUnInsertLoco() throws SQLException{
        query="INSERT INTO orientacionSexual VALUES ('esque')";
        con.ejecutar(query);
        
    }
    
   
}
