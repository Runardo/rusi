/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Mesa;

/**
 *
 * @author aluno
 */
public class ModelMesa extends AbstractTableModel{

    private List<Mesa> mesas = new ArrayList<>();
    
    public Mesa getMesa(int i){
        return mesas.get(i);
    }
    
    public void adicionarMesas(Mesa mesa){
        mesas.add(mesa);
        fireTableRowsInserted(mesas.size() - 1, mesas.size() - 1);
    }
    
    public void removerMesas(int i){
        mesas.remove(i);
        fireTableRowsDeleted(i, i);
    }
    
    public void atualizarMesas(int i){
        fireTableRowsUpdated(i, i);
    }
    
    @Override
    public int getRowCount() {
        return mesas.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Mesa mesa = mesas.get(rowIndex);
        switch(columnIndex){
            case 0:{
                return mesa.getId();
            }
            case 1:{
                return mesa.getNumero();
            }
            default:{
                if (mesa.isReservada()) {
                    return "Reservada";
                } else {
                    return "Livre";
                }
            }
        }
    }
    
    @Override
    public String getColumnName(int i){
        switch(i){
            case 0:{
                return "Id";
            }
            case 1:{
                return "Número";
            }
            default:{
                return "Situação";
            }
        }
    }
    
}
