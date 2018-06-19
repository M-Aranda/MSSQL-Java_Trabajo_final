/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Marce
 */
public class Delito {
    
    private int id;
    private int fk_delito;
    private String fk_perpetrador;
    private String fk_victima;
    private String detalle;
    private String fecha_delito;
    private String fecha_denuncia;
    private int aniosAntesDePreescribir;

    public Delito(int id, int fk_delito, String fk_perpetrador, String fk_victima, String detalle, String fecha_delito, String fecha_denuncia, int aniosAntesDePreescribir) {
        this.id = id;
        this.fk_delito = fk_delito;
        this.fk_perpetrador = fk_perpetrador;
        this.fk_victima = fk_victima;
        this.detalle = detalle;
        this.fecha_delito = fecha_delito;
        this.fecha_denuncia = fecha_denuncia;
        this.aniosAntesDePreescribir = aniosAntesDePreescribir;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFk_delito() {
        return fk_delito;
    }

    public void setFk_delito(int fk_delito) {
        this.fk_delito = fk_delito;
    }

    public String getFk_perpetrador() {
        return fk_perpetrador;
    }

    public void setFk_perpetrador(String fk_perpetrador) {
        this.fk_perpetrador = fk_perpetrador;
    }

    public String getFk_victima() {
        return fk_victima;
    }

    public void setFk_victima(String fk_victima) {
        this.fk_victima = fk_victima;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getFecha_delito() {
        return fecha_delito;
    }

    public void setFecha_delito(String fecha_delito) {
        this.fecha_delito = fecha_delito;
    }

    public String getFecha_denuncia() {
        return fecha_denuncia;
    }

    public void setFecha_denuncia(String fecha_denuncia) {
        this.fecha_denuncia = fecha_denuncia;
    }

    public int getAniosAntesDePreescribir() {
        return aniosAntesDePreescribir;
    }

    public void setAniosAntesDePreescribir(int aniosAntesDePreescribir) {
        this.aniosAntesDePreescribir = aniosAntesDePreescribir;
    }

    @Override
    public String toString() {
        return "Delito{" + "id=" + id + ", fk_delito=" + fk_delito + ", fk_perpetrador=" + fk_perpetrador + ", fk_victima=" + fk_victima + ", detalle=" + detalle + ", fecha_delito=" + fecha_delito + ", fecha_denuncia=" + fecha_denuncia + ", aniosAntesDePreescribir=" + aniosAntesDePreescribir + '}';
    }
    
    
    
    
}
