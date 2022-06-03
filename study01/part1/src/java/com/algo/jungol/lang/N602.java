package com.algo.jungol.lang;

import java.util.Scanner;

public class N602 {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String[] words = new String[5];
        for(int i=0;i<5;i++){
            words[i] = s.nextLine();
        }

        for(int i=4;i>=0;i--){
            System.out.println(words[i]);
        }

    }
}
