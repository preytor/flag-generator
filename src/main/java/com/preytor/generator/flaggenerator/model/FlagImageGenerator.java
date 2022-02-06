package com.preytor.generator.flaggenerator.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
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
        if (this.flag.getDivision_field() > 0){
            // We load the division_field image
            BufferedImage img_division_field = new BufferedImage(32, 48, BufferedImage.TYPE_INT_ARGB);
            try {
                String division_directory = directory+"division_field/division_"+this.flag.getDivision_field()+".png";
                img_division_field = ImageIO.read(new File(division_directory));
            } catch (IOException e) {
                String division_directory = "division_field/division_1.png";
                try {
                    img_division_field = ImageIO.read(new File(division_directory));
                } catch (IOException e1) {
                    //e1.printStackTrace();
                }
            }
            img_division_field = colorImage(img_division_field, new Color(255, 0, 255));//new Color(255, 0, 255));//new Color(255, 255, 255));
            Graphics2D g = final_image.createGraphics();
            g.drawImage(img_division_field, 0, 0, null);
            g.dispose();
        }
        if (this.flag.getFurs() > 0){

        }
        if (this.flag.getCadency() > 0){

        }
        if (this.flag.getHeraldic_charges() > 0){

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

    public BufferedImage getFinal_image() {
        return final_image;
    }

}
