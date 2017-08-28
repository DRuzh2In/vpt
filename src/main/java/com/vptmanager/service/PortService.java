package com.vptmanager.service;

import com.vptmanager.model.Port;

import java.util.List;

public interface PortService {
    public void addPort(Port port);
    public void updatePort(Port port);
    public void removePort(int idPort);
    public Port getPortById(int idPort);
    public List<Port> listPorts();
}
