package com.preytor.generator.flaggenerator.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Flag {
    
    private PredefinedColors color1;
    private PredefinedColors color2;
    private PredefinedColors color3;
    private PredefinedColors color4;
    private PredefinedColors color5;
    
    private int division_field = 1;
    private int furs = 0;
    private int cadency = 0;
    private int heraldic_charges = 0;

    private int TOTAL_DIVISION_FIELD = 0;
    private int TOTAL_FURS = 0;
    private int TOTAL_CADENCY = 0;
    private int TOTAL_HERALDIC_CHARGES = 0;

    public Flag(){}

    public Flag(int color1, int color2, int color3, int color4, int color5, int division_field, int furs, int cadency,
            int heraldic_charges) {

        this.TOTAL_DIVISION_FIELD = countFilesInFolder("division_field");
        this.TOTAL_FURS = countFilesInFolder("furs");
        this.TOTAL_CADENCY = countFilesInFolder("cadency");
        this.TOTAL_HERALDIC_CHARGES = countFilesInFolder("heraldic_charges");   

        this.color1 = PredefinedColors.getPredefinedColors(color1);
        this.color2 = PredefinedColors.getPredefinedColors(color2);
        this.color3 = PredefinedColors.getPredefinedColors(color3);
        this.color4 = PredefinedColors.getPredefinedColors(color4);
        this.color5 = PredefinedColors.getPredefinedColors(color5);
        
        this.setDivision_field(division_field);
        this.setFurs(furs);
        this.setCadency(cadency);
        this.setHeraldic_charges(heraldic_charges);
    }

    private int countFilesInFolder(String type){
        long type_length = 0;
        try {
            type_length = Files.list(Paths.get("src/main/resources/assets/"+type+"/")).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (int) type_length;
    }

    public PredefinedColors getColor1() {
        return color1;
    }

    public void setColor1(PredefinedColors color1) {
        this.color1 = color1;
    }

    public PredefinedColors getColor2() {
        return color2;
    }

    public void setColor2(PredefinedColors color2) {
        this.color2 = color2;
    }

    public PredefinedColors getColor3() {
        return color3;
    }

    public void setColor3(PredefinedColors color3) {
        this.color3 = color3;
    }

    public PredefinedColors getColor4() {
        return color4;
    }

    public void setColor4(PredefinedColors color4) {
        this.color4 = color4;
    }

    public PredefinedColors getColor5() {
        return color5;
    }

    public void setColor5(PredefinedColors color5) {
        this.color5 = color5;
    }

    public int getDivision_field() {
        return division_field;
    }

    public void setDivision_field(int division_field) {
        this.division_field = 0;

        long division_field_length = TOTAL_DIVISION_FIELD;
        if (division_field >= 0 && division_field <= division_field_length){
            this.division_field = division_field;
        }
    }

    public int getFurs() {
        return furs;
    }

    public void setFurs(int furs) {
        this.furs = 0;

        int furs_length = TOTAL_FURS;
        if (furs >= 0 && furs <= furs_length){
            this.furs = furs;
        }
    }

    public int getCadency() {
        return cadency;
    }

    public void setCadency(int cadency) {
        this.cadency = 0;

        int cadency_length = TOTAL_CADENCY;
        if (cadency >= 0 && cadency <= cadency_length){
            this.cadency = cadency;
        }
    }

    public int getHeraldic_charges() {
        return heraldic_charges;
    }

    public void setHeraldic_charges(int heraldic_charges) {
        this.heraldic_charges = 0;

        int heraldic_charges_length = TOTAL_HERALDIC_CHARGES;
        if (heraldic_charges >= 0 && heraldic_charges <= heraldic_charges_length){
            this.heraldic_charges = heraldic_charges;
        }
    }

    public int getTotal_division_field() {
        return TOTAL_DIVISION_FIELD;
    }

    public int getTotal_furs() {
        return TOTAL_FURS;
    }

    public int getTotal_cadency() {
        return TOTAL_CADENCY;
    }
    
    public int getTotal_heraldic_charges() {
        return TOTAL_HERALDIC_CHARGES;
    }

    @Override
    public String toString() {
        return "Flag [cadency=" + cadency + ", color1=" + color1 + ", color2=" + color2 + ", color3=" + color3
                + ", color4=" + color4 + ", color5=" + color5
                + ", division_field=" + division_field + ", furs=" + furs + ", heraldic_charges=" + heraldic_charges
                + "]";
    }

    

}
