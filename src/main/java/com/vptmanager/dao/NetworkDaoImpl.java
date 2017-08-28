package com.vptmanager.dao;

import com.vptmanager.model.Network;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NetworkDaoImpl implements NetworkDao {
    private static final Logger logger = LoggerFactory.getLogger(NetworkDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addNetwork(Network network) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(network);
        logger.info("Network successfully saved. Network details: " + network);
    }

    @Override
    public void updateNetwork(Network network) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(network);
        logger.info("Network successfully update. Network details: " + network);
    }

    @Override
    public void removeNetwork(int idNetwork) {
        Session session = this.sessionFactory.getCurrentSession();
        Network network = (Network) session.load(Network.class, new Integer(idNetwork));

        if(network!=null){
            session.delete(network);
        }
        logger.info("Network successfully removed. Network details: " + network);
    }

    @Override
    public Network getNetworkById(int idNetwork) {
        Session session =this.sessionFactory.getCurrentSession();
        Network network = (Network) session.load(Network.class, new Integer(idNetwork));
        logger.info("Network successfully loaded. Network details: " + network);

        return network;
    }

    @Override
    public List<Network> listNetworks() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Network> networkList = session.createQuery("from Network").list();

        for(Network network: networkList){
            logger.info("Network list: " + network);
        }

        return networkList;
    }
}

