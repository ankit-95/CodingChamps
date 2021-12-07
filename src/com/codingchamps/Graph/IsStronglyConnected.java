package com.codingchamps.Graph;

import java.util.ArrayList;

public class IsStronglyConnected {

    // Time Complexity O(v*(v + e))
    public static boolean isStronglyConnected(int nodes, ArrayList<Integer> adj[]) {

        for(int i =0;i<nodes;i++){
            boolean visited[] = new boolean[nodes];
            DFS(i,adj,visited);
            for(boolean check : visited){
                if(!check)
                    return false;
            }
        }
        return true;
    }

    public static void DFS(int src, ArrayList<Integer> adj[], boolean visited[]){
        visited[src] = true;
        for(int vertex : adj[src]){
            if(!visited[vertex]){
                DFS(vertex,adj,visited);
            }
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
        ArrayList<Integer> adj[] = graph.getAdjList();

        if(isStronglyConnected(graph.nodes, adj))
            System.out.println("The graph is strongly connected");
        else
            System.out.println("The graph is not strongly connected");
    }
}
