package com.codingchamps.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintNodesBetweenLevels {

    public void printNodes(int l1, int l2, int nodes, ArrayList<Integer> adj[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int level=0;
        while(!q.isEmpty()){
             int size=q.size();
             while (size-->0){
                 int u = q.poll();
                 if(level>=l1 && level<=l2){
                     System.out.print(u+" ");
                 } else if(level > l2){
                     return;
                 }
                 for(int v : adj[u]){
                     q.add(v);
                 }
             }
             level++;
        }
    }
    public static void main(String[] args) {
        Graph g = new Graph(8);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        g.addEdge(2,5);
        g.addEdge(2,6);
        PrintNodesBetweenLevels path = new PrintNodesBetweenLevels();
        path.printNodes(1,2,g.nodes,g.getAdjList());
    }
}
