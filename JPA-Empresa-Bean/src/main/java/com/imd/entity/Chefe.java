/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imd.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author franklin
 */
@Entity
@NamedQuery(name = "findAllChefes", query = "SELECT c FROM Chefe c")
public class Chefe implements Serializable, SampleEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SEQ_CHEFE")
    @SequenceGenerator(name = "SEQ_CHEFE", sequenceName = "seq_chefe", allocationSize = 1)
    @Column(name = "ID")
    private long id;
    
    @Column(name = "NOME")
    private String nome;
    
    @Column(name = "SALARIO")
    private double salario;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DEPARTAMENTO_ID", nullable = true)
    private Departamento departamento;
    
    public Chefe() { }
    
    @Override
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Chefe other = (Chefe) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
