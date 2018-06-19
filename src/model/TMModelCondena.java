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
public class TMModelCondena implements TableModel{
    
    private List<Condena> listadoDeCondenas;

    public TMModelCondena(List<Condena> listadoDeCondenas) {
        this.listadoDeCondenas = listadoDeCondenas;
    }
    
    

    @Override
    public int getRowCount() {
        return listadoDeCondenas.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Id";
            case 1:
                return "Run de juez";
            case 2:
                return "Apellido de juez";
            case 3:
                return "Id de delito";
            case 4:
                return "Tipo de delito";
            default:
                return null;
        }

    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return Integer.class;
            case 4:
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
        Condena c = listadoDeCondenas.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return c.getId();
            case 1:
                return c.getFk_Juez();
            case 2:
                return c.getApellidoJuez();
            case 3:
                return c.getFk_delito();
            case 4:
                return c.getNombreDelito();
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
