/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "comanda")
public class Comanda implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "aberta_com")
    private boolean aberta;
    @ManyToOne
    @JoinColumn(name = "cliente")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "mesa")
    private Mesa mesa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comanda")
    private List<ItemComanda> itens = new ArrayList<>();

    public Comanda(boolean aberta, Cliente cliente, Mesa mesa) {
        this.aberta = aberta;
        this.cliente = cliente;
        this.mesa = mesa;
    }

    public Comanda() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAberta() {
        return aberta;
    }

    public void setAberta(boolean aberta) {
        this.aberta = aberta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public List<ItemComanda> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemComanda> itens) {
        this.itens = itens;
    }

    public void adicionarItem(int qtd, Item item, Comanda comanda) {
        itens.add(new ItemComanda(qtd, item, comanda));
    }
    
    @Override
    public String toString() {
        return "Cliente: " + cliente.getNome() + ", Mesa: " + mesa.getNumero();
    }

}
