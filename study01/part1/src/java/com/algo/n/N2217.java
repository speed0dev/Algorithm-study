package com.algo.n;

public class N2217 {

    //
    public static void main(String[] args){


        String[] dna = {"GTTA", "TAGG", "ATCGA", "CGCAT", "TAGGTA", "TAGG", "TAGGT"};
        makePerm(dna);


    }

    //--------------
    //
    private static void makePerm(String[] dna) {

        String[] out = new String[dna.length];
        Boolean[] visited = new Boolean[dna.length];


        findPerm(dna, out, visited, dna.length);

    }

    private static void findPerm(String[] dna, String[] out, Boolean[] visited, int depth) {


        //
        for(int i=depth; i<dna.length;i++){
            //
            visited[i] = true;
            out[depth] = dna[i];
            findPerm(dna, out, visited, depth + 1);
            visited[i] = false;

        }
    }



    private static void displayDna(String[] out) {
        System.out.println(out);
    }




}
