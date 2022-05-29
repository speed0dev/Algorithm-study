package com.data.map.data;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class NBufferImage {
    private String fName;
    private int width;
    private int height;
    private BufferedImage image = null;

    public NBufferImage(int w, int h, String fname){
        this.width = w;
        this.height = h;
        this.fName = fname;
        onInit();
    }

    private void onInit() {
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        g.fillRect(0,0,width, height);
        g.dispose();
    }

    public Graphics getG(){
        return image.getGraphics();
    }

    public void save() throws Exception{
        File f = new File(fName);
        if(f.exists()){
            f.delete();
        }
        f.createNewFile();

        ImageIO.write(image, "PNG", f);
    }

}
