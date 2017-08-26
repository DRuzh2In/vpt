package com.vptmanager.controller;

import com.vptmanager.model.Server;
import com.vptmanager.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ServerController {
    private ServerService serverService;

    @Autowired(required = true)
    @Qualifier(value = "serverService")
    public void setServerService(ServerService serverService) {
        this.serverService = serverService;
    }

    @RequestMapping(value = "servers", method = RequestMethod.GET)
    public String listServers(Model model){
        model.addAttribute("server", new Server());
        model.addAttribute("listServers", this.serverService.listServers());

        return "servers";
    }

    @RequestMapping(value = "/server/add", method = RequestMethod.POST)
    public String addServer(@ModelAttribute("server") Server server){
        if(server.getIdServer() == 0){
            this.serverService.addServer(server);
        }else {
            this.serverService.updateServer(server);
        }

        return "redirect:/servers";
    }

    @RequestMapping("/remove/server/{idServer}")
    public String removeServer(@PathVariable("idServer") int idServer){
        this.serverService.removeServer(idServer);

        return "redirect:/servers";
    }

    @RequestMapping("edit/server/{idServer}")
    public String editServer(@PathVariable("idServer") int idServer, Model model){
        model.addAttribute("zone", this.serverService.getServerById(idServer));
        model.addAttribute("listServers", this.serverService.listServers());

        return "servers";
    }

    @RequestMapping("serverdata/{idServer}")
    public String serverData(@PathVariable("idSeerver") int idServer, Model model){
        model.addAttribute("server", this.serverService.getServerById(idServer));

        return "serverdata";
    }
}
