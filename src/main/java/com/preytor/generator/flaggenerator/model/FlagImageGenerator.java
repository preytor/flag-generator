package com.preytor.generator.flaggenerator.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Base64;

import javax.imageio.ImageIO;

public class FlagImageGenerator {

    private final int newW = 320;
    private final int newH = 480;

    private BufferedImage final_image;
    private Flag flag;

    public FlagImageGenerator(Flag _flag){
        this.flag = _flag;
        this.final_image = new BufferedImage(32, 48, BufferedImage.TYPE_INT_ARGB);
    }

    public void processFlagImageGenerator(){
        String directory = "src/main/resources/assets/";
        if (this.flag.getFurs() > 0){
            // We load the furs image
            BufferedImage img_fur = processImage(this.flag.getFurs(), directory, "furs/furs_", new Color(155, 0, 255));
            Graphics2D g = final_image.createGraphics();
            g.drawImage(img_fur, 0, 0, null);
            g.dispose();
        }
        if (this.flag.getDivision_field() > 0){
            // We load the division_field image
            BufferedImage img_division_field = processImage(this.flag.getDivision_field(), directory, "division_field/division_", new Color(255, 0, 255));
            
            Graphics2D g = final_image.createGraphics();
            g.drawImage(img_division_field, 0, 0, null);
            g.dispose();
        }
        if (this.flag.getCadency() > 0){
            // We load the cadency image
            BufferedImage img_cadency = processImage(this.flag.getCadency(), directory, "cadency/cadency_", new Color(255, 0, 155));
            Graphics2D g = final_image.createGraphics();
            g.drawImage(img_cadency, 0, 0, null);
            g.dispose();
        }
        if (this.flag.getHeraldic_charges() > 0){
            // We load the heraldic_charges image
            BufferedImage img_heraldic_charges = processImage(this.flag.getHeraldic_charges(), directory, "heraldic_charges/heraldic_charges_", new Color(255, 255, 0));
            Graphics2D g = final_image.createGraphics();
            g.drawImage(img_heraldic_charges, 0, 12, null);
            g.dispose();
        }

        this.resize(final_image, newW, newH);
    }

    public String imgToBase64String() {
        final ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
          ImageIO.write(final_image, "png", os);
          return Base64.getEncoder().encodeToString(os.toByteArray());
        } catch (final IOException ioe) {
          throw new UncheckedIOException(ioe);
        }
    }

    public void resize(BufferedImage bufferedImage, int newW, int newH) { 
        Image tmp = bufferedImage.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
    
        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
    
        this.final_image = dimg;
    }

    private static BufferedImage colorImage(BufferedImage image, Color color) {
        int width = image.getWidth();
        int height = image.getHeight();
        for (int xx = 0; xx < width; xx++) {
            for (int yy = 0; yy < height; yy++) {
                int rgbpixel = image.getRGB(xx,yy);
                if( (rgbpixel>>24) != 0x00 ) {
                    image.setRGB(xx, yy, color.getRGB());//.setPixel(xx, yy, pixel);//.setSample(xx,yy,b,pixel[b]); 
                }
            }
        }
        return image;
    }

    private BufferedImage processImage(int flag_id, String directory, String texture_type_dir, Color color){
        // We load the flag_symbol image
        BufferedImage img_flag_symbol = new BufferedImage(32, 48, BufferedImage.TYPE_INT_ARGB);
        try {
            String division_directory = directory+texture_type_dir+flag_id+".png";
            img_flag_symbol = ImageIO.read(new File(division_directory));
        } catch (IOException e) {
            String division_directory = texture_type_dir+"1.png";
            try {
                img_flag_symbol = ImageIO.read(new File(division_directory));
            } catch (IOException e1) {
                //e1.printStackTrace();
            }
        }
        img_flag_symbol = colorImage(img_flag_symbol, color);
        return img_flag_symbol;
    }

    public BufferedImage getFinal_image() {
        return final_image;
    }

}
