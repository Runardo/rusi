/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.Cliente;
import model.Comanda;
import model.Dao;
import model.ItemComanda;
import model.Mesa;

/**
 *
 * @author aluno
 */
public class ControleComanda {

    private Comanda comanda;
    private Dao dao;
    private List<Comanda> comandas;
    private String msg;

    private static ControleComanda instancia;

    public static ControleComanda getInstancia() {
        if (instancia == null) {
            instancia = new ControleComanda();
        }
        return instancia;
    }

    private ControleComanda() {
        comanda = null;
        dao = new Dao();
        comandas = new ArrayList<>();
        carregar();
    }

    public boolean excluir(Comanda comanda) {
        if (dao.excluir(comanda)) {
            msg = "Excluído com sucesso! c:";
            return true;
        }
        msg = "Erro ao excluir :c";
        return false;
    }

    public boolean fechar(boolean aberta) {
        comanda.setAberta(aberta);
        if (dao.editar(comanda)) {
            comanda = null;
            msg = "Editado com sucesso! c:";
            return true;
        }
        comanda = null;
        msg = "Erro ao editar :c";
        return false;
    }

    public boolean gravar(Cliente cliente, Mesa mesa) {
        if (comanda == null) {
            comanda = new Comanda();
            comanda.setAberta(true);
            comanda.setCliente(cliente);
            comanda.setMesa(mesa);
            if (dao.inserir(comanda)) {
                comanda = null;
                msg = "Inserido com sucesso! c:";
                return true;
            }
            comanda = null;
            msg = "Erro ao inserir :c";
            return false;
        } else {
            comanda.setCliente(cliente);
            comanda.setMesa(mesa);
            if (dao.editar(comanda)) {
                comanda = null;
                msg = "Editado com sucesso! c:";
                return true;
            }
            comanda = null;
            msg = "Erro ao editar :c";
            return false;
        }
    }

    public double fecharComanda(Comanda comanda) {
        double valor = 0;
        for (ItemComanda i : comanda.getItens()) {
            valor += i.getQuantidade() * i.getItem().getValor();
        }
        if (valor >= ControleDesconto.getInstancia().getDesconto().getGastoNecessario()) {
            valor *= (1 - ControleDesconto.getInstancia().getDesconto().getPercentualGastos());
        }
        if (comanda.getCliente().getVisitas() >= ControleDesconto.getInstancia().getDesconto().getVisitasNecessarias()) {
            valor *= (1 - ControleDesconto.getInstancia().getDesconto().getPercentualVisitas());
        }
        Calendar calendario = Calendar.getInstance();
        String aniversario = ((calendario.get(Calendar.DAY_OF_MONTH) < 10) ? "0" : "") + calendario.get(Calendar.DAY_OF_MONTH) + "-";
        aniversario += ((calendario.get(Calendar.MONTH) < 10) ? "0" : "") + (calendario.get(Calendar.MONTH) + 1);
        if (aniversario.equals(comanda.getCliente().getNascimento().substring(0, 5))) {
            valor *= (1 - ControleDesconto.getInstancia().getDesconto().getPercentualAniversario());
        }
        return valor;
    }

    public void carregar() {
        comandas.clear();
        for (Comanda c : dao.listarComandas()) {
            comandas.add(c);
        }
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public List<Comanda> getComandas() {
        carregar();
        return comandas;
    }

    public void setComandas(List<Comanda> comandas) {
        this.comandas = comandas;
    }

}
