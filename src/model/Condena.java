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
    private int fk_delito;
    private String fk_Juez;

    public Condena(int id, int fk_delito, String fk_Juez) {
        this.id = id;
        this.fk_delito = fk_delito;
        this.fk_Juez = fk_Juez;
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
