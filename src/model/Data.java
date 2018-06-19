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

    public TipoDeDelito mostrarTipoDeDelito(int id) throws SQLException {
        query = "EXEC CRUDtipoDeDelito " + id + ", 'nombreIrrelevante',2 ";

        rs = con.ejecutarSelect(query);

        TipoDeDelito t = new TipoDeDelito();
        while (rs.next()) {
            t.setId(rs.getInt(1));
            t.setNombre(rs.getString(2));
        }
        return t;

    }

    public void actualizarTipoDeDelito(int id, String nuevoNombre) throws SQLException {
        query = "EXEC CRUDtipoDeDelito " + id + ",'" + nuevoNombre + "',3";
        con.ejecutar(query);
    }

    public void borrarTipoDeDelito(int id) throws SQLException {
        query = "EXEC CRUDtipoDeDelito " + id + ",'nombreIreelevante',4";
        con.ejecutar(query);
    }

    public List<TipoDeDelito> leerTodosLosTiposDeDelitos() throws SQLException {
        query = "SELECT * FROM tipoDelito";

        rs = con.ejecutarSelect(query);

        ArrayList<TipoDeDelito> tiposDeDelitos = new ArrayList();

        while (rs.next()) {
            TipoDeDelito tp = new TipoDeDelito();
            tp.setId(rs.getInt(1));
            tp.setNombre(rs.getString(2));

            tiposDeDelitos.add(tp);
        }

        return tiposDeDelitos;

    }

    public void crearVictima(String run, String nombre, String apellido, int edad, String genero, String sexo) throws SQLException {
        query = "EXEC CRUDVictima '" + run + "','" + nombre + "','" + apellido + "'," + edad + "," + genero + ",'" + sexo + "',1";
        con.ejecutar(query);

    }

    public Victima mostrarVictima(String run) throws SQLException {
        query = "EXEC CRUDVictima " + run + ", 'irrelevante','irrelevante',0,'irrelevante','irrelevate',2 ";

        rs = con.ejecutarSelect(query);

        Victima v = new Victima();
        while (rs.next()) {
            v.setRun(rs.getString(1));
            v.setNombre(rs.getString(2));
            v.setApellido(rs.getString(3));
            v.setEdad(rs.getInt(4));
            v.setGenero(rs.getString(5));
            v.setSexo(rs.getString(6));
        }
        return v;

    }

    public void actualizarVictima(String run, String nombre, String apellido, int edad, String genero, String sexo) throws SQLException {
        query = "EXEC CRUDVictima '" + run + "','" + nombre + "','" + apellido + "'," + edad + "," + genero + ",'" + sexo + "',3";
        con.ejecutar(query);
    }

    public void borrarVictima(String run) throws SQLException {
        query = "EXEC CRUDVictima " + run + ", 'irrelevante','irrelevante',0,'irrelevante','irrelevate',4 ";
        con.ejecutar(query);
    }

    public List<Victima> leerTodasLasVictimas() throws SQLException {
        query = "SELECT victima.run, victima.nombre, victima.apellido, victima.edad, orientacionSexual.nombre, victima.sexo"
                + " FROM victima, orientacionSexual WHERE orientacionSexual.id=victima.fk_genero";

        rs = con.ejecutarSelect(query);

        ArrayList<Victima> victimas = new ArrayList();

        while (rs.next()) {
            Victima v = new Victima();
            v.setRun(rs.getString(1));
            v.setNombre(rs.getString(2));
            v.setApellido(rs.getString(3));
            v.setEdad(rs.getInt(4));
            v.setGenero(rs.getString(5));
            v.setSexo(rs.getString(6));

            victimas.add(v);
        }

        return victimas;

    }

    public void crearPerpetrador(String run, String nombre, String apellido, int edad, String genero, String sexo) throws SQLException {
        query = "EXEC CRUDperpetrador '" + run + "','" + nombre + "','" + apellido + "'," + edad + "," + genero + ",'" + sexo + "',0,1";
        con.ejecutar(query);

    }

    public Perpetrador mostrarPerpetrador(String run) throws SQLException {
        query = "EXEC CRUDperpetrador " + run + ", 'irrelevante','irrelevante',0,'irrelevante','irrelevate',0,2 ";

        rs = con.ejecutarSelect(query);

        Perpetrador p = new Perpetrador();
        while (rs.next()) {
            p.setRun(rs.getString(1));
            p.setNombre(rs.getString(2));
            p.setApellido(rs.getString(3));
            p.setEdad(rs.getInt(4));
            p.setGenero(rs.getString(5));
            p.setSexo(rs.getString(6));
            p.setCantDelitos(rs.getInt(7));
        }
        return p;

    }

    public void actualizarPerpetrador(String run, String nombre, String apellido, int edad, String genero, String sexo) throws SQLException {
        query = "EXEC CRUDperpetrador '" + run + "','" + nombre + "','" + apellido + "'," + edad + "," + genero + ",'" + sexo + "',0,3";
        con.ejecutar(query);
    }

    public void borrarPerpetrador(String run, String nombre, String apellido, int edad, String genero, String sexo) throws SQLException {
        query = "EXEC CRUDperpetrador '" + run + "','" + nombre + "','" + apellido + "'," + edad + "," + genero + ",'" + sexo + "',0,4";;
        con.ejecutar(query);
    }

    public List<Perpetrador> leerTodosLosPerpetradores() throws SQLException {
        query = "SELECT perpetrador.run, perpetrador.nombre, perpetrador.apellido, perpetrador.edad, orientacionSexual.nombre, perpetrador.sexo, perpetrador.cantidadDeDelitosCometidos"
                + " FROM perpetrador, orientacionSexual WHERE orientacionSexual.id=perpetrador.fk_genero";

        rs = con.ejecutarSelect(query);

        ArrayList<Perpetrador> perpetradores = new ArrayList();

        while (rs.next()) {
            Perpetrador p = new Perpetrador();
            p.setRun(rs.getString(1));
            p.setNombre(rs.getString(2));
            p.setApellido(rs.getString(3));
            p.setEdad(rs.getInt(4));
            p.setGenero(rs.getString(5));
            p.setSexo(rs.getString(6));
            p.setCantDelitos(rs.getInt(7));

            perpetradores.add(p);
        }

        return perpetradores;

    }

}
