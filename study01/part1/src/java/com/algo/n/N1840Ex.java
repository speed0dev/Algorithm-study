package com.algo.n;

public class N1840Ex {

    private int[][] cheese = null;
    private int x = 0;
    private int y = 0;

    public static void main(String[] args){
        multiArrayCheck();
        N1840Ex q = new N1840Ex();
        q.makeCheese();
        q.solv();
        
    }


    private static void multiArrayCheck() {
        int[][] map = {
                {1,1,1}
                ,{0,1,1}
        };
    }

    private  void makeCheese() {
        x = 13;
        y = 12;
        cheese = new int[][]{
                  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
                , {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
                , {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0}
                , {0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0}
                , {0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0}
                , {0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0}
                , {0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0}
                , {0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0}
                , {0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0}
                , {0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0}
                , {0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0}
                , {0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0}
                , {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        
    }

    //
    int time = 0;
    private void solv() {
        int cheeseCnt = 0;
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                if(cheese[i][j] == 1){
                    cheeseCnt++;
                }
            }
        }

        //
        time = 0;
        int lastcheese = cheeseCnt;
        while(true){
            time++;  // 1
            cheeseCnt -= find(cheese, 0, 0, x, y, time+3, -time, 1, -1);  // 4, -1
            if(cheeseCnt == 0){
                break;
            }
            lastcheese = cheeseCnt;
        }

        System.out.println(time);
        System.out.println(lastcheese);

    }

    public int find(int[][] array, int x, int y, int xsize, int ysize, int num, int num2, int numup, int num2up){
        if(x<0||y<0||x>=xsize||y>=ysize){

            return 0;
        }
        int value = array[x][y]; ///

        if(value == num){

            return 0;
        }
        System.out.println( "time:" + time +  " @ val:" + value + " x:" + x + " y:" + y + " num:" + num + " num2:" + num2 + " numup:" + numup + " num2up:" + num2up );
        if(value==1 || (value == num2-numup)){
            array[x][y] = num2;
            return 1;   //
        }
        int amount = 0;
        value = array[x][y];
        //
        if(value==0|| value==num-1 || value==num2-num2up){ // -1-1 =-2
            array[x][y] = num;
            amount += find(array, x-1, y, xsize, ysize, num, num2, numup, num2up); // 왼쪽 num:4 num2:-1 numup 1 num2up -1
            amount += find(array, x+1, y, xsize, ysize, num, num2, numup, num2up); // 오른쪽
            amount += find(array, x, y-1, xsize, ysize, num, num2, numup, num2up); // 위쪽
            amount += find(array, x, y+1, xsize, ysize, num, num2, numup, num2up); // 아래쪽
        }
        return amount;
    }


}
