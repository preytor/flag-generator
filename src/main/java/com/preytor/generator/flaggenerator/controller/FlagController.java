package com.preytor.generator.flaggenerator.controller;
import com.preytor.generator.flaggenerator.model.Flag;
import com.preytor.generator.flaggenerator.model.FlagImageGenerator;
import com.preytor.generator.flaggenerator.model.PredefinedColors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FlagController {

    @RequestMapping("/")
    public String getFlagImage(
        @RequestParam(value = "division_field", defaultValue = "0") int division_field,
        @RequestParam(value = "furs", defaultValue = "0") int furs,
        @RequestParam(value = "cadency", defaultValue = "0") int cadency,
        @RequestParam(value = "heraldic_charges", defaultValue = "0") int heraldic_charges,
        @RequestParam(value = "color1", defaultValue = "0") int color1,
        @RequestParam(value = "color2", defaultValue = "0") int color2,
        @RequestParam(value = "color3", defaultValue = "0") int color3,
        @RequestParam(value = "color4", defaultValue = "0") int color4,
        @RequestParam(value = "color5", defaultValue = "0") int color5,
        Model model){
        //validateNumber(color1)
        Flag flag = new Flag(color1, color2, color3, color4, color5, division_field, furs, cadency, heraldic_charges);
        FlagImageGenerator fig = new FlagImageGenerator(flag);
        fig.processFlagImageGenerator();

        /* We return this data to the frontend */
        // The flag image
        model.addAttribute("flag", fig.imgToBase64String());
        // The current color it's using in text
        model.addAttribute("color1", flag.getColor1().getColorName());
        model.addAttribute("color2", flag.getColor2().getColorName());
        model.addAttribute("color3", flag.getColor3().getColorName());
        model.addAttribute("color4", flag.getColor4().getColorName());
        model.addAttribute("color5", flag.getColor5().getColorName());
        // The current color it's using in number
        model.addAttribute("color1_number", flag.getColor1().getColorId());
        model.addAttribute("color2_number", flag.getColor2().getColorId());
        model.addAttribute("color3_number", flag.getColor3().getColorId());
        model.addAttribute("color4_number", flag.getColor4().getColorId());
        model.addAttribute("color5_number", flag.getColor5().getColorId());
        // The current options it's using
        model.addAttribute("division_field", flag.getDivision_field());
        model.addAttribute("furs", flag.getFurs());
        model.addAttribute("cadency", flag.getCadency());
        model.addAttribute("heraldic_charges", flag.getHeraldic_charges());
        // The total numbers to know when you hit the limit and to display it
        model.addAttribute("total_division_field", flag.getTotal_division_field());
        model.addAttribute("total_furs", flag.getTotal_furs());
        model.addAttribute("total_cadency", flag.getTotal_cadency());
        model.addAttribute("total_heraldic_charges", flag.getTotal_heraldic_charges());
        model.addAttribute("total_colors", PredefinedColors.getTotalColors());

        return "index";
    }

    private int validateNumber(String data){
        int result = 0;
        try { 
            result = Integer.parseInt(data);
		}catch (NumberFormatException e)  { } 

        return result;
    }
}
