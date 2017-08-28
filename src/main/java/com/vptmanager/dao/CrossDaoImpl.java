package com.vptmanager.dao;

import com.vptmanager.model.Cross;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CrossDaoImpl implements CrossDao {
    private static final Logger logger = LoggerFactory.getLogger(CrossDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addCross(Cross cross) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(cross);
        logger.info("Cross successfully saved. Cross details: " + cross);
    }

    @Override
    public void updateCross(Cross cross) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(cross);
        logger.info("Cross successfully update. Cross details: " + cross);
    }

    @Override
    public void removeCross(int idCross) {
        Session session = this.sessionFactory.getCurrentSession();
        Cross cross = (Cross) session.load(Cross.class, new Integer(idCross));

        if(cross!=null){
            session.delete(cross);
        }
        logger.info("Cross successfully removed. Cross details: " + cross);
    }

    @Override
    public Cross getCrossById(int idCross) {
        Session session =this.sessionFactory.getCurrentSession();
        Cross cross = (Cross) session.load(Cross.class, new Integer(idCross));
        logger.info("Cross successfully loaded. Cross details: " + cross);

        return cross;
    }

    @Override
    public List<Cross> listCrosses() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Cross> crossList = session.createQuery("from Cross").list();

        for(Cross cross: crossList){
            logger.info("Cross list: " + cross);
        }

        return crossList;
    }
}
