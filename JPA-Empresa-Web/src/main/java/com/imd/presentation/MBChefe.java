/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imd.presentation;

import com.imd.data.ChefeDAO;
import com.imd.entity.Chefe;
import com.imd.exception.DatabaseException;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author franklin
 */
@Named(value = "MBChefe")
@RequestScoped
public class MBChefe {
    @EJB
    ChefeDAO dao;
    
    private Chefe chefe = new Chefe();
    
    public void add() {
        try {
            dao.insert(chefe);
            this.reset();
        } catch(DatabaseException e) {
            /* empty */
        }
    }
    
    public void remove(Chefe chefe) {
        dao.delete(chefe);
    }
    
    private void reset() {
        chefe = new Chefe();
    }
    
    public void update() {
       dao.update(chefe);
    }
    
    public List<Chefe> getList() {
        return dao.selectAll();
    }

    public Chefe getChefe() {
        return chefe;
    }

    public void setChefe(Chefe chefe) {
        this.chefe = chefe;
    }
}
