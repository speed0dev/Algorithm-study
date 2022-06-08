package com.algo.jungol.intermediate;

import java.util.Scanner;

public class N1078 {

    //
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int w = s.nextInt();
        int h = s.nextInt();

        //
        int[][] map = new int[h+1][w+1];
        for(int i=1;i<map.length;i++){
            char[] tmp = s.nextLine().toCharArray();
            for(int j=1;j<tmp.length;j++) {
                map[i][j] =tmp[j-1];
            }
        }

        //
        int x = s.nextInt();
        int y = s.nextInt();
        System.out.println(" (" + x + "," + y + ")");



    }


}
