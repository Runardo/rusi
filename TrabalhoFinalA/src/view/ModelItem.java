/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Item;

/**
 *
 * @author aluno
 */
public class ModelItem extends AbstractTableModel{

    private List<Item> itens = new ArrayList<>();
    
    public Item getItem(int i){
        return itens.get(i);
    }
    
    public void adicionarItem(Item item){
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
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Item item = itens.get(rowIndex);
        switch(columnIndex){
            case 0:{
                return item.getId();
            }
            case 1:{
                return item.getNome();
            }
            default:{
                return "R$ " + item.getValor();
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
                return "Nome";
            }
            default:{
                return "Valor";
            }
        }
    }
    
}
