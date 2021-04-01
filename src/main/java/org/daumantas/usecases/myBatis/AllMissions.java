package org.daumantas.usecases.myBatis;

import lombok.Getter;
import lombok.Setter;
import org.daumantas.myBatis.DAO.KingMissionMapper;
import org.daumantas.myBatis.model.KingMission;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Model
public class AllMissions {

    @Inject
    private KingMissionMapper kingMissionMapper;

    @Getter
    @Setter
    private List<KingMission> kingMissionList = new ArrayList<>();

    @PostConstruct
    public void init() {
        this.loadAllKingMission();
    }

    private void loadAllKingMission() {
        this.kingMissionList = kingMissionMapper.selectAll();
    }
}
