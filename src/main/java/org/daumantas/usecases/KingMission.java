package org.daumantas.usecases;

import lombok.Getter;
import lombok.Setter;
import org.daumantas.entities.King;
import org.daumantas.entities.KingMissionNames;
import org.daumantas.entities.Mission;
import org.daumantas.persistence.KingsDAO;
import org.daumantas.persistence.MissionsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Model
public class KingMission implements Serializable {
    @Inject
    private KingsDAO kingsDAO;

    @Inject
    private MissionsDAO missionsDAO;

    @Getter
    @Setter
    private long kingToAttachId = -1;

    @Getter
    @Setter
    private long missionToAttachId = -1;

    @Getter
    private List<King> allKings;

    @Getter
    private List<Mission> allMissions;

    //@Getter
    //private List<KingMissionNames> kingMissionNames;

    @PostConstruct
    public void init() {
        loadAllKings();
        loadAllMissions();
        //loadKingMissionNames();
    }

    @Transactional
    public String addMissionToKing() {
        try {
            King king = kingsDAO.findOne(kingToAttachId);
            List<Mission> missions = king.getMissions();
            Mission mission = missionsDAO.findOne(missionToAttachId);
            if(!missions.contains(mission)) {
                missions.add(mission);
                king.setMissions(missions);
            }
            kingsDAO.update(king);
        } catch (Exception ex) {
            return "kingMission?faces-redirect=true&error=failed";
        }
        return "kingMission?faces-redirect=true";
    }

    private void loadAllKings() {
        this.allKings = kingsDAO.loadAll();
    }

    private void loadAllMissions() {
        this.allMissions = missionsDAO.loadAll();
    }

//    private void loadKingMissionNames() {
//        this.kingMissionNames = kingsDAO.loadKingAndMissions();
//    }
}