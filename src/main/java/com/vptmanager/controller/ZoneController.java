package com.vptmanager.controller;

import com.vptmanager.model.Zone;
import com.vptmanager.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ZoneController {
    private ZoneService zoneService;

    @Autowired(required = true)
    @Qualifier(value = "zoneService")
    public void setBookService(ZoneService zoneService) {
        this.zoneService = zoneService;
    }

    @RequestMapping(value = "zones", method = RequestMethod.GET)
    public String listZones(Model model){
        model.addAttribute("zone", new Zone());
        model.addAttribute("listZones", this.zoneService.listZones());

        return "zone";
    }

    @RequestMapping(value = "/zones/add", method = RequestMethod.POST)
    public String addZones(@ModelAttribute("zone") Zone zone){
        if(zone.getIdZone() == 0){
            this.zoneService.addZone(zone);
        }else {
            this.zoneService.updateZone(zone);
        }

        return "redirect:/zones";
    }

    @RequestMapping("/remove/{idZone}")
    public String removeZone(@PathVariable("idZone") int idZone){
        this.zoneService.removeZone(idZone);

        return "redirect:/zones";
    }

    @RequestMapping("edit/{idZone}")
    public String editBook(@PathVariable("idZone") int idZone, Model model){
        model.addAttribute("zone", this.zoneService.getZoneById(idZone));
        model.addAttribute("listZones", this.zoneService.listZones());

        return "zone";
    }

    @RequestMapping("zonedata/{idZone}")
    public String zoneData(@PathVariable("idZone") int idZone, Model model){
        model.addAttribute("zone", this.zoneService.getZoneById(idZone));

        return "zonedata";
    }
}
