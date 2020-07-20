/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.List;
import model.Dao;
import model.Item;

/**
 *
 * @author aluno
 */
public class ControleItem {

    private Item item;
    private Dao dao;
    private List<Item> itens;
    private String msg;

    public void carregar() {
        itens.clear();
        for (Item i : dao.listarItens()) {
            itens.add(i);
        }
    }

    public boolean excluir(Item item){
        if (dao.excluir(item)) {
            msg = "Excluído com sucesso! c:";
            return true;
        }
        msg = "Erro ao excluir :c";
        return false;
    }
    
    public boolean gravar(String nome, double valor) {
        if (item == null) {
            item = new Item();
            item.setNome(nome);
            item.setValor(valor);
            if (dao.inserir(item)) {
                item = null;
                msg = "Inserido com sucesso! c:";
                return true;
            }
            item = null;
            msg = "Erro ao inserir :c";
            return false;
        } else {
            item.setNome(nome);
            item.setValor(valor);
            if (dao.editar(item)) {
                item = null;
                msg = "Editado com sucesso! c:";
                return true;
            }
            item = null;
            msg = "Erro ao editar :c";
            return false;
        }
    }

    private static ControleItem instancia;

    public static ControleItem getInstancia() {
        if (instancia == null) {
            instancia = new ControleItem();
        }
        return instancia;
    }

    private ControleItem() {
        this.item = null;
        this.dao = new Dao();
        this.itens = new ArrayList<>();
        carregar();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public List<Item> getItens() {
        carregar();
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}
