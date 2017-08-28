package com.vptmanager.controller;

import com.vptmanager.model.Module;
import com.vptmanager.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ModuleController {
    private ModuleService moduleService;

    @Autowired
    @Qualifier(value = "moduleService")
    public void setModuleService(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    @RequestMapping(value = "modules", method = RequestMethod.GET)
    public String listModules(Model model){
        model.addAttribute("module", new Module());
        model.addAttribute("listModules", this.moduleService.listModules());

        return "modules";
    }

    @RequestMapping(value = "/module/add", method = RequestMethod.POST)
    public String addModule(@ModelAttribute("module") Module module){
        if(module.getIdModule() == 0){
            this.moduleService.addModule(module);
        }else {
            this.moduleService.updateModule(module);
        }

        return "redirect:/modules";
    }

    @RequestMapping("/remove/module/{idModule}")
    public String removeModule(@PathVariable("idModule") int idModule){
        this.moduleService.removeModule(idModule);

        return "redirect:/modules";
    }

    @RequestMapping("edit/module/{idModule}")
    public String editModule(@PathVariable("idModule") int idModule, Model model){
        model.addAttribute("module", this.moduleService.getModuleById(idModule));
        model.addAttribute("listModules", this.moduleService.listModules());

        return "modules";
    }

    @RequestMapping("moduledata/{idModule}")
    public String moduleData(@PathVariable("idModule") int idModule, Model model){
        model.addAttribute("module", this.moduleService.getModuleById(idModule));

        return "moduledata";
    }
}
