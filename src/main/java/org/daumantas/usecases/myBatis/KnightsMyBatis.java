package org.daumantas.usecases.myBatis;

import lombok.Getter;
import lombok.Setter;
import org.daumantas.myBatis.DAO.KingMapper;
import org.daumantas.myBatis.DAO.KnightMapper;
import org.daumantas.myBatis.model.King;
import org.daumantas.myBatis.model.Knight;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Model
public class KnightsMyBatis {
    @Inject
    private KingMapper kingMapper;

    @Inject
    private KnightMapper knightMapper;

    @Getter
    @Setter
    private List<Knight> allKnights;

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
        this.king = kingMapper.selectByPrimaryKey(kingId);
        this.allKnights = knightMapper.selectByKingId(kingId);
    }

    @Transactional
    public String createKnight() {
        try {
            knightToCreate.setKingId(this.king.getId());
            knightMapper.insert(knightToCreate);
        } catch (Exception e) {
            return "/MyBatis/knights?faces-redirect=true&kingId=" + this.king.getId() + "&faces-redirect=true";

        }
        return "/MyBatis/knights?faces-redirect=true&kingId=" + this.king.getId() + "&faces-redirect=true";
    }
}
