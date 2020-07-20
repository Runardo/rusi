/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.ItemComanda;

/**
 *
 * @author aluno
 */
public class ModelComandaItem extends AbstractTableModel{
    
    private List<ItemComanda> itens = new ArrayList<>();
    
    public ItemComanda getItem(int i){
        return itens.get(i);
    }
    
    public void adicionarItem(ItemComanda item){
        itens.add(item);
        fireTableRowsInserted(itens.size() - 1, itens.size() - 1);
    }
    
    public void removerItem(int i){
        itens.remove(i);
        fireTableRowsDeleted(i, i);
    }
    
    public void atualizarItem(int i){
        fireTableRowsUpdated(i, i);
    }
    
    @Override
    public int getRowCount() {
        return itens.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ItemComanda item = itens.get(rowIndex);
        switch(columnIndex){
            case 0:{
                return item.getItem().getId();
            }
            case 1:{
                return item.getItem().getNome();
            }
            case 2:{
                return "R$ " + item.getItem().getValor() * item.getQuantidade();
            }
            default:{
                return item.getQuantidade();
            }
        }
    }
    
    @Override
    public String getColumnName(int i){
        switch(i){
            case 0:{
                return "Id do Item";
            }
            case 1:{
                return "Nome";
            }
            case 2:{
                return "Valor";
            }
            default:{
                return "Quantidade";
            }
        }
    }
    
}
