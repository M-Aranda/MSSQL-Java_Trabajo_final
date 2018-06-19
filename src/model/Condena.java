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
public class Condena {

    private int id;
    private String fk_Juez;
    private String apellidoJuez;
    private int fk_delito;
    private String nombreDelito;

    public Condena(int id, int fk_delito, String fk_Juez) {
        this.id = id;
        this.fk_delito = fk_delito;
        this.fk_Juez = fk_Juez;
    }

    public Condena(int id, String fk_Juez, String apellidoJuez, int fk_delito, String nombreDelito) {
        this.id = id;
        this.fk_Juez = fk_Juez;
        this.apellidoJuez = apellidoJuez;
        this.fk_delito = fk_delito;
        this.nombreDelito = nombreDelito;
    }

    public Condena(){
        
    }

    public String getApellidoJuez() {
        return apellidoJuez;
    }

    public void setApellidoJuez(String apellidoJuez) {
        this.apellidoJuez = apellidoJuez;
    }

    public String getNombreDelito() {
        return nombreDelito;
    }

    public void setNombreDelito(String nombreDelito) {
        this.nombreDelito = nombreDelito;
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

    public String getFk_Juez() {
        return fk_Juez;
    }

    public void setFk_Juez(String fk_Juez) {
        this.fk_Juez = fk_Juez;
    }

    @Override
    public String toString() {
        return "Condena{" + "id=" + id + ", fk_delito=" + fk_delito + ", fk_Juez=" + fk_Juez + '}';
    }

}
