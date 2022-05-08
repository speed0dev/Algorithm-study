package com.algo.per;

public class PermitLuncher {

    // Number Permition
    public static void main(String[] args){
        Permition p = new Permition();

        int[] arr = {100,200,300,400};  // sort
        int n = arr.length;
        p.sol(arr, 0, arr.length, arr.length);

        System.out.println( 4*3*2*1 );

    }

}
