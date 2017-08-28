package com.vptmanager.controller;

import com.vptmanager.model.Port;
import com.vptmanager.service.PortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PortController {
    private PortService portService;

    @Autowired
    @Qualifier(value = "portService")
    public void setPortService(PortService portService) {
        this.portService = portService;
    }

    @RequestMapping(value = "ports", method = RequestMethod.GET)
    public String listPorts(Model model){
        model.addAttribute("port", new Port());
        model.addAttribute("listPorts", this.portService.listPorts());

        return "ports";
    }

    @RequestMapping(value = "/port/add", method = RequestMethod.POST)
    public String addPort(@ModelAttribute("port") Port port){
        if(port.getIdPort() == 0){
            this.portService.addPort(port);
        }else {
            this.portService.updatePort(port);
        }

        return "redirect:/ports";
    }

    @RequestMapping("/remove/port/{idPort}")
    public String removePort(@PathVariable("idPort") int idPort){
        this.portService.removePort(idPort);

        return "redirect:/ports";
    }

    @RequestMapping("edit/port/{idPort}")
    public String editPort(@PathVariable("idPort") int idPort, Model model){
        model.addAttribute("port", this.portService.getPortById(idPort));
        model.addAttribute("listPorts", this.portService.listPorts());

        return "ports";
    }

    @RequestMapping("portdata/{idPort}")
    public String portData(@PathVariable("idPort") int idPort, Model model){
        model.addAttribute("port", this.portService.getPortById(idPort));

        return "portdata";
    }
}
