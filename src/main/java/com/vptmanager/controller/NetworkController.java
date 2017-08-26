package com.vptmanager.controller;

import com.vptmanager.model.Network;
import com.vptmanager.service.NetworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NetworkController {
    private NetworkService networkService;

    @Autowired
    @Qualifier(value = "networkService")
    public void setNetworkService(NetworkService networkService) {
        this.networkService = networkService;
    }

    @RequestMapping(value = "networks", method = RequestMethod.GET)
    public String listNetworks(Model model){
        model.addAttribute("network", new Network());
        model.addAttribute("listNetworks", this.networkService.listNetworks());

        return "networks";
    }

    @RequestMapping(value = "/networks/add", method = RequestMethod.POST)
    public String addNetworks(@ModelAttribute("network") Network network){
        if(network.getIdNetwork() == 0){
            this.networkService.addNetwork(network);
        }else {
            this.networkService.updateNetwork(network);
        }

        return "redirect:/networks";
    }

    @RequestMapping("/remove/network/{idNetwork}")
    public String removeNetwork(@PathVariable("idNetwork") int idNetwork){
        this.networkService.removeNetwork(idNetwork);

        return "redirect:/networks";
    }

    @RequestMapping("edit/network/{idNetwork}")
    public String editNetwork(@PathVariable("idNetwork") int idNetwork, Model model){
        model.addAttribute("network", this.networkService.getNetworkById(idNetwork));
        model.addAttribute("listNetworks", this.networkService.listNetworks());

        return "networks";
    }

    @RequestMapping("networkdata/{idNetwork}")
    public String networkData(@PathVariable("idNetwork") int idNetwork, Model model){
        model.addAttribute("network", this.networkService.getNetworkById(idNetwork));

        return "networkdata";
    }
}
