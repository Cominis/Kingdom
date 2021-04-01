package org.daumantas.usecases;

import lombok.Getter;
import lombok.Setter;
import org.daumantas.entities.King;
import org.daumantas.persistence.KingsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Model
public class Kings implements Serializable {
    @Inject
    private KingsDAO kingsDAO;

    @Getter
    @Setter
    private King kingToCreate = new King();

    @Getter
    private List<King> allKings;

    @PostConstruct
    public void init() {
        loadAllKings();
    }

    @Transactional
    public String createKing() {
        try {
            this.kingsDAO.persist(kingToCreate);
        } catch (Exception ex) {
            return "index?faces-redirect=true&error=failed";
        }
        return "index?faces-redirect=true";
    }

    private void loadAllKings() {
        this.allKings = kingsDAO.loadAll();
    }
}
