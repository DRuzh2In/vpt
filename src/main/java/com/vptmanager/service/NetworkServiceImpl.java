package com.vptmanager.service;

import com.vptmanager.dao.NetworkDao;
import com.vptmanager.model.Network;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NetworkServiceImpl implements NetworkService{

    private NetworkDao networkDao;

    public void setNetworkDao(NetworkDao networkDao) {
        this.networkDao = networkDao;
    }

    @Override
    @Transactional
    public void addNetwork(Network network) {
        this.networkDao.addNetwork(network);
    }

    @Override
    @Transactional
    public void updateNetwork(Network network) {
        this.networkDao.updateNetwork(network);
    }

    @Override
    @Transactional
    public void removeNetwork(int idNetwork) {
        this.networkDao.removeNetwork(idNetwork);
    }

    @Override
    @Transactional
    public Network getNetworkById(int idNetwork) {
        return this.networkDao.getNetworkById(idNetwork);
    }

    @Override
    @Transactional
    public List<Network> listNetworks() {
        return this.networkDao.listNetworks();
    }
}