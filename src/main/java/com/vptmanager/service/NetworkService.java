package com.vptmanager.service;

import com.vptmanager.model.Network;

import java.util.List;

public interface NetworkService {
    public void addNetwork(Network network);
    public void updateNetwork(Network network);
    public void removeNetwork(int idNetwork);
    public Network getNetworkById(int idNetwork);
    public List<Network> listNetworks();
}
