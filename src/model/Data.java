package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Data {

    private final Conexion con;
    private String query;
    private ResultSet rs;

    public Data() throws ClassNotFoundException, SQLException {
        con = new Conexion("MARCELO", "soporteAPDI");
        System.out.println("En linea");
    }

    public void crearOrientacionSexual(String nombre) throws SQLException {
        query = "EXEC CRUDorientacionSexual 1,'" + nombre + "',1";
        con.ejecutar(query);
    }

    public Genero mostrarOrientacionSexual(int id) throws SQLException {
        query = "EXEC CRUDorientacionSexual " + id + ", 'nombreIrrelevante',2 ";

        rs = con.ejecutarSelect(query);

        Genero g = new Genero();
        while (rs.next()) {
            g.setId(rs.getInt(1));
            g.setNombre(rs.getString(2));
        }
        return g;

    }

    public void actualizarOrientacionSexual(int id, String nuevoNombre) throws SQLException {
        query = "EXEC CRUDorientacionSexual " + id + ",'" + nuevoNombre + "',3";
        con.ejecutar(query);
    }

    public void borrarOrientacionSexual(int id) throws SQLException {
        query = "EXEC CRUDorientacionSexual " + id + ",'nombreIreelevante',4";
        con.ejecutar(query);
    }

    public List<Genero> leerTodasLasOrientacionesSexuales() throws SQLException {
        query = "SELECT * FROM orientacionSexual";

        rs = con.ejecutarSelect(query);

        ArrayList<Genero> generos = new ArrayList();

        while (rs.next()) {
            Genero g = new Genero();
            g.setId(rs.getInt(1));
            g.setNombre(rs.getString(2));

            generos.add(g);
        }

        return generos;

    }

    public void crearTipoDeDelito(String nombre) throws SQLException {
        query = "EXEC CRUDtipoDeDelito 1,'" + nombre + "',1";
        con.ejecutar(query);

    }

}
