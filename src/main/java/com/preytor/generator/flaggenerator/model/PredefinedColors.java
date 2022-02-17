package com.preytor.generator.flaggenerator.model;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public enum PredefinedColors {

    SABLE(0, new Color(42, 29, 13)),
    ARGENT(1, new Color(239, 216, 161)),
    GULES(2, new Color(155, 26, 10)),
    TENNE(3, new Color(239, 105, 47)),
    VERT(4, new Color(57, 87, 28)),
    MURREY(5, new Color(133, 0, 133)),
    OR(6, new Color(239, 172, 40)),
    AZURE(7, new Color(56, 76, 188)),
    LEONARDO(8, new Color(119, 52, 33)),
    SANGUINE(9, new Color(85, 15, 10));

    private static final Map<Integer, PredefinedColors> PREDEFINED_IDS = new HashMap<>();
    
    static {
        for (PredefinedColors e: values()) {
            PREDEFINED_IDS.put(e.colorId, e);
        }
    }

    private int colorId;
    private Color color;

    PredefinedColors(int colorId, Color color){
        this.colorId = colorId;
        this.color = color;
    }

    public static PredefinedColors getPredefinedColors(int colorId){
        return PREDEFINED_IDS.get(colorId) != null ? PREDEFINED_IDS.get(colorId) : PREDEFINED_IDS.get(0);
    }

    public String getColorName() {
		return getPredefinedColors(this.colorId).name();
	}

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public static Object getTotalColors() {
        return PREDEFINED_IDS.size();
    }
}
