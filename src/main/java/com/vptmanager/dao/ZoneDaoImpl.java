package com.vptmanager.dao;

import com.vptmanager.model.Zone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ZoneDaoImpl implements ZoneDao {
    private static final Logger logger = LoggerFactory.getLogger(ZoneDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addZone(Zone zone) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(zone);
        logger.info("Zone successfully saved. Zone details: " + zone);
    }

    @Override
    public void updateZone(Zone zone) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(zone);
        logger.info("Zone successfully update. Zone details: " + zone);
    }

    @Override
    public void removeZone(int idZone) {
        Session session = this.sessionFactory.getCurrentSession();
        Zone zone = (Zone) session.load(Zone.class, new Integer(idZone));

        if(zone !=null){
            session.delete(zone);
        }
        logger.info("Zone successfully removed. Zone details: " + zone);
    }

    @Override
    public Zone getZoneById(int idZone) {
        Session session =this.sessionFactory.getCurrentSession();
        Zone zone = (Zone) session.load(Zone.class, new Integer(idZone));
        logger.info("Zone successfully loaded. Zone details: " + zone);

        return zone;
    }

    @Override
    public List<Zone> listZones() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Zone> zoneList = session.createQuery("from Zone").list();

        for(Zone zone : zoneList){
            logger.info("Zone list: " + zone);
        }

        return zoneList;
    }
}

