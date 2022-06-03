package com.algo.jungol.lang;

import java.util.Scanner;

public class N593 {
    // 33~127
    public static void main(String[] args){

        Scanner s = new Scanner(System.in);
        boolean bFlag = true;
        while(bFlag){
            System.out.print("ASCII code =? ");
            int num = s.nextInt();
            //6System.out.println("ASCII code = ? " + num);
            if(num>=33 && num<=127){
                //System.out.println("ASCII code = ? " + num);
                char b = (char)num;
                System.out.println(b);

            }else {
                break;
            }
        }

    }
}
