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
public class CriminalMuyPeligroso {
    
    private String rut;
    private int cantDelitos;
    private int aniosAcumulados;

    public CriminalMuyPeligroso(String rut, int cantDelitos, int aniosAcumulados) {
        this.rut = rut;
        this.cantDelitos = cantDelitos;
        this.aniosAcumulados = aniosAcumulados;
    }
    
    
    public CriminalMuyPeligroso(){
        
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getCantDelitos() {
        return cantDelitos;
    }

    public void setCantDelitos(int cantDelitos) {
        this.cantDelitos = cantDelitos;
    }

    public int getAniosAcumulados() {
        return aniosAcumulados;
    }

    public void setAniosAcumulados(int aniosAcumulados) {
        this.aniosAcumulados = aniosAcumulados;
    }

    @Override
    public String toString() {
        return "CriminalMuyPeligroso{" + "rut=" + rut + ", cantDelitos=" + cantDelitos + ", aniosAcumulados=" + aniosAcumulados + '}';
    }
    
    
    
}
