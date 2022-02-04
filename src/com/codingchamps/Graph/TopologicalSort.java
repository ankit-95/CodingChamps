package com.codingchamps.Graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class TopologicalSort {
    int nodes;
    ArrayList<Integer> adj[];

    TopologicalSort(int nodes){
        this.nodes = nodes;
        adj = new ArrayList[nodes];
        for (int i=0;i<nodes;i++){
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int u,int v){
        adj[u].add(v);
    }

    public void displayGraph(){
        for(int i=0;i<nodes;i++){
            System.out.print(i+"->");
            for(int v : adj[i]){
                System.out.print(v+"->");
            }
            System.out.println();
        }
    }

    public void topoSort(){
        Stack<Integer> s = new Stack<>();
        boolean visited[] = new boolean[nodes];
        for(int i=0;i<nodes;i++){
            if(!visited[i]){
                topoSortUtil(i,visited,s);
            }
        }

        Iterator itr = s.iterator();
        while(itr.hasNext()){
            System.out.print(s.pop()+" ");
        }
    }

    public void topoSortUtil(int i, boolean[] visited, Stack<Integer> s) {
        visited[i] = true;
        for(int v : adj[i]){
            if(!visited[v]){
                topoSortUtil(v,visited,s);
            }
        }
        s.push(i);
    }

    public static void main(String[] args) {
        TopologicalSort g = new TopologicalSort(6);
        g.addEdge(5,0);
        g.addEdge(4,0);
        g.addEdge(5,2);
        g.addEdge(2,3);
        g.addEdge(4,1);
        g.addEdge(3,1);
        System.out.println("Graph is : ");
        g.displayGraph();
        System.out.println("Topological Sort is : ");
        g.topoSort();
    }
}

