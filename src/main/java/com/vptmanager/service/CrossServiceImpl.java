package com.vptmanager.service;

import com.vptmanager.dao.CrossDao;
import com.vptmanager.model.Cross;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CrossServiceImpl implements CrossService {

    private CrossDao crossDao;

    public void setCrossDao(CrossDao crossDao) {
        this.crossDao = crossDao;
    }

    @Override
    @Transactional
    public void addCross(Cross cross) {
        this.crossDao.addCross(cross);
    }

    @Override
    @Transactional
    public void updateCross(Cross cross) {
        this.crossDao.updateCross(cross);
    }

    @Override
    @Transactional
    public void removeCross(int idCross) {
        this.crossDao.removeCross(idCross);
    }

    @Override
    @Transactional
    public Cross getCrossById(int idCross) {
        return this.crossDao.getCrossById(idCross);
    }

    @Override
    @Transactional
    public List<Cross> listCrosses() {
        return this.crossDao.listCrosses();
    }
}
