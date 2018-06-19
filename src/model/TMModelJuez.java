/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Marce
 */
public class TMModelJuez implements TableModel {
    
      private List<Juez> listadoDeJueces;

    public TMModelJuez(List<Juez> listadoDePerpetradores) {
        this.listadoDeJueces = listadoDePerpetradores;
    }

    @Override
    public int getRowCount() {
        return listadoDeJueces.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

        @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Run";
            case 1:
                return "Nombre";
            case 2:
                return "Apellido";
            case 3:
                return "Edad";
            case 4:
                return "Genero";
            case 5:
                return "Sexo";
            case 6:
                return "# de sentencias";
            default:
                return null;
        }

    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return Integer.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
            case 6:
                return Integer.class;
            default:
                return null;
        }

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Juez j = listadoDeJueces.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return j.getRun();
            case 1:
                return j.getNombre();
            case 2:
                return j.getApellido();
            case 3:
                return j.getEdad();
            case 4:
                return j.getGenero();
            case 5:
                return j.getSexo();
            case 6:
                return j.getNDeSentenciasDictadas();
            default:
                return null;
        }

    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        System.out.println("");
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        System.out.println("");
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        System.out.println("");
    }

    
}
