/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Comanda;

/**
 *
 * @author aluno
 */
public class ModelComanda extends AbstractTableModel {
    
    private List<Comanda> comandas = new ArrayList<>();
    
    public Comanda getComanda(int i) {
        return comandas.get(i);
    }
    
    public void atualizarComanda(int i) {
        fireTableRowsUpdated(i, i);
    }
    
    public void removerComanda(int i) {
        comandas.remove(i);
        fireTableRowsDeleted(i, i);
    }
    
    public void adicionarComanda(Comanda comanda) {
        comandas.add(comanda);
        fireTableRowsInserted(comandas.size() - 1, comandas.size() - 1);
    }
    
    @Override
    public int getRowCount() {
        return comandas.size();
    }
    
    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Comanda comanda = comandas.get(rowIndex);
        switch (columnIndex) {
            case 0: {
                return comanda.getId();
            }
            case 1: {
                return comanda.getCliente().getNome();
            }
            case 2: {
                return comanda.getMesa().getNumero();
            }
            default: {
                if (comanda.isAberta()) {
                    return "Aberta";
                } else {
                    return "Fechada";
                }
            }
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: {
                return "Id";
            }
            case 1: {
                return "Cliente";
            }
            case 2: {
                return "Mesa";
            }
            default: {
                return "Situação";
            }
        }
    }
    
}
