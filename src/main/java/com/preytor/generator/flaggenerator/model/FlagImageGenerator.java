package com.preytor.generator.flaggenerator.model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.util.Base64;

import javax.imageio.ImageIO;

public class FlagImageGenerator {
    
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
                    System.out.println("Enters here?????? WHY");
                    //e1.printStackTrace();
                }
            }

            Graphics g = final_image.getGraphics();
            g.drawImage(img_division_field, 0, 0, null);
            g.dispose();
            System.out.println("did the image");
        }
        if (this.flag.getFurs() > 0){

        }
        if (this.flag.getCadency() > 0){

        }
        if (this.flag.getHeraldic_charges() > 0){

        }
        
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

    

}
