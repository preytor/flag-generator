package com.preytor.generator.flaggenerator.controller;
import com.preytor.generator.flaggenerator.model.Flag;
import com.preytor.generator.flaggenerator.model.FlagImageGenerator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FlagController {

    @RequestMapping("/")
    public String getFlagImage(
        @RequestParam(value = "id", defaultValue = "1") int id,
        @RequestParam(value = "division_field", defaultValue = "0") int division_field,
        @RequestParam(value = "furs", defaultValue = "0") int furs,
        @RequestParam(value = "cadency", defaultValue = "0") int cadency,
        @RequestParam(value = "heraldic_charges", defaultValue = "0") int heraldic_charges,
        Model model){
        model.addAttribute("id", id);

        String color1 = "";
        String color2 = "";
        String color3 = "";
        String color4 = "";
        String color5 = "";
        String color6 = "";

        Flag flag = new Flag(color1, color2, color3, color4, color5, color6, division_field, furs, cadency, heraldic_charges);
        FlagImageGenerator fig = new FlagImageGenerator(flag);
        fig.processFlagImageGenerator();
        model.addAttribute("flag", fig.imgToBase64String());
        System.out.println("flag value: "+fig.imgToBase64String());
        return "index";
    }
}
