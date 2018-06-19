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
public class TMModelCriminalMuyPeligroso implements TableModel{
    
    private List<CriminalMuyPeligroso>listadoDeCMP;

    public TMModelCriminalMuyPeligroso(List<CriminalMuyPeligroso> listadoDeCMP) {
        this.listadoDeCMP = listadoDeCMP;
    }
    


    @Override
    public int getRowCount() {
        return listadoDeCMP.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Run";
            case 1:
                return "Cantidad de delitos";
            case 2:
                return "Anios acumulados";
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
                return Integer.class;
            case 2:
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
        CriminalMuyPeligroso c = listadoDeCMP.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return c.getRut();
            case 1:
                return c.getCantDelitos();
            case 2:
                return c.getAniosAcumulados();
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
