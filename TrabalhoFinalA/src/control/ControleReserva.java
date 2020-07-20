/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Dao;
import model.Mesa;
import model.Reserva;

/**
 *
 * @author aluno
 */
public class ControleReserva {
    private List<Reserva> reservas = new ArrayList<>();
    private Reserva reserva;
    private String msg;
    private Dao dao;

    public boolean excluir(Reserva reserva){
        if(dao.excluir(reserva)){
            msg = "Excluído com sucesso! c:";
            return true;
        }
        msg = "Erro ao excluir :c";
        return false;
    }
    
    public boolean gravar(Cliente cliente, Mesa mesa){
        if (reserva == null) {
            reserva = new Reserva();
            reserva.setCliente(cliente);
            reserva.setMesa(mesa);
            if (dao.inserir(reserva)) {
                msg = "Inserido com sucesso! c:";
                reserva = null;
                return true;
            }
            msg = "Erro ao inserir :c";
            reserva = null;
            return false;
        } else {
            reserva.setCliente(cliente);
            reserva.setMesa(mesa);
            if (dao.editar(reserva)) {
                msg = "Editado com sucesso! c:";
                reserva = null;
                return true;
            }
            msg = "Erro ao editar :c";
            reserva = null;
            return false;
        }
    }
    
    private static ControleReserva instancia;
    
    public static ControleReserva getInstancia(){
        if (instancia == null) {
            instancia = new ControleReserva();
        }
        return instancia;
    }
    
    public ControleReserva() {
        this.reserva = null;
        this.dao = new Dao();
        carregar();
    }

    public void carregar(){
        reservas.clear();
        for(Reserva r : dao.listarReservas()){
            reservas.add(r);
        }
    }
    
    public List<Reserva> getReservas() {
        carregar();
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }
    
    
}
