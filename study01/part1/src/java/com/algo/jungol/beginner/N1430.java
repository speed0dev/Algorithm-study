package com.algo.jungol.beginner;

import java.util.Scanner;

public class N1430 {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int[] numbers = new int[3];

        for(int i=0;i<3;i++){
            numbers[i] = s.nextInt();
        }
        int result = 1;
        for(int i=0;i<3;i++) {
            result *= numbers[i];
        }
        //System.out.println(result);
        int[] counts = {0,0,0,0,0,0,0,0,0,0};

        char[] code = ("" + result).toCharArray();
        for(int i=0;i<code.length;i++){
            //System.out.println(code[i]);
            counts[Integer.parseInt(""+code[i])] +=1;
        }

        for(int i=0;i<counts.length;i++){
            System.out.println(counts[i]);
        }

    }

}
