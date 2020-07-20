/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Reserva;

/**
 *
 * @author aluno
 */
public class ModelReserva extends AbstractTableModel{

    private List<Reserva> reservas = new ArrayList<>();
    
    public Reserva getReserva(int i){
        return reservas.get(i);
    }
    
    public void adicionarReserva(Reserva reserva){
        reservas.add(reserva);
        fireTableRowsUpdated(reservas.size() - 1, reservas.size() - 1);
    }
    
    public void removerReserva(int i){
        reservas.remove(i);
        fireTableRowsDeleted(i, i);
    }
    
    public void atualizarReserva(int i){
        fireTableRowsUpdated(i, i);
    }
    
    @Override
    public int getRowCount() {
        return reservas.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Reserva reserva = reservas.get(rowIndex);
        switch(columnIndex){
            case 0:{
                return reserva.getId();
            }
            case 1:{
                return reserva.getCliente().getNome();
            }
            default:{
                return reserva.getMesa().getNumero();
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
                return "Cliente";
            }
            default:{
                return "Mesa";
            }
        }
    }
    
}
