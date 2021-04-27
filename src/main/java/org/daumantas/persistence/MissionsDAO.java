package org.daumantas.persistence;

import org.daumantas.entities.Mission;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class MissionsDAO {

    @Inject
    private EntityManager entityManager;

    public void persist(Mission mission) {
        this.entityManager.persist(mission);
    }

    public Mission findOne(Long id) {
        return entityManager.find(Mission.class, id);
    }

    public Mission update(Mission mission) {
        return entityManager.merge(mission);
    }

    public List<Mission> loadAll() {
        return entityManager.createNamedQuery("Mission.findAll", Mission.class).getResultList();
    }
}
