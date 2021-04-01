package org.daumantas.persistence;

import org.daumantas.entities.King;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class KingsDAO {

    @Inject
    private EntityManager entityManager;

    public void persist(King king){
        this.entityManager.persist(king);
    }

    public King findOne(Long id) { return entityManager.find(King.class, id); }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<King> loadAll() {
        return entityManager.createNamedQuery("King.findAll", King.class).getResultList();
    }
}
