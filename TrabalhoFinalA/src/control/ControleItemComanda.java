/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.List;
import model.Comanda;
import model.Dao;
import model.Item;
import model.ItemComanda;

/**
 *
 * @author aluno
 */
public class ControleItemComanda {

    private ControleComanda controleComanda;
    private Dao dao;
    private String msg;
    private List<ItemComanda> itens;
    private ItemComanda item;

    private static ControleItemComanda instancia;

    public static ControleItemComanda getInstancia() {
        if (instancia == null) {
            instancia = new ControleItemComanda();
        }
        return instancia;
    }

    public ItemComanda selecionar(int id) {
        return dao.selecionarItemComanda(id);
    }

    public boolean gravar(int qtd, Item item, Comanda comanda) {
        if (this.item == null) {
            this.item = new ItemComanda();
            this.item.setComanda(comanda);
            this.item.getComanda().adicionarItem(qtd, item, comanda);
            if (dao.inserir(controleComanda.getComanda())) {
                msg = "Inserido com sucesso! c:";
                this.item = null;
                return true;
            }
            msg = "Erro ao inserir :c";
            this.item = null;
            return false;
        } else {
            this.item.setComanda(comanda);
            this.item.setQuantidade(qtd);
            this.item.setItem(item);
            if (dao.editar(controleComanda.getComanda())) {
                msg = "Editado com sucesso! c:";
                this.item = null;
                return true;
            }
            msg = "Erro ao editar :c";
            this.item = null;
            return false;
        }
    }

    public boolean excluir(ItemComanda itemComanda) {
        if (dao.excluir(itemComanda)) {
            msg = "Excluído com sucesso! c:";
            return true;
        }
        msg = "Erro ao excluir :c";
        return false;
    }

    private ControleItemComanda() {
        this.dao = new Dao();
        this.controleComanda = ControleComanda.getInstancia();
        this.itens = new ArrayList<>();
        this.item = null;
    }

    public ItemComanda getItem() {
        return item;
    }

    public void setItem(ItemComanda item) {
        this.item = item;
    }

    public void carreagar() {
        itens.clear();
        for (ItemComanda ic : dao.listarItemComanda()) {
            itens.add(ic);
        }
    }

    public ControleComanda getControleComanda() {
        return controleComanda;
    }

    public void setControleComanda(ControleComanda controleComanda) {
        this.controleComanda = controleComanda;
    }

    public List<ItemComanda> getItens() {
        carreagar();
        return itens;
    }

    public void setItens(List<ItemComanda> itens) {
        this.itens = itens;
    }

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
