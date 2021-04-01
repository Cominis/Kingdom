package org.daumantas.usecases;

import lombok.Getter;
import lombok.Setter;
import org.daumantas.entities.Knight;
import org.daumantas.persistence.KnightsDAO;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter @Setter
public class KnightUpdate implements Serializable {
    private Knight knight;

    @Inject
    private KnightsDAO knightsDAO;

    @PostConstruct
    private void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long knightId = Long.parseLong(requestParameters.get("knightId"));
        this.knight = knightsDAO.findOne(knightId);
    }

    @Transactional
    public String updateKnightProfession() {
        try{
            knightsDAO.update(this.knight);
        } catch (OptimisticLockException e) {
            return "/knightDetails.xhtml?faces-redirect=true&knightId=" + this.knight.getId() + "&error=optimistic-lock-exception";
        }
        return "/knightDetails.xhtml?faces-redirect=true&knightId=" + this.knight.getId() + "&faces-redirect=true";
    }
}
