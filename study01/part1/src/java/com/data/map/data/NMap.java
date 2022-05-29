package com.data.map.data;

import org.jsoup.Jsoup;

import java.awt.*;
import java.io.IOException;
import java.nio.ByteBuffer;

public class NMap {
    NBufferImage bImage = null;

    public NMap(){
        onInit();
    }

    private void onInit() {
        bImage = new NBufferImage(300,300, "C:/temp/sample.png");
    }


    //
    public static void main(String[] args){

        NMap m = new NMap();

        String url = "https://cdn.pixabay.com/photo/2017/09/01/08/45/peony-2703458_1280.png";
        m.downImage(url);
    }

    //
    private void downImage(String url) {

        // image
        try {
            //
            byte[] bytes = Jsoup.connect(url).ignoreContentType(true).execute().bodyAsBytes();
            System.out.println("len:" + bytes.length);
            byte[] toByte = new byte[4];

            ByteBuffer buffer = ByteBuffer.wrap(bytes);
            buffer.mark();
            int offset = 0;

            while(true) {
                buffer.get(toByte);
                if(buffer.position() >= bytes.length){
                    break;
                }
                System.out.println( showNumber(toByte) + " pos:" + buffer.position());

            };

            //showColorData(toByte);
//            buffer.get(toByte);
//            System.out.println(toByte + " pos:" + buffer.position());
//
//            buffer.get(toByte);
//            System.out.println(toByte + " pos:" + buffer.position());
//
//            buffer.get(toByte);
//            System.out.println(toByte + " pos:" + buffer.position());

            //System.arraycopy(buffer, offset, toByte, offset, toByte.length);
            //System.out.println(toByte.toString());

            bImage.getG().dispose();
            bImage.save();

        } catch (IOException ie) {
            ie.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }

    }

    int step = 5;
    int xPos = 1;
    private String showNumber(byte[] toByte) {
        String result = "";
        for(byte b: toByte){
            result += (int) b + ",";
        }
        Graphics g = bImage.getG();
        g.setColor(Color.green);
        int val = (int)(toByte[1]);
        if(val < 0){
            val *= -1;
        }


        g.fillRect(xPos + step, val, step, val+step );
        xPos += (step + 2);

        return result;
    }

    private static void showColorData(byte[] toByte) {

//        Color c = new Color((int)toByte[0], (int)toByte[1], (int)toByte[2]);
//        int iColor = c.getRGB();
//        System.out.println("@ iColor:" + iColor);

        Color c = new Color(255,233,10);
        float iColor = c.getRGB();
        System.out.println("@ iColor:" + iColor);   // map

    }



}
