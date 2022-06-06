package com.algo.jungol.lang;

import java.util.Scanner;

public class OperSetting {

    public static void main(String[] args){
        //
        Scanner sc = new Scanner(System.in);
        //int cnt = sc.nextInt();
        int sum = 0;
        float avg = 0;
        for(int i=0;i<3;i++){
            sum += sc.nextInt();
        }

        avg = (int)sum/3;
        System.out.println("sum :" + sum);
        System.out.println("avg :" + avg);

    }



}
