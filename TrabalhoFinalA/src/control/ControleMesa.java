/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.List;
import model.Dao;
import model.Mesa;

/**
 *
 * @author aluno
 */
public class ControleMesa {

    private Mesa mesa;
    private Dao dao;
    private List<Mesa> mesas = new ArrayList<>();
    private String msg;

    private static ControleMesa instancia;

    public static ControleMesa getInstancia() {
        if (instancia == null) {
            instancia = new ControleMesa();
        }
        return instancia;
    }

    private ControleMesa() {
        mesa = null;
        dao = new Dao();
        carregar();
    }

    public boolean excluir(Mesa mesa){
        if (dao.excluir(mesa)) {
            msg = "Excluído com sucesso! c:";
            return true;
        }
        msg = "Erro ao excluir :c";
        return false;
    }
    
    public boolean gravar(int numero) {
        if (mesa == null) {
            mesa = new Mesa();
            mesa.setNumero(numero);
            if (dao.inserir(mesa)) {
                mesa = null;
                msg = "Inserido com sucesso! c:";
                return true;
            }
            mesa = null;
            msg = "Erro ao inserir :c";
            return false;
        } else {
            mesa.setNumero(numero);
            if (dao.editar(mesa)) {
                mesa = null;
                msg = "Editado com sucesso! c:";
                return true;
            }
            mesa = null;
            msg = "Erro ao editar :c";
            return false;
        }
    }

    public void carregar() {
        mesas.clear();
        for (Mesa m : dao.listarMesas()) {
            mesas.add(m);
        }
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public List<Mesa> getMesas() {
        carregar();
        return mesas;
    }

    public void setMesas(List<Mesa> mesas) {
        this.mesas = mesas;
    }

}
