package com.vptmanager.service;

import com.vptmanager.model.Cross;

import java.util.List;

public interface CrossService {
    public void addCross(Cross cross);
    public void updateCross(Cross cross);
    public void removeCross(int idCross);
    public Cross getCrossById(int idCross);
    public List<Cross> listCrosses();
}
