/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Cliente;

/**
 *
 * @author aluno
 */
public class ModelCliente extends AbstractTableModel {

    private List<Cliente> clientes = new ArrayList<>();

    public void adicionarCliente(Cliente c) {
        clientes.add(c);
        fireTableRowsInserted(clientes.size() - 1, clientes.size() - 1);
    }

    public void removerCliente(int i) {
        clientes.remove(i);
        fireTableRowsDeleted(i, i);
    }

    public void atualizarCliente(int i) {
        fireTableRowsUpdated(i, i);
    }

    public Cliente getCliente(int i) {
        return clientes.get(i);
    }

    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = clientes.get(rowIndex);
        switch (columnIndex) {
            case 0: {
                return cliente.getId();
            }
            case 1: {
                return cliente.getNome();
            }
            case 2: {
                return cliente.getNascimento();
            }
            case 3: {
                return cliente.getCpf();
            }
            case 4: {
                return cliente.getEmail();
            }
            case 5: {
                return cliente.getEndereco();
            }
            case 6: {
                return cliente.getGastos();
            }
            default: {
                return cliente.getVisitas();
            }
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: {
                return "Id";
            }
            case 1: {
                return "Nome";
            }
            case 2: {
                return "Nascimento";
            }
            case 3: {
                return "Cpf";
            }
            case 4: {
                return "Email";
            }
            case 5: {
                return "Endereco";
            }
            case 6: {
                return "Gastos";
            }
            default: {
                return "Visitas";
            }
        }
    }

}
