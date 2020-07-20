/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "item_comanda")
public class ItemComanda implements Serializable{
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "quantidade_ic")
    private int quantidade;
    @ManyToOne
    @JoinColumn(name = "item")
    private Item item;
    @ManyToOne
    @JoinColumn(name = "comanda")
    private Comanda comanda;

    public ItemComanda(int quantidade, Item item, Comanda comanda) {
        this.quantidade = quantidade;
        this.item = item;
        this.comanda = comanda;
    }

    public ItemComanda() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

    @Override
    public String toString() {
        return "ItemComanda{" + "id=" + id + ", quantidade=" + quantidade + ", item=" + item.getNome() + ", comanda=" + comanda.getCliente().getNome() + '}';
    }

}
