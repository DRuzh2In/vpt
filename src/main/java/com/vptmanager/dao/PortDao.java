package com.vptmanager.dao;

import com.vptmanager.model.Port;

import java.util.List;

public interface PortDao {
    public void addPort(Port port);
    public void updatePort(Port port);
    public void removePort(int idPort);
    public Port getPortById(int idPort);
    public List<Port> listPorts();
}
