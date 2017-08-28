package com.vptmanager.dao;

import com.vptmanager.model.Cross;

import java.util.List;

public interface CrossDao {
    public void addCross(Cross cross);
    public void updateCross(Cross cross);
    public void removeCross(int idCross);
    public Cross getCrossById(int idCross);
    public List<Cross> listCrosses();
}
