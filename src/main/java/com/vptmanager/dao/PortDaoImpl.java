package com.vptmanager.dao;

import com.vptmanager.model.Port;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PortDaoImpl implements PortDao {
    private static final Logger logger = LoggerFactory.getLogger(PortDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addPort(Port port) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(port);
        logger.info("Port successfully saved. Port details: " + port);
    }

    @Override
    public void updatePort(Port port) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(port);
        logger.info("Network successfully update. Network details: " + port);
    }

    @Override
    public void removePort(int idPort) {
        Session session = this.sessionFactory.getCurrentSession();
        Port port = (Port) session.load(Port.class, new Integer(idPort));

        if(port!=null){
            session.delete(port);
        }
        logger.info("Port successfully removed. Port details: " + port);
    }

    @Override
    public Port getPortById(int idPort) {
        Session session =this.sessionFactory.getCurrentSession();
        Port port = (Port) session.load(Port.class, new Integer(idPort));
        logger.info("Port successfully loaded. Port details: " + port);

        return port;
    }

    @Override
    public List<Port> listPorts() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Port> portList = session.createQuery("from Port").list();

        for(Port port: portList){
            logger.info("Port list: " + port);
        }

        return portList;
        }
}
