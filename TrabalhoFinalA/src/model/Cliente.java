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
import javax.persistence.Table;

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable{
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "cpf_cli")
    private String cpf;
    @Column(name = "nome_cli")
    private String nome;
    @Column(name = "nascimento_cli")
    private String nascimento;
    @Column(name = "endereco_cli")
    private String endereco;
    @Column(name = "email_cli")
    private String email;
    @Column(name = "senha")
    private String senha;
    @Column(name = "gastos")
    private double gastos;
    @Column(name = "visitas")
    private int visitas;

    public Cliente(String cpf, String nome, String nascimento, String endereco, String email, String senha, double gastos, int visitas) {
        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = nascimento;
        this.endereco = endereco;
        this.email = email;
        this.senha = senha;
        this.gastos = gastos;
        this.visitas = visitas;
    }

    public Cliente() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getGastos() {
        return gastos;
    }

    public void setGastos(double gastos) {
        this.gastos = gastos;
    }

    public int getVisitas() {
        return visitas;
    }

    public void setVisitas(int visitas) {
        this.visitas = visitas;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    
}
