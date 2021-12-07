package com.codingchamps.Graph;

import java.util.ArrayList;

/*
Given a graph, find the arrival and departure time of its vertices in DFS.
The arrival time is the time at which the vertex was explored for the first time in the DFS,
and departure time is the time at which we have explored all the neighbors of the vertex, and we are ready to backtrack.

The time complexity of DFS traversal is O(V + E), where V and E are the total number of vertices and edges in the graph, respectively.
Please note that O(E) may vary between O(1) and O(V2), depending on how dense the graph is.
 */
public class TimingInGraph {

    public static void getTiming(int nodes, ArrayList<Integer> adj[]){
        int arrival[] = new int[nodes];
        int departure[] = new int[nodes];
        int time=-1;
        boolean visited[] = new boolean[nodes];
        for(int i=0;i<nodes;i++){
            if(!visited[i])
                time = DFS(i,adj,arrival,departure,visited,time);
        }

        for(int i=0;i<nodes;i++){
            System.out.println("vertex "+i+" ("+arrival[i]+","+departure[i]+")");
        }
    }

    private static int DFS(int i, ArrayList<Integer>[] adj, int[] arrival, int[] departure,boolean visited[], int time) {
        arrival[i] = ++time;
        visited[i] = true;
        for(int vertex : adj[i]){
            if(!visited[vertex])
                time = DFS(vertex,adj,arrival,departure,visited,time);
        }
        departure[i] = ++time;
        return time;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(2,3);
        graph.addEdge(2,4);
        graph.addEdge(3,1);
        graph.addEdge(3,5);
        graph.addEdge(4,5);
        graph.addEdge(6,7);

        graph.traverseList();
        getTiming(graph.nodes, graph.adj);
    }
}
