/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imd.presentation;

import com.imd.exception.DatabaseException;
import com.imd.entity.Funcionario;
import com.imd.data.FuncionarioDAO;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author franklin
 */
@Named(value = "funcionarioManaged")
@RequestScoped
public class MBFuncionario implements Serializable {

    @EJB
    FuncionarioDAO dao;
    private Funcionario funcionario = new Funcionario();

    public void add() {
        try {
            dao.insert(funcionario);
            this.reset();
        } catch (DatabaseException e) {
            /* empty */
        }
    }

    public void remove(Funcionario funcionario) {
        dao.delete(funcionario);
    }

    private void reset() {
        funcionario = new Funcionario();
    }

    public void update() {
        dao.update(funcionario);
    }

    public List<Funcionario> getList() {
        return dao.selectAll();
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
