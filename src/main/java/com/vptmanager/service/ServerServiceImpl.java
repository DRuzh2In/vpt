package com.vptmanager.service;

import com.vptmanager.dao.ServerDao;
import com.vptmanager.model.Server;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ServerServiceImpl implements ServerService {

    private ServerDao serverDao;

    public void setServerDao(ServerDao networkDao) {
        this.serverDao = serverDao;
    }

    @Override
    @Transactional
    public void addServer(Server server) {
        this.serverDao.addServer(server);
    }

    @Override
    @Transactional
    public void updateServer(Server server) {
        this.serverDao.updateServer(server);
    }

    @Override
    @Transactional
    public void removeServer(int idServer) {
        this.serverDao.removeServer(idServer);
    }

    @Override
    @Transactional
    public Server getServerById(int idServer) {
        return this.serverDao.getServerById(idServer);
    }

    @Override
    @Transactional
    public List<Server> listServers() {
        return this.serverDao.listServers();
    }
}
