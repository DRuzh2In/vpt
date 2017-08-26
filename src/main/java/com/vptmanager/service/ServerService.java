package com.vptmanager.service;

import com.vptmanager.model.Server;

import java.util.List;

public interface ServerService{
        public void addServer(Server server);
        public void updateServer(Server server);
        public void removeServer(int idServer);
        public Server getServerById(int idServer);
        public List<Server> listServers();
}
