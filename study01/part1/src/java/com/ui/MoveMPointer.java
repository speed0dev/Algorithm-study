package com.ui;

import java.awt.*;
public class MoveMPointer {

    private boolean bFlag = true;

    private int maxX = 600;
    private int maxY = 600;

    public static void main(String[] args){
        MoveMPointer m = new MoveMPointer();
        m.move();
    }

    //
    public void move() {
        try {
            int sleepTime = 10 * 1000;
            Robot r = new Robot();
            //
            int x = 1;
            int y = 1;

            while(bFlag) {
                ++x;
                ++y;
                if(x >= maxX){
                    x = 1;
                }
                if(y >= maxY){
                    y = 1;
                }
                //
                System.out.println("move:" + x + " " + y);
                r.mouseMove(x, y);

                //
                Thread.sleep(sleepTime);
            }
        }catch(Exception e ){
            e.printStackTrace();
        }
        //
    }

}
