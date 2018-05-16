/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imd.presentation;

import com.imd.data.DepartamentoDAO;
import com.imd.entity.Departamento;
import com.imd.exception.DatabaseException;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author franklin
 */
@Named(value = "MBDepartamento")
@RequestScoped
public class MBDepartamento {
    @EJB
    DepartamentoDAO dao;
    
    private Departamento departamento = new Departamento();
    
    public void add() {
        try {
            dao.insert(departamento);
            this.reset();
        } catch(DatabaseException e) {
            /* empty */
        }
    }
    
    public void remove(Departamento departamento) {
        dao.delete(departamento);
    }
    
    private void reset() {
        this.departamento = new Departamento();
    }
    
    public List<Departamento> getList() {
        return dao.selectAll();
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
