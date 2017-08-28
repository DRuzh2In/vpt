package com.vptmanager.service;

import com.vptmanager.dao.LineDao;
import com.vptmanager.model.Line;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LineServiceImpl implements LineService {

    private LineDao lineDao;

    public void setLineDao(LineDao lineDao) {
        this.lineDao = lineDao;
    }

    @Override
    @Transactional
    public void addLine(Line line) {
        this.lineDao.addLine(line);
    }

    @Override
    @Transactional
    public void updateLine(Line line) {
        this.lineDao.updateLine(line);
    }

    @Override
    @Transactional
    public void removeLine(int idLine) {
        this.lineDao.removeLine(idLine);
    }

    @Override
    @Transactional
    public Line getLineById(int idLine) {
        return this.lineDao.getLineById(idLine);
    }

    @Override
    @Transactional
    public List<Line> listLines() {
        return this.lineDao.listLines();
    }
}
