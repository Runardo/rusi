/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
@Table(name = "reserva")
public class Reserva implements Serializable{
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "mesa")
    private Mesa mesa;
    @ManyToOne
    @JoinColumn(name = "cliente")
    private Cliente cliente;

    public Reserva(Mesa mesa, Cliente cliente) {
        this.mesa = mesa;
        this.cliente = cliente;
    }

    public Reserva() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Reserva{" + "mesa=" + mesa.getId() + ", cliente=" + cliente.getNome() + '}';
    }
    
}
