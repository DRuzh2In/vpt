package com.vptmanager.service;

import com.vptmanager.model.Zone;

import java.util.List;

public interface ZoneService {
    public void addZone(Zone zone);
    public void updateZone(Zone zone);
    public void removeZone(int idZone);
    public Zone getZoneById(int idZone);
    public List<Zone> listZones();
}
