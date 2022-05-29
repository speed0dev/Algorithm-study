package com.algo.jungol.n;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class N1840Ex2 {

    int[][] map = null;
    int x = 0;
    int y = 0;

    // x, y
    int[][] rated = {
            {0,1}
            ,{1,1}
            ,{1,0}
            ,{1,-1}
            ,{0,-1}
            ,{-1,-1}
            ,{-1,0}
            ,{-1,1}
    };

    public static void main(String[] args){
        N1840Ex2 q = new N1840Ex2();
        //q.ratedMap();
        //q.showRate();

        q.makeMap();
        //q.search();
        q.roateSearch();
    }

    private void roateSearch() {
        boolean[][] visited = new boolean[map.length][map[0].length];

        Queue<Integer[]> q = new LinkedList<>();
        q.offer(new Integer[]{2,2});

        rSearch(2,2, map, visited, q); //
    }

    int rCallCount = 0;
    private void rSearch(int x, int y, int[][]map, boolean[][] visited, Queue<Integer[]> q) {

//        if(x<0||y<0||x>=map[0].length||y>=map.length){
//            return;
//        }

        //------------------------------
        //
//        if(visited[y][x]){
//            return;
//        }
        if(q.isEmpty()){
            return;
        }

        Integer[] pos = (Integer[])q.poll();
        visited[pos[1]][pos[0]] = true;

        ++rCallCount;
        System.out.println( rCallCount + "{"+pos[0]+","+pos[1]+"}=" + map[pos[1]][pos[0]]);

        int x_ = pos[0];
        int y_ = pos[1];
        int maxX_ = map[0].length;
        int maxY_ = map.length;
        for(int[] pos_: rated) {
            if(y_+pos_[1]<0){
                continue;
            }
            if(x_+pos_[0]<0){
                continue;
            }
            if(x_+pos_[0]>=maxX_){
                continue;
            }
            if(y_+pos_[1]>=maxY_){
                continue;
            }

            if(!visited[y_+pos_[1]][x_+pos_[0]]){
                if( map[y_+pos_[1]][x_+pos_[0]] == 1 ){
                    q.offer(new Integer[]{x_ + pos_[0], y_ + pos_[1]});
                    rSearch(0, 0, map, visited, q);    // x, y
                }
            }

        }
    }

    private void ratedMap() {
        int[] step = {-1,0,1};
        rated = new int[6][2]; //
        for(int i=0;i<step.length;i++){
            for(int j=0;j<step.length;j++){
                if(step[i]==0 && step[j]==0){
                    continue;
                }
               System.out.println("{"+i+","+j+"}" + step[i] + "," + step[j]);
            }
        }
    }

    private void showRate(){
        System.out.println("showRate()------------");
        for(int i=0;i<rated.length;i++){
            for(int j=0;j<rated[i].length;j++){
                System.out.print(rated[i][j] + ",");
            }
            System.out.println("");
        }
        System.out.println("showRate()------------");
    }

    //--------------------------------
    //
    private void makeMap() {
        // 5*4 = 20
        map = new int[][]{
                 {1,0,0,1,1}
                ,{0,0,0,1,0}
                ,{0,1,0,1,1}
                ,{0,0,1,0,1}
        };
        y = map.length;
        x = map[0].length;

    }

    //
    private void search() {
        search_(3,3);
    }

    private void search_(int x_, int y_) {
        boolean[][] visited = new boolean[y][x];
        int maxX = x;
        int maxY = y;

        // 1Step Search
        fSearch(map, visited, x_, y_, maxX, maxY);
    }

    int callCount = 0;
    private void fSearch(int[][] map, boolean[][] visited, int x, int y, int maxX, int maxY) {
        if(x<0||y<0||x>=maxX||y>=maxY){
            return;
        }

        if(visited[y][x]){
            return;
        }

        visited[y][x] = true;
        ++callCount;
        System.out.println("{"+x+ "," + y+ "}=" + map[y][x] + " callCount:" + callCount);


//        if(map[y][x] == 0){
//            return;
//        }

        // visited check

        fSearch(map, visited, x-1, y, maxX, maxY);
        fSearch(map, visited, x+1,y, maxX, maxY);
        fSearch(map, visited, x, y-1, maxX, maxY);
        fSearch(map, visited, x, y+1, maxX, maxY);

    }


}
