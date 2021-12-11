package com.codingchamps.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintCornerNodes {

    public void cornerNodes(int src, int nodes, ArrayList<Integer> adj[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            int size=q.size();
            int n = size;
            while(n-->0){
                int v = q.poll();
                if(n==size-1 || n==0){
                    System.out.print(v+" ");
                }
                for(int vertex : adj[v]){
                    q.add(vertex);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Graph g = new Graph(7);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        g.addEdge(2,5);
        g.addEdge(2,6);

        PrintCornerNodes printCornerNodes = new PrintCornerNodes();
        printCornerNodes.cornerNodes(0,g.nodes,g.getAdjList());
    }
}
