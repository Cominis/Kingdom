package org.daumantas.usecases;

import lombok.Getter;
import lombok.Setter;
import org.daumantas.entities.King;
import org.daumantas.entities.Knight;
import org.daumantas.persistence.KingsDAO;
import org.daumantas.persistence.KnightsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Model
public class KnightsForKing implements Serializable {
    @Inject
    private KingsDAO kingsDAO;

    @Inject
    private KnightsDAO knightsDAO;

    @Getter
    @Setter
    private King king;

    @Getter
    @Setter
    private Knight knightToCreate = new Knight();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long kingId = Long.parseLong(requestParameters.get("kingId"));
        this.king = kingsDAO.findOne(kingId);
    }

    @Transactional
    public String createKnight() {
        try {
            knightToCreate.setKing(this.king);
            knightsDAO.persist(knightToCreate);
            return "/knights?faces-redirect=true&kingId=" + this.king.getId();
        } catch (Exception e) {
            return "/knights?faces-redirect=true&kingId=" + this.king.getId();
        }
    }
}
