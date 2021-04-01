package org.daumantas.persistence;

import org.daumantas.entities.Knight;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class KnightsDAO {

    @Inject
    private EntityManager entityManager;

    public void persist(Knight knight){
        this.entityManager.persist(knight);
    }

    public Knight findOne(Long id){
        return entityManager.find(Knight.class, id);
    }

    public Knight update(Knight knight){
        return entityManager.merge(knight);
    }

    public List<Knight> loadAll() {
        return entityManager.createNamedQuery("Knight.findAll", Knight.class).getResultList();
    }
}
