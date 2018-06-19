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
public class TMModelTipoDeDelito implements TableModel {

    private List<TipoDeDelito> listadoDeTiposDeDelitos;

    public TMModelTipoDeDelito(List<TipoDeDelito> listadoDeTiposDeDelitos) {
        this.listadoDeTiposDeDelitos = listadoDeTiposDeDelitos;
    }

    @Override
    public int getRowCount() {
        return listadoDeTiposDeDelitos.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Id";
            case 1:
                return "Nombre de delito";
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
        TipoDeDelito tp = listadoDeTiposDeDelitos.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return tp.getId();
            case 1:
                return tp.getNombre();
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
