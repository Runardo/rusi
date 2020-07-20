/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "desconto")
public class Desconto implements Serializable{
    @Id
    private int id;
    @Column(name = "gasto_necessario_des")
    private double gastoNecessario;
    @Column(name = "visitas_necessarias_des")
    private int visitasNecessarias;
    @Column(name = "percentualGastos_des")
    private double percentualGastos;
    @Column(name = "percentualVisitas_des")
    private double percentualVisitas;
    @Column(name = "percentualAniversario_des")
    private double percentualAniversario;

    public Desconto() {
        this.gastoNecessario = 0;
        this.visitasNecessarias = 0;
        this.percentualGastos = 0;
        this.percentualVisitas = 0;
        this.percentualAniversario = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getGastoNecessario() {
        return gastoNecessario;
    }

    public void setGastoNecessario(double gastoNecessario) {
        this.gastoNecessario = gastoNecessario;
    }

    public int getVisitasNecessarias() {
        return visitasNecessarias;
    }

    public void setVisitasNecessarias(int visitasNecessarias) {
        this.visitasNecessarias = visitasNecessarias;
    }

    public double getPercentualGastos() {
        return percentualGastos;
    }

    public void setPercentualGastos(double percentualGastos) {
        this.percentualGastos = percentualGastos;
    }

    public double getPercentualVisitas() {
        return percentualVisitas;
    }

    public void setPercentualVisitas(double percentualVisitas) {
        this.percentualVisitas = percentualVisitas;
    }

    public double getPercentualAniversario() {
        return percentualAniversario;
    }

    public void setPercentualAniversario(double percentualAniversario) {
        this.percentualAniversario = percentualAniversario;
    }

    @Override
    public String toString() {
        return "Desconto{" + "gastoNecessario=" + gastoNecessario + ", visitasNecessarias=" + visitasNecessarias + ", percentualGastos=" + percentualGastos + ", percentualVisitas=" + percentualVisitas + ", percentualAniversario=" + percentualAniversario + '}';
    }
    
    
}
