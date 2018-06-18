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


    public void crearOrientacionSexual(String nombre) throws SQLException{
        query="EXEC CRUDorientacionSexual 1,'"+nombre+"',1";
        con.ejecutar(query);
        
    }
    
    public void crearTipoDeDelito(String nombre) throws SQLException{
        query="EXEC CRUDtipoDeDelito 1,'"+nombre+"',1";
        con.ejecutar(query);
        
    }
    
   
}
