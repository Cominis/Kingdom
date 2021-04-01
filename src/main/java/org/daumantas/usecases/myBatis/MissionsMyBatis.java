package org.daumantas.usecases.myBatis;

import lombok.Getter;
import lombok.Setter;
import org.daumantas.myBatis.DAO.KingMapper;
import org.daumantas.myBatis.DAO.KingMissionMapper;
import org.daumantas.myBatis.DAO.MissionMapper;
import org.daumantas.myBatis.model.King;
import org.daumantas.myBatis.model.KingMission;
import org.daumantas.myBatis.model.Mission;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Model
public class MissionsMyBatis {
    @Inject
    private KingMapper kingMapper;

    @Inject
    private MissionMapper missionMapper;

    @Inject
    private KingMissionMapper kingMissionMapper;

    @Getter @Setter
    private List<Mission> missions;

    @Getter @Setter
    private Mission mission;

    @Getter @Setter
    private King king;

    @Getter @Setter
    private KingMission kingMissionToCreate = new KingMission();

    @Getter @Setter
    private Mission missionToCreate = new Mission();


    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long kingId = Long.parseLong(requestParameters.get("kingId"));

        this.king = kingMapper.selectByPrimaryKey(kingId);
        this.missions = missionMapper.selectByKingId(kingId);

    }

    @Transactional
    public String createMission() {
        try{
            missionMapper.insert(missionToCreate);
            kingMissionToCreate.setKingsId(this.king.getId());
            kingMissionToCreate.setMissionsId(missionMapper.selectLast().getId());
            kingMissionMapper.insert(kingMissionToCreate);
        }
        catch (Exception e){
            return "/MyBatis/missions?faces-redirect=true&kingId=" + this.king.getId() + "&faces-redirect=true&error=missionTitleMustBeUnique";
        }

        return "/MyBatis/missions?faces-redirect=true&kingId="+ this.king.getId()+ "&faces-redirect=true";
    }
}
