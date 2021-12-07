package com.codingchamps.Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class findRootVertex {

    public static void main(String[] args) {

        Graph graph = new Graph(6);

        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,0);
        graph.addEdge(4,3);
        graph.addEdge(4,5);
        graph.addEdge(5,0);

        graph.traverseList();

        System.out.println("Root vertex is : "+ getRootVertex(graph.nodes, graph.adj));
    }

    private static int getRootVertex(int nodes, ArrayList<Integer>[] adj) {

        boolean visited[] = new boolean[nodes];
        int v=0;
        for(int i=0;i<nodes;i++){
            if(!visited[i]){
                DFS(i,nodes,adj,visited);
                v=i; // last visited node. i.e node with max departure time.
            }
        }

        Arrays.fill(visited,false);

        DFS(v,nodes,adj,visited);
        for(int i=0;i<nodes;i++){
            if(!visited[i])
                return -1;
        }
        return v;
    }

    private static void DFS(int i, int nodes, ArrayList<Integer>[] adj, boolean[] visited) {
        visited[i] = true;
        for(int vertex : adj[i]){
            if(!visited[vertex])
                DFS(vertex,nodes,adj,visited);
        }
    }
}
