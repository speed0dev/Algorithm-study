package com.data.map.data;

import javax.imageio.ImageIO;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class NDrawImage {

    public static void main(String[] args){
        drawImages();
    }

    private static void drawImages() {
        String fName = "D:/temp/output/sample.png";
        try {
            System.out.println("drawImages() begin -----------------------");
            paint(300, 300, fName);
            System.out.println("drawImages() end -----------------------");
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    //
    public static void paint(int w, int h, String outFilename) throws Exception{

        File f = new File(outFilename);
        if(f.exists()){
            f.delete();
        }
        f.createNewFile();

        Image image = null;
        Graphics g;
        //image = ImageIO.read(new File(fillFullPath));

        //image = resizeImage = image.getScaledInstance();
        BufferedImage newImage = new BufferedImage(w,h, BufferedImage.TYPE_INT_RGB);
        g = newImage.getGraphics();
        g.fillRect(0,0, w, h);
        g.setColor(ColorUIResource.MAGENTA);
        int step = 50;
        for(int i=0;i<2;i++) {
            //g.drawRect(2, 2, 100+i, 100+i);
            g.fillRoundRect(1 + step,1,30,50, 6,6);

        }
        g.dispose();

        ImageIO.write(newImage, "PNG",new File(outFilename));


    }

}
