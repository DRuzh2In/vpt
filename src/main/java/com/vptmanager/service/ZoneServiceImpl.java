package com.vptmanager.service;

import com.vptmanager.dao.ZoneDao;
import com.vptmanager.model.Zone;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ZoneServiceImpl implements ZoneService {

    private ZoneDao zoneDao;

    public void setZoneDao(ZoneDao zoneDao) {
        this.zoneDao = zoneDao;
    }

    @Override
    @Transactional
    public void addZone(Zone zone) {
        this.zoneDao.addZone(zone);
    }

    @Override
    @Transactional
    public void updateZone(Zone zone) {
        this.zoneDao.updateZone(zone);
    }

    @Override
    @Transactional
    public void removeZone(int idZone) {
        this.zoneDao.removeZone(idZone);
    }

    @Override
    @Transactional
    public Zone getZoneById(int idZone) {
        return this.zoneDao.getZoneById(idZone);
    }

    @Override
    @Transactional
    public List<Zone> listZones() { return this.zoneDao.listZones();
    }
}
