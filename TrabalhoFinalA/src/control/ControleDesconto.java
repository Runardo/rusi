/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.persistence.PersistenceException;
import model.Dao;
import model.Desconto;

/**
 *
 * @author aluno
 */
public class ControleDesconto {

    private Dao dao;
    private Desconto desconto;
    private String msg;
    private static ControleDesconto instancia;

    public static ControleDesconto getInstancia() {
        if (instancia == null) {
            instancia = new ControleDesconto();
        }
        return instancia;
    }

    private ControleDesconto() {
        dao = new Dao();
        if (dao.selecionarDesconto() == null) {
            desconto = new Desconto();
            dao.inserirDesconto(desconto);
        } else {
            desconto = dao.selecionarDesconto();
        }
    }

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public Desconto getDesconto() {
        return desconto;
    }

    public void setDesconto(Desconto desconto) {
        this.desconto = desconto;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean gravarGastos(double a, double b) {
        desconto.setGastoNecessario(a);
        desconto.setPercentualGastos(b / 100);
        if (dao.editar(desconto)) {
            msg = "Editado com sucesso! c:";
            return true;
        }
        msg = "Erro ao editar :c";
        return false;
    }

    public boolean gravarVisitas(int a, double b) {
        desconto.setVisitasNecessarias(a);
        desconto.setPercentualVisitas(b / 100);
        if (dao.editar(desconto)) {
            msg = "Editado com sucesso! c:";
            return true;
        }
        msg = "Erro ao editar :c";
        return false;
    }

    public boolean gravarAniversario(double a) {
        desconto.setPercentualAniversario(a / 100);
        if (dao.editar(desconto)) {
            msg = "Editado com sucesso! c:";
            return true;
        }
        msg = "Erro ao editar :c";
        return false;
    }

}
