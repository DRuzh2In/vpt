package com.vptmanager.dao;

import com.vptmanager.model.Network;

import java.util.List;

public interface NetworkDao {
    public void addNetwork(Network network);
    public void updateNetwork(Network network);
    public void removeNetwork(int idNetwork);
    public Network getNetworkById(int idNetwork);
    public List<Network> listNetworks();
}
