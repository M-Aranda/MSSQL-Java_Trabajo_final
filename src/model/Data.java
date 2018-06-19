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

    public void crearJuez(String run, String nombre, String apellido, int edad, String genero, String sexo) throws SQLException {
        query = "EXEC CRUDjuez '" + run + "','" + nombre + "','" + apellido + "'," + edad + "," + genero + ",'" + sexo + "',0,1";
        con.ejecutar(query);

    }

    public Juez mostrarJuez(String run) throws SQLException {
        query = "EXEC CRUDjuez " + run + ", 'irrelevante','irrelevante',0,'irrelevante','irrelevate',0,2 ";

        rs = con.ejecutarSelect(query);

        Juez j = new Juez();
        while (rs.next()) {
            j.setRun(rs.getString(1));
            j.setNombre(rs.getString(2));
            j.setApellido(rs.getString(3));
            j.setEdad(rs.getInt(4));
            j.setGenero(rs.getString(5));
            j.setSexo(rs.getString(6));
            j.setNDeSentenciasDictadas(rs.getInt(7));
        }
        return j;

    }

    public void actualizarJuez(String run, String nombre, String apellido, int edad, String genero, String sexo) throws SQLException {
        query = "EXEC CRUDDelito '" + run + "','" + nombre + "','" + apellido + "'," + edad + "," + genero + ",'" + sexo + "',0,3";
        con.ejecutar(query);
    }

    public void borrarJuez(String run, String nombre, String apellido, int edad, String genero, String sexo) throws SQLException {
        query = "EXEC CRUDDelito '" + run + "','" + nombre + "','" + apellido + "'," + edad + "," + genero + ",'" + sexo + "',0,4";;
        con.ejecutar(query);
    }

    public List<Juez> leerTodosLosJueces() throws SQLException {
        query = "SELECT juez.run, juez.nombre, juez.apellido, juez.edad,\n"
                + " orientacionSexual.nombre, juez.sexo, juez.cantidadDeSentenciasDictadas\n"
                + " FROM orientacionSexual, juez WHERE orientacionSexual.id=juez.fk_genero";

        rs = con.ejecutarSelect(query);

        ArrayList<Juez> jueces = new ArrayList();

        while (rs.next()) {
            Juez j = new Juez();
            j.setRun(rs.getString(1));
            j.setNombre(rs.getString(2));
            j.setApellido(rs.getString(3));
            j.setEdad(rs.getInt(4));
            j.setGenero(rs.getString(5));
            j.setSexo(rs.getString(6));
            j.setNDeSentenciasDictadas(rs.getInt(7));

            jueces.add(j);
        }

        return jueces;

    }

    public void crearDelito(int id, int tipoDeDelito, String runPerpetrador, String runVictima, String detalle, String fDelito, String fDenuncia) throws SQLException {
        query = "EXEC CRUDDelito " + id + "," + tipoDeDelito + ",'" + runPerpetrador + "','" + runVictima + "','" + fDelito + "','" + fDenuncia + "',1";
        con.ejecutar(query);

    }

    public Delito mostrarDelito(int id) throws SQLException {
        query = "EXEC CRUDDelito " + id + ", 0,'irrelevante','irrelevante','irrelevante','irrelevate',2 ";

        rs = con.ejecutarSelect(query);

        Delito d = new Delito();
        while (rs.next()) {
            d.setId(rs.getInt(1));
            d.setFk_delito(rs.getInt(2));
            d.setFk_perpetrador(rs.getString(3));
            d.setFk_victima(rs.getString(4));
            d.setDetalle(rs.getString(5));
            d.setFecha_delito(rs.getString(6));
            d.setFecha_denuncia(rs.getString(7));
            d.setAniosAntesDePreescribir(rs.getInt(7));
        }
        return d;

    }

    public void actualizarDelito(int id, int tipoDeDelito, String runPerpetrador, String runVictima, String detalle, String fDelito, String fDenuncia) throws SQLException {
        query = "EXEC CRUDDelito '" + id + "','" + tipoDeDelito + "','" + runPerpetrador + "','" + runVictima + "'," + fDelito + "," + fDenuncia + ",3";
        con.ejecutar(query);

    }

    public void borrarDelito(int id) throws SQLException {
        query = "EXEC CRUDDelito " + id + ", 0,'irrelevante','irrelevante','irrelevante','irrelevate',4 ";

        con.ejecutar(query);
    }

    public List<Delito> leerTodosLosDelitos() throws SQLException {
        query = "SELECT delito.id, tipoDelito.nombre, delito.fk_perpetrador, delito.fk_victima, delito.detalle ,delito.fecha_delito, delito.fecha_denuncia, \n"
                + "delito.aniosAntesDePreescribir FROM delito, tipoDelito WHERE delito.tipo_delito_fk=tipoDelito.id";

        rs = con.ejecutarSelect(query);

        ArrayList<Delito> delitos = new ArrayList();

        while (rs.next()) {
            Delito d = new Delito();
            d.setId(rs.getInt(1));
            d.setNombreTipoDelito(rs.getString(2));
            d.setFk_perpetrador(rs.getString(3));
            d.setFk_victima(rs.getString(4));
            d.setDetalle(rs.getString(5));
            d.setFecha_delito(rs.getString(6));
            d.setFecha_denuncia(rs.getString(7));
            d.setAniosAntesDePreescribir(rs.getInt(8));

            delitos.add(d);
        }

        return delitos;

    }

    public void crearCondena(int id, String fk_juez, int fk_delito) throws SQLException {
        query = "EXEC CRUDCondena " + id + ",'" + fk_juez + "', " + fk_delito + ",1";
        con.ejecutar(query);

    }

    public Condena mostrarCondena(int id) throws SQLException {
        query = "EXEC CRUDCondena " + id + ",'irrelevate' , 'irrelevante,'2";

        rs = con.ejecutarSelect(query);

        Condena c = new Condena();
        while (rs.next()) {
            c.setId(rs.getInt(1));
            c.setFk_Juez(rs.getString(2));
            c.setFk_delito(rs.getInt(3));

        }
        return c;

    }

    public void actualizarCondena(int id, String fk_juez, int fk_delito) throws SQLException {
        query = "EXEC CRUDCondena " + id + ",'" + fk_juez + "', " + fk_delito + ",3";
        con.ejecutar(query);

    }

    public void borrarCondena(int id) throws SQLException {
        query = "EXEC CRUDCondena " + id + ", '0',1, 4 ";

        con.ejecutar(query);
    }

    public List<Condena> leerTodasLasCondenas() throws SQLException {
        query = "SELECT condena.id, condena.fk_juez, juez.apellido, condena.fk_delito, tipoDelito.nombre \n"
                + "FROM condena, delito, tipoDelito, juez WHERE condena.fk_juez=juez.run\n"
                + "AND condena.fk_delito=delito.id AND delito.tipo_delito_fk=tipoDelito.id";

        rs = con.ejecutarSelect(query);

        ArrayList<Condena> condenas = new ArrayList();

        while (rs.next()) {
            Condena c = new Condena();
            c.setId(rs.getInt(1));
            c.setFk_Juez(rs.getString(2));
            c.setApellidoJuez(rs.getString(3));
            c.setFk_delito(rs.getInt(4));
            c.setNombreDelito(rs.getString(5));

            condenas.add(c);
        }

        return condenas;

    }

    public List<CriminalMuyPeligroso> crearInformeEnTabla() throws SQLException {
        query = "EXEC determinarTOPNperpetradoresMasPeligrosos 3";

        rs = con.ejecutarSelect(query);

        ArrayList<CriminalMuyPeligroso> criminales = new ArrayList();

        while (rs.next()) {
            CriminalMuyPeligroso cmp = new CriminalMuyPeligroso();
            cmp.setRut(rs.getString(1));
            cmp.setCantDelitos(rs.getInt(2));
            cmp.setAniosAcumulados(rs.getInt(3));
            
            criminales.add(cmp);

        }

        return criminales;
        
    }

}
