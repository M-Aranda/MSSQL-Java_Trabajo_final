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
public class Juez {

    private String run;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String sexo;
    private int NDeSentenciasDictadas;

    public Juez(String run, String nombre, String apellido, int edad, String fk_genero, String sexo, int NDeSentenciasDictadas) {
        this.run = run;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = fk_genero;
        this.sexo = sexo;
        this.NDeSentenciasDictadas = NDeSentenciasDictadas;
    }

    Juez() {

    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getNDeSentenciasDictadas() {
        return NDeSentenciasDictadas;
    }

    public void setNDeSentenciasDictadas(int NDeSentenciasDictadas) {
        this.NDeSentenciasDictadas = NDeSentenciasDictadas;
    }

    @Override
    public String toString() {
        return "Juez{" + "run=" + run + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", fk_genero=" + genero + ", sexo=" + sexo + ", NDeSentenciasDictadas=" + NDeSentenciasDictadas + '}';
    }

}
