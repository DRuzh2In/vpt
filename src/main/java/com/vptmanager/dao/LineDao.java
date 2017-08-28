package com.vptmanager.dao;

import com.vptmanager.model.Line;

import java.util.List;

public interface LineDao {
    public void addLine(Line line);
    public void updateLine(Line line);
    public void removeLine(int idLine);
    public Line getLineById(int idLine);
    public List<Line> listLines();
}
