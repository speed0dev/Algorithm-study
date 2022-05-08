package com.algo.per;

import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

public class Permition {

    public Permition(){

    }

    int nCount = 1;
    private void Print(int[] arr, int r) {
        System.out.print("["+nCount+"]");
        for(int i=0;i<r;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ");
        ++nCount;
    }


    public void sol(int[] arr, int depth, int n, int r){

        if(depth ==r){
            Print(arr, r);
            return;
        }


        //--------------------------------
        // git 에 반영하기
        //
        for(int i=depth; i<n; i++){
            swap(arr, depth, i);        //
            sol(arr, depth+1, n, r);
            swap(arr, depth, i);
        }

    }


    private void swap(int[] arr, int depth, int i) {
        //System.out.println(" swap:" + depth + "," + i);
        if(depth != i) {
            System.out.println(" swap:" + depth + "," + i);
            int temp = arr[depth];
            arr[depth] = arr[i];
            arr[i] = temp;
        }
    }


}
