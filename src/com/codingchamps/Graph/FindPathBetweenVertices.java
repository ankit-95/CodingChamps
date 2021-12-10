package com.codingchamps.Graph;

import com.codingchamps.Practice.GraphPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FindPathBetweenVertices {

    int nodes;
    int parent[];
    ArrayList<Integer> path;
    ArrayList<Integer> adj[];
    FindPathBetweenVertices(int nodes){
        this.nodes = nodes;
        parent = new int[nodes];
        adj = new ArrayList[nodes];
        for(int i=0;i<nodes;i++)
            adj[i] = new ArrayList<>();
        //    Arrays.fill(parent,-1);
        path = new ArrayList<>();
    }

    public void addEdge(int u,int v){
        adj[u].add(v);
    }

    public boolean findPathUsingBFS(int u,int v){
        Arrays.fill(parent,-1);
        Queue<Integer> q = new LinkedList<>();
        q.add(u);
        boolean visited[] = new boolean[nodes];
        visited[u] = true;
        while(!q.isEmpty()){
            int ver = q.poll();
            for(int vertex : adj[ver]){
                if(!visited[vertex]){
                    visited[vertex]=true;
                    parent[vertex] = ver;
                    q.add(vertex);
                    if(v==vertex)
                        return true;
                }
            }
        }
        return false;
    }

    public boolean isReachable(int u,int v,boolean visited[]){
        visited[u] = true;
        path.add(u);
        if(u==v){
            return true;
        }
        for(int vertex : adj[u]){
            if(isReachable(vertex,v,visited)){
                return true;
            }
        }
        path.remove(path.size()-1);
        return false;
    }

    public boolean findPathUsingDFS(int u,int v){
        boolean visited[] = new boolean[nodes];
        boolean isPath = isReachable(u,v,visited);
        return isPath;
    }

    public static void main(String[] args) {
        FindPathBetweenVertices g = new FindPathBetweenVertices(8);
        g.addEdge(0,3);
        g.addEdge(1,0);
        g.addEdge(1,2);
        g.addEdge(1,4);
        g.addEdge(2,7);
        g.addEdge(3,5);
        g.addEdge(3,4);
        g.addEdge(4,3);
        g.addEdge(4,6);
        g.addEdge(5,6);
        g.addEdge(6,7);

//        System.out.println(g.findPathUsingBFS(0,7));
//        Stack s = new Stack();
//        for(int v = 7;v!=-1;v=g.parent[v]){
//            s.push(v);
//        }
//        Iterator itr = s.iterator();
//        while(itr.hasNext()){
//            System.out.print(s.pop()+" ");
//        }

        g.findPathUsingDFS(0,7);
        for(int i=0;i<g.path.size();i++){
            System.out.print(g.path.get(i)+" ");
        }

    }
}
