package org.daumantas.usecases.myBatis;

import lombok.Getter;
import lombok.Setter;
import org.daumantas.myBatis.DAO.KingMapper;
import org.daumantas.myBatis.DAO.KingMissionMapper;
import org.daumantas.myBatis.model.King;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class KingsMyBatis {
    @Inject
    private KingMapper kingMapper;

    @Inject
    private KingMissionMapper kingMissionMapper;

    @Getter
    private List<King> allKings;

    @Getter @Setter
    private King kingToCreate = new King();

    @PostConstruct
    public void init() {
        this.loadAllKings();
    }


    private void loadAllKings() {
        this.allKings = kingMapper.selectAll();
    }

    public int loadMissionsCount(long kingId) {
        return kingMissionMapper.getMissionsCount(kingId);
    }

    @Transactional
    public String createKing() {
        try{
            kingMapper.insert(kingToCreate);
        }
        catch (Exception e){
            return "/MyBatis/kings?faces-redirect=true";
        }
        return "/MyBatis/kings?faces-redirect=true";
    }
}