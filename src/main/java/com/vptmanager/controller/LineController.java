package com.vptmanager.controller;

import com.vptmanager.model.Line;
import com.vptmanager.service.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LineController {
    private LineService lineService;

    @Autowired
    @Qualifier(value = "lineService")
    public void setLineService(LineService lineService) {
        this.lineService = lineService;
    }

    @RequestMapping(value = "lines", method = RequestMethod.GET)
    public String listlinees(Model model){
        model.addAttribute("line", new Line());
        model.addAttribute("listLines", this.lineService.listLines());

        return "lines";
    }

    @RequestMapping(value = "/line/add", method = RequestMethod.POST)
    public String addLine(@ModelAttribute("line") Line line){
        if(line.getIdLine() == 0){
            this.lineService.addLine(line);
        }else {
            this.lineService.updateLine(line);
        }

        return "redirect:/lines";
    }

    @RequestMapping("/remove/line/{idLine}")
    public String removeLine(@PathVariable("idLine") int idLine){
        this.lineService.removeLine(idLine);

        return "redirect:/lines";
    }

    @RequestMapping("edit/line/{idLine}")
    public String editLine(@PathVariable("idLine") int idLine, Model model){
        model.addAttribute("line", this.lineService.getLineById(idLine));
        model.addAttribute("listLines", this.lineService.listLines());

        return "lines";
    }

    @RequestMapping("linedata/{idLine}")
    public String lineData(@PathVariable("idLine") int idLine, Model model){
        model.addAttribute("line", this.lineService.getLineById(idLine));

        return "linedata";
    }
}
