/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imd.data;

import com.imd.exception.DatabaseException;
import com.imd.entity.Funcionario;
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
public class FuncionarioDAO {
    @PersistenceContext(unitName = "EmpresaPU")
    private EntityManager entityManager;

    public FuncionarioDAO() { }

    public void insert(Funcionario funcionario) throws DatabaseException {
        try {
            entityManager.persist(funcionario);
        } catch (Exception e) {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            throw new DatabaseException();
        }
    }
    
    public void delete(Funcionario funcionario) {
        entityManager.remove(entityManager.find(Funcionario.class, funcionario.getId()));
    }
    
    public void update(Funcionario funcionario) {
        entityManager.merge(funcionario);
    }
    
    public Funcionario findById(long id) {
        return entityManager.find(Funcionario.class, id);
    }
    
    public List<Funcionario> selectAll() {
        TypedQuery<Funcionario> result = entityManager.createNamedQuery("findAllFuncionarios", Funcionario.class);
        return result.getResultList();
    }
}
