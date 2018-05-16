/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imd.data;

import com.imd.entity.Chefe;
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
public class ChefeDAO {
    @PersistenceContext
    private EntityManager entityManager;
    
    public ChefeDAO() { }
    
    public void insert(Chefe chefe) throws DatabaseException {
        try {
            entityManager.persist(chefe);
        } catch(Exception e) {
            throw new DatabaseException();
        }
    }
    
    public void delete(Chefe chefe) {
        entityManager.remove(entityManager.find(Chefe.class, chefe.getId()));
    }
    
    // TODO
    public void update(Chefe chefe) {
        entityManager.merge(chefe);
    }
    
    public Chefe findById(long id) {
        return entityManager.find(Chefe.class, id);
    }
    
    public List<Chefe> selectAll() {
        TypedQuery<Chefe> result = entityManager.createNamedQuery("findAllChefes", Chefe.class);
        return result.getResultList();
    }
}
