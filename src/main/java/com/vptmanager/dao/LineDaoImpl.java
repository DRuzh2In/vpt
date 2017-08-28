package com.vptmanager.dao;

import com.vptmanager.model.Line;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LineDaoImpl implements LineDao{
    private static final Logger logger = LoggerFactory.getLogger(LineDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addLine(Line line) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(line);
        logger.info("Line successfully saved. Line details: " + line);
    }

    @Override
    public void updateLine(Line line) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(line);
        logger.info("Line successfully update. Network details: " + line);
    }

    @Override
    public void removeLine(int idLine) {
        Session session = this.sessionFactory.getCurrentSession();
        Line line = (Line) session.load(Line.class, new Integer(idLine));

        if(line!=null){
            session.delete(line);
        }
        logger.info("Line successfully removed. Line details: " + line);
    }

    @Override
    public Line getLineById(int idLine) {
        Session session =this.sessionFactory.getCurrentSession();
        Line line = (Line) session.load(Line.class, new Integer(idLine));
        logger.info("Line successfully loaded. Line details: " + line);

        return line;
    }

    @Override
    public List<Line> listLines() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Line> lineList = session.createQuery("from Line").list();

        for(Line line: lineList){
            logger.info("Line list: " + line);
        }

        return lineList;
    }
}
