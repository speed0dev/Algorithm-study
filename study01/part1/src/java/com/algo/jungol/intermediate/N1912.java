package com.algo.jungol.intermediate;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Room{
    public boolean bVisited = false;
    public int number = 0;
    public List<Integer> link = new ArrayList<>();
    public void add(int num){
        link.add(num);
    }
}

//-------------------------------
//
public class N1912 {

    Room[] rooms = null;

    public static void main(String[] args){
        quest1();
        //quest2();


    }

    private static void quest2() {
        N1912 n = new N1912();
        n.makeRoom(10000+1);  //
        int[][] links = new int[][]{
                {1,3}
                ,{3,4}
                ,{4,2}
                ,{2,1}
                ,{1,4}
                ,{4,5}
                ,{1,10}
                ,{1,100}
                ,{1,200}
                ,{1,300}
                ,{1,400}
                ,{2,7}
                ,{2,120}
                ,{5,15}
                ,{5,11}
                ,{5,7}
                ,{5,8}
                ,{7,10}
                ,{7,2}
        };
        n.linkInfo(links);
        n.Search();
    }

    private static void quest1() {
        N1912 n = new N1912();
        n.makeRoom(5+1);  //
        int[][] links = new int[][]{
                {1,3}
                ,{3,4}
                ,{4,2}
                ,{2,1}
                ,{1,4}
                ,{4,5}
        };
        n.linkInfo(links);
        n.Search();
    }

    //
    private void Search() {
        Stack<Room> s = new Stack<>();
        rooms[1].bVisited = true;
        s.add(rooms[1]);    //

        search_(rooms, s);
    }

    //
    private void search_(Room[] rooms, Stack<Room> s) {

        if(s.isEmpty()){
            return;
        }

        //
        Room r = s.peek();
        System.out.println(" =>" + r.number);  // 방문

        for(int num: r.link){
            //
            if(!rooms[num].bVisited){
                rooms[num].bVisited = true;
                s.push(rooms[num]);
                //
                search_(rooms, s);
            }
        }
        //
        Room tmp = s.pop();
        System.out.println("            pop() =>" + r.number);

    }

    //
    private void makeRoom(int n) {
        rooms = new Room[n];
        for(int i=0;i<n;i++){
            rooms[i] = new Room();
            rooms[i].number = i;
        }

    }

    //
    private void linkInfo(int[][] links) {

        //
        for(int[] node: links){
            //System.out.println(" node:{" + node[0]  + ","+ node[1] + "}");
            rooms[node[0]].add(node[1]);
            rooms[node[1]].add(node[0]);
        }

        // sort
        for(Room r: rooms){
            r.link.sort((a,b)->{
                if(a>b){
                    return 1;
                }
                return -1;
            });
        }

    }



}

