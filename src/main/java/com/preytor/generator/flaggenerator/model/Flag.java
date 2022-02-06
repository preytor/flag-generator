package com.preytor.generator.flaggenerator.model;

public class Flag {
    
    private String color1;
    private String color2;
    private String color3;
    
    private int division_field = 1;
    private int furs = 0;
    private int cadency = 0;
    private int heraldic_charges = 0;

    public Flag(){}

    public Flag(String color1, String color2, String color3, int division_field, int furs, int cadency,
            int heraldic_charges) {
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
        this.division_field = division_field;
        this.furs = furs;
        this.cadency = cadency;
        this.heraldic_charges = heraldic_charges;
    }

    public String getColor1() {
        return color1;
    }

    public void setColor1(String color1) {
        this.color1 = color1;
    }

    public String getColor2() {
        return color2;
    }

    public void setColor2(String color2) {
        this.color2 = color2;
    }

    public String getColor3() {
        return color3;
    }

    public void setColor3(String color3) {
        this.color3 = color3;
    }

    public int getDivision_field() {
        return division_field;
    }

    public void setDivision_field(int division_field) {
        this.division_field = division_field;
    }

    public int getFurs() {
        return furs;
    }

    public void setFurs(int furs) {
        this.furs = furs;
    }

    public int getCadency() {
        return cadency;
    }

    public void setCadency(int cadency) {
        this.cadency = cadency;
    }

    public int getHeraldic_charges() {
        return heraldic_charges;
    }

    public void setHeraldic_charges(int heraldic_charges) {
        this.heraldic_charges = heraldic_charges;
    }

    @Override
    public String toString() {
        return "Flag [cadency=" + cadency + ", color1=" + color1 + ", color2=" + color2 + ", color3=" + color3
                + ", division_field=" + division_field + ", furs=" + furs + ", heraldic_charges=" + heraldic_charges
                + "]";
    }

    

}
