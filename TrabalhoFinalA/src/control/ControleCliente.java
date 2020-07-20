/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.Cliente;
import model.Comanda;
import model.Dao;

/**
 *
 * @author aluno
 */
public class ControleCliente {

    private Cliente cliente;
    private Dao dao;
    private List<Cliente> clientes;
    private String msg;

    private static ControleCliente instancia;

    public static ControleCliente getInstancia() {
        if (instancia == null) {
            instancia = new ControleCliente();
        }
        return instancia;
    }

    public boolean verificaComandas(Cliente c) {
        ControleComanda controleComanda = ControleComanda.getInstancia();
        for (Comanda comanda : controleComanda.getComandas()) {
            if (comanda.getCliente().getId() == c.getId() && comanda.isAberta()) {
                return true;
            }
        }
        return false;
    }

    public void excluiComandasFechadas(Cliente c) {
        ControleComanda controleComanda = ControleComanda.getInstancia();
        for (Comanda comanda : controleComanda.getComandas()) {
            if (comanda.getCliente().getId() == c.getId() && !comanda.isAberta()) {
                controleComanda.excluir(comanda);
            }
        }
    }

    private ControleCliente() {
        cliente = null;
        dao = new Dao();
        clientes = new ArrayList<>();
        carregar();
    }

    public boolean excluir(Cliente cliente) {
        if (dao.excluir(cliente)) {
            msg = "Excluído com sucesso! c:";
            return true;
        }
        msg = "Erro ao excluir :c";
        return false;
    }

    public boolean gravar(String cpf, String nome, String nascimento, String endereco, String email, String senha, double gastos, int visitas) {
        if (cliente == null) {
            cliente = new Cliente();
            cliente.setCpf(cpf);
            cliente.setEndereco(endereco);
            cliente.setEmail(email);
            cliente.setGastos(gastos);
            cliente.setNascimento(nascimento);
            cliente.setNome(nome);
            cliente.setSenha(senha);
            cliente.setVisitas(visitas);
            if (dao.inserir(cliente)) {
                cliente = null;
                msg = "Inserido com sucesso! c:";
                return true;
            }
            cliente = null;
            msg = "Erro ao inserir :c";
            return false;
        } else {
            cliente.setCpf(cpf);
            cliente.setEndereco(endereco);
            cliente.setEmail(email);
            cliente.setGastos(gastos);
            cliente.setNascimento(nascimento);
            cliente.setNome(nome);
            cliente.setSenha(senha);
            cliente.setVisitas(visitas);
            if (dao.editar(cliente)) {
                cliente = null;
                msg = "Editado com sucesso! c:";
                return true;
            }
            cliente = null;
            msg = "Erro ao editar :c";
            return false;
        }
    }

    public void carregar() {
        clientes.clear();
        for (Cliente c : dao.listarClientes()) {
            clientes.add(c);
        }
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public List<Cliente> getClientes() {
        carregar();
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public boolean geraRelatorio() {
        Document document = new Document();
        Calendar calendario = Calendar.getInstance();
        String data = ((calendario.get(Calendar.DAY_OF_MONTH) < 10) ? "0" : "") + calendario.get(Calendar.DAY_OF_MONTH) + "-";
        data += ((calendario.get(Calendar.MONTH) < 10) ? "0" : "") + (calendario.get(Calendar.MONTH) + 1) + "-";
        data += ((calendario.get(Calendar.YEAR) < 10) ? "0" : "") + calendario.get(Calendar.YEAR) + " ";
        data += ((calendario.get(Calendar.HOUR_OF_DAY) < 10) ? "0" : "") + calendario.get(Calendar.HOUR_OF_DAY) + ":";
        data += ((calendario.get(Calendar.MINUTE) < 10) ? "0" : "") + calendario.get(Calendar.MINUTE) + ":";
        data += ((calendario.get(Calendar.SECOND) < 10) ? "0" : "") + calendario.get(Calendar.SECOND);
        String aniversario = ((calendario.get(Calendar.DAY_OF_MONTH) < 10) ? "0" : "") + calendario.get(Calendar.DAY_OF_MONTH) + "-";
        aniversario += ((calendario.get(Calendar.MONTH) < 10) ? "0" : "") + (calendario.get(Calendar.MONTH) + 1);
        try {
            System.out.println(data);
            PdfWriter.getInstance(document, new FileOutputStream("/home/aluno/Relatório(" + data + ").pdf"));
            System.out.println();
            document.open();
            for (Cliente c : dao.listarClientes()) {
                if (aniversario.equals(c.getNascimento().substring(0, 5))) {
                    document.add(new Paragraph(c.toString() + " - " + c.getEmail()));
                }
            }
            document.add(new Paragraph(""));
            document.add(new Paragraph(data));
            document.close();
        } catch (DocumentException | FileNotFoundException ex) {
            System.out.println("Error:" + ex);
            document.close();
            return false;
        }
        try {
            Desktop.getDesktop().open(new File("/home/aluno/Relatório(" + data + ").pdf"));
            return true;
        } catch (IOException ex) {
            System.out.println("Error:" + ex);
            return false;
        }
    }
}
