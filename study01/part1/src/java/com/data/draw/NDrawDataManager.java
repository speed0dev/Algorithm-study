package com.data.draw;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class NDrawDataManager {

    public static String DIR = "D:/temp/output";
    private String outFileName = "r";
    private int nCount = 1;
    private int w;
    private int h;

    public NDrawDataManager(int w, int h){
        this.w = w;
        this.h = h;
    }


    //
    public void setSize(int w, int h){
        this.w = w;
        this.h = h;
    }

    public<T> NDrawDataManager addData(T data){

        return this;
    }

    public<T, R> R callAdd(IDraw<T, R> pFunc, T data){
        R result = null;
        if(pFunc!=null){
            result = pFunc.draw(data, null);
        }
        return result;
    }


    public<T,R> R drawData(IDraw<T,R> drawFunc, T data) throws Exception{
        String outFileName = String.format(DIR + "/%3d.jpg", nCount);
        ++nCount;

        File f = new File(outFileName);
        if(f.exists()){
           f.delete();
        }
        f.createNewFile();

        Image image = null;
        Graphics g = null;

        //image = ImageIO.read(new File(fillFullPath));
        //image = resizeImage = image.getScaledInstance();


        // link -> link -> link ->
        R result = null;
        if(drawFunc != null){
            BufferedImage newImage = new BufferedImage(w,h, BufferedImage.TYPE_INT_RGB);
            g = newImage.getGraphics();
            g.fillRect(0,0, w, h);
            // draw act <--
            result = drawFunc.draw(data, g);

            g.dispose();
            ImageIO.write(newImage, "PNG",new File(outFileName));
        }

        //
        return result;
    }


}
