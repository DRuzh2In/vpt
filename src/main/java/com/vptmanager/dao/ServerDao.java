package com.vptmanager.dao;

import com.vptmanager.model.Server;

import java.util.List;

public interface ServerDao {
    public void addServer(Server server);
    public void updateServer(Server server);
    public void removeServer(int idServer);
    public Server getServerById(int idServer);
    public List<Server> listServers();
}
