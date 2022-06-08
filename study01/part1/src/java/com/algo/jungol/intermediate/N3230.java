package com.algo.jungol.intermediate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class Node{
    public int number;
    boolean visited;
    public List<NPath> paths = new ArrayList<>();
    public Node(int n){
        this.number = n;
    }
}

class NPath{
    public int toNumber;
    public int length;
    public NPath(int n, int l){
        this.toNumber = n;
        this.length = l;
    }
}

public class N3230 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int nCount = s.nextInt();
        int pos1 = s.nextInt();
        int pos2 = s.nextInt();

        //int[] nodes = new int[nCount+1];
        Node[] nodes = new Node[nCount + 1]; //

        for (int i = 1; i < nodes.length; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 1; i < nCount - 1; i++) {
            int n1 = s.nextInt();
            int n2 = s.nextInt();
            int len = s.nextInt();
            nodes[n1].paths.add(new NPath(n2, len));
            nodes[n2].paths.add(new NPath(n1, len));
        }

        System.out.println(" pos1:" + pos1 + " pos2:" + pos2);
        search(pos1, pos2, nodes);
    }

    private static void search(int pos1, int pos2, Node[] nodes) {
        Stack<Node> s = new Stack<>();

        nodes[pos1].visited = true;
        s.push(nodes[pos1]);
        int max = 0;
        int result = 0;
        search_(pos2, nodes, s, false);
    }

    static int addLength = 0;

    private static boolean search_(int pos2, Node[] nodes, Stack<Node> s, boolean bEnd) {

        if (!s.isEmpty()) {
            Node n = s.pop();
            System.out.println(" number:" + n.number + " add length:" + addLength);

            if (n.number == pos2) {   //
                System.out.println("[Find] number:" + n.number + " pos2:" + pos2 + " >>> add length:" + addLength);
                bEnd = true;
                return true;
            }

            //
            for (NPath p : n.paths) {

                if (!nodes[p.toNumber].visited) {
                    addLength += p.length;
                    System.out.println(" addLength:" + p.length);
                    nodes[p.toNumber].visited = true;
                    s.push(nodes[p.toNumber]);
                    //
                    search_(pos2, nodes, s, bEnd);
                } else {
                    //
                    addLength -= p.length;
                    System.out.println(" - length:" + p.length);
                }
            }
            //s.pop();
        }
        return true;
    }


}
