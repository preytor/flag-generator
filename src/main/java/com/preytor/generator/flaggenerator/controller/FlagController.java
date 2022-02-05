package com.preytor.generator.flaggenerator.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FlagController {

    @RequestMapping("/")
    public String getFlagImage(
        @RequestParam(value = "id", defaultValue = "1") int id,
        Model model){
        model.addAttribute("id", id);
        return "index";
    }
}
