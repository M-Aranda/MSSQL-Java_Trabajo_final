
package model;

import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Marce
 */
public class TMModelDelito implements TableModel{
    
    private List<Delito> listadoDeDelitos;

    public TMModelDelito(List<Delito> listadoDeDelitos) {
        this.listadoDeDelitos = listadoDeDelitos;
    }
    
    
    
   
    @Override
    public int getRowCount() {
        return listadoDeDelitos.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

        @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Id";
            case 1:
                return "Tipo de delito";
            case 2:
                return "Run verpetrador";
            case 3:
                return "Run victima";
            case 4:
                return "Detalle";
            case 5:
                return "Fecha de deltio";
            case 6:
                return "Fecha de denuncia";
            case 7:
                return "Anios antes de preescribir";
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
                return Integer.class;
            case 2:
                return String.class;
            case 3:
                return Integer.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
            case 6:
                return String.class;
            case 7:
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
        Delito d = listadoDeDelitos.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return d.getId();
            case 1:
                return d.getFk_delito();
            case 2:
                return d.getFk_perpetrador();
            case 3:
                return d.getFk_victima();
            case 4:
                return d.getDetalle();
            case 5:
                return d.getFecha_denuncia();
            case 6:
                return d.getFecha_denuncia();
            case 7:
                return d.getAniosAntesDePreescribir();
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
