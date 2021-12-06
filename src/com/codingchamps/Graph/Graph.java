package com.codingchamps.Graph;

import java.util.ArrayList;

public class Graph {

    int nodes;
    ArrayList<Integer> adj[]; // adajency List
    Graph(int nodes){
        this.nodes = nodes;
        adj = new ArrayList[nodes];
        for(int i =0;i<nodes;i++)
            adj[i] = new ArrayList<>();
    }

    public void addEdge(int u,int v){
        adj[u].add(v);
    }

    public void traverseList(){
        for(int i=0;i<nodes;i++){
            System.out.print(i+" -->");
            for(int vertex : adj[i])
                System.out.print(vertex+"->");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0,4);
        graph.addEdge(1,0);
        graph.addEdge(2,1);
        graph.addEdge(2,4);
        graph.addEdge(3,1);
        graph.addEdge(3,2);
        graph.addEdge(4,3);

        graph.traverseList();

    }

}
