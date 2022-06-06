package com.algo.jungol.beginner;

import java.util.Scanner;

public class N1291 {

    public static void main(String[] args){

        Scanner s = new Scanner(System.in);
        boolean bFlag = true;
        int s_ = 0;
        int e_ = 0;
        while(bFlag) {
            e_ = s.nextInt();
            s_ = s.nextInt();

            if (s_ < 0 || s_ > 9) {
                System.out.println("INPUT ERROR!");
                continue;
            }
            if (e_ < 0 || e_ > 9) {
                System.out.println("INPUT ERROR!");
                continue;
            }

            bFlag = false;
        }


        for(int i=1; i<10; i++){
            for(int j=e_; j>=s_; j--){
                System.out.print(j + " * " + i + " = " + (j * i) + "   ");
            }
            System.out.println("");
        }

    }

}
