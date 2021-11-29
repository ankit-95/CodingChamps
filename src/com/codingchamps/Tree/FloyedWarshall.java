package com.codingchamps.Tree;

import java.util.Arrays;
import java.util.LinkedList;

public class FloyedWarshall {

    final static int INF = 99999;
    int nodes;
    LinkedList<Integer> adj[];

    FloyedWarshall(int nodes){
        this.nodes = nodes;
        adj = new LinkedList[nodes];
        for(int i=0;i<nodes;i++)
            adj[i] = new LinkedList<>();
    }

    public static void floyedWarshall(int [][] G){
        int V = G.length;
        int distnace[][] = new int[V][V];

        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++)
                distnace[i][j] = G[i][j];
        }

        for(int k=0;k<V;k++){
            for(int i=0;i<V;i++){
                for(int j=0;j<V;j++){
                    if(distnace[i][k] + distnace[k][j] < distnace[i][j]){
                        distnace[i][j] = distnace[i][k] + distnace[k][j];
                    }
                }
            }
        }

        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(distnace[i][j] == INF)
                    System.out.print(" INF");
                else
                    System.out.print(" "+distnace[i][j]);
            }
            System.out.println();
        }
    }

    public static void transitiveClosureApp1(int G[][]){
        int V = G.length;
        int output[][] = new int[V][V];
        for(int i=0;i<V;i++)
            for(int j=0;j<V;j++)
            output[i][j] = G[i][j];
        for(int k=0;k<V;k++){
            for(int i=0;i<V;i++){
                for(int j=0;j<V;j++){
                    output[i][j] = (output[i][j]!=0) || ((output[i][k]!=0) && (output[k][j]!=0))?1:0;
                }
            }
        }
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                System.out.print(output[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void DFS(byte C[][],int root, int child){

        if(root == child){
            if(this.adj[root].contains(child)){
                C[root][child]=1;
            }
        } else {
            C[root][child] = 1;
        }
        for(int neighbour : this.adj[root]) {
            if(C[root][neighbour]==0){
                DFS(C,root,neighbour);
            }
        }
    }

    public void transitiveApp2UsingDFS(){

        byte C[][] = new byte[nodes][nodes];
        for(int i=0;i<nodes;i++){
            C[i][i] = 1;
            DFS(C,i,i);
            System.out.println(Arrays.toString(C[i]));
        }
    }

    public void addEdge(int u,int v){
        adj[u].add(v);
       // adj[v].add(u);
    }
    public static void main(String[] args) {

        /* Let us create the following weighted graph
           10
        (0)------->(3)
        |         /|\
        5 |          |
        |          | 1
        \|/         |
        (1)------->(2)
           3           */
        int g[][] = { {0,   5,  INF, 10},
                {INF, 0,   3, INF},
                {INF, INF, 0,   1},
                {INF, INF, INF, 0}
        };

    //        floyedWarshall(g);

        int graph[][] = new int[][]{ {1, 1, 0, 1},
                {0, 1, 1, 0},
                {0, 0, 1, 1},
                {0, 0, 0, 1}
        };
    //    transitiveClosureApp1(graph);

        FloyedWarshall graphDeploy = new FloyedWarshall(4);
        graphDeploy.addEdge(0, 1);
        graphDeploy.addEdge(0, 2);
        graphDeploy.addEdge(1, 2);
        graphDeploy.addEdge(2, 0);
        graphDeploy.addEdge(2, 3);
        graphDeploy.addEdge(3, 3);
        graphDeploy.transitiveApp2UsingDFS();


    }
}
