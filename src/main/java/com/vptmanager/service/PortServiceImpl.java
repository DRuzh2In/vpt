package com.vptmanager.service;

import com.vptmanager.dao.PortDao;
import com.vptmanager.model.Port;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PortServiceImpl implements PortService {

    private PortDao portDao;

    public void setPortDao(PortDao portDao) {
        this.portDao = portDao;
    }

    @Override
    @Transactional
    public void addPort(Port port) {
        this.portDao.addPort(port);
    }

    @Override
    @Transactional
    public void updatePort(Port port) {
        this.portDao.updatePort(port);
    }

    @Override
    @Transactional
    public void removePort(int idPort) {
        this.portDao.removePort(idPort);
    }

    @Override
    @Transactional
    public Port getPortById(int idPort) {
        return this.portDao.getPortById(idPort);
    }

    @Override
    @Transactional
    public List<Port> listPorts() {
        return this.portDao.listPorts();
    }
}
