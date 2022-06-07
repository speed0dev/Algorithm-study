package com.algo.jungol.beginner;


import java.util.Scanner;

public class N1692 {

    public static void main(String[] arg){
        Scanner s = new Scanner(System.in);

        int n3_1 = s.nextInt();
        int n3_2 = s.nextInt();

        String str = "" + n3_2;
        byte[] b = str.getBytes();
        //System.out.println(n3_1 + "," + n3_2);
        for(int i=2;i>=0;i--){
            System.out.println(n3_1 * (int)(b[i]-48));
        }
        System.out.println(n3_1 * n3_2);
    }

}
