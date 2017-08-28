package com.vptmanager.controller;

import com.vptmanager.model.Cross;
import com.vptmanager.service.CrossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CrossController {
    private CrossService crossService;

    @Autowired
    @Qualifier(value = "crossService")
    public void setCrossService(CrossService crossService) {
        this.crossService = crossService;
    }

    @RequestMapping(value = "crosses", method = RequestMethod.GET)
    public String listCrosses(Model model){
        model.addAttribute("cross", new Cross());
        model.addAttribute("listCrosses", this.crossService.listCrosses());

        return "crosses";
    }

    @RequestMapping(value = "/cross/add", method = RequestMethod.POST)
    public String addCross(@ModelAttribute("cross") Cross cross){
        if(cross.getIdCross() == 0){
            this.crossService.addCross(cross);
        }else {
            this.crossService.updateCross(cross);
        }

        return "redirect:/crosses";
    }

    @RequestMapping("/remove/cross/{idCross}")
    public String removeCross(@PathVariable("idCross") int idCross){
        this.crossService.removeCross(idCross);

        return "redirect:/crosses";
    }

    @RequestMapping("edit/cross/{idCross}")
    public String editCross(@PathVariable("idCross") int idCross, Model model){
        model.addAttribute("cross", this.crossService.getCrossById(idCross));
        model.addAttribute("listCrosses", this.crossService.listCrosses());

        return "crosses";
    }

    @RequestMapping("crossdata/{idCross}")
    public String crossData(@PathVariable("idCross") int idCross, Model model){
        model.addAttribute("cross", this.crossService.getCrossById(idCross));

        return "crossdata";
    }
}
