/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imd.data;

import com.imd.entity.Chefe;
import com.imd.entity.Departamento;
import com.imd.exception.DatabaseException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author franklin
 */
@Stateless
public class DepartamentoDAO {
    @PersistenceContext(unitName = "EmpresaPU")
    private EntityManager entityManager;
    
    public DepartamentoDAO() { }
    
    public void insert(Departamento departamento) throws DatabaseException {
        try {
            entityManager.persist(departamento);
        } catch(Exception e) {
            throw new DatabaseException();
        }
    }
    
    public void delete(Departamento departamento) {
        entityManager.remove(entityManager.find(Departamento.class, departamento.getId()));
    }
    
    public void update(Chefe chefe) {
        entityManager.merge(chefe);
    }
    
    public Chefe findById(long id) {
        return entityManager.find(Chefe.class, id);
    }
    
    public List<Departamento> selectAll() {
        TypedQuery<Departamento> result = entityManager.createNamedQuery("findAllDepartamentos", Departamento.class);
        return result.getResultList();
    }
}
