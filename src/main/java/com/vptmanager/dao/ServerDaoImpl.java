package com.vptmanager.dao;

import com.vptmanager.model.Server;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ServerDaoImpl implements ServerDao {
    private static final Logger logger = LoggerFactory.getLogger(ServerDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addServer(Server server) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(server);
        logger.info("Server successfully saved. Server details: " + server);
    }

    @Override
    public void updateServer(Server server) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(server);
        logger.info("Network successfully update. Server details: " + server);
    }

    @Override
    public void removeServer(int idServer) {
        Session session = this.sessionFactory.getCurrentSession();
        Server server = (Server) session.load(Server.class, new Integer(idServer));

        if(server!=null){
            session.delete(server);
        }
        logger.info("Server successfully removed. Server details: " + server);
    }

    @Override
    public Server getServerById(int idServer) {
        Session session =this.sessionFactory.getCurrentSession();
        Server server = (Server) session.load(Server.class, new Integer(idServer));
        logger.info("Server successfully loaded. Server details: " + server);

        return server;
    }

    @Override

    public List<Server> listServers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Server> serverList = session.createQuery("from Server").list();

        for(Server server: serverList){
            logger.info("Server list: " + server);
        }

        return serverList;
    }
}
