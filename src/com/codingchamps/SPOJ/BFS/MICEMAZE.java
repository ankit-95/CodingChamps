package com.codingchamps.SPOJ.BFS;

import java.util.*;
import java.lang.*;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

// Sample Test Case
//Input
//        4
//        2
//        1000000
//        8
//        1 2 3423233
//        1 3 2233
//        2 1 2323221
//        2 4 123
//        3 1 12
//        3 4 1232
//        4 2 43231
//        4 3 329
//Output
//        4
public class MICEMAZE
{
    static class Graph {
        int nodes;
        ArrayList<Pair> adj[];

        public class Pair{
            int dest;
            int wt;
            Pair(int dest,int wt){
                this.dest = dest;
                this.wt = wt;
            }
        }
        Graph(int nodes){
            this.nodes = nodes;
            adj = new ArrayList[nodes];
            for(int i=0;i<nodes;i++)
                adj[i] = new ArrayList<>();
        }
        public void addEdge(int u,int v,int wt){
            adj[u].add(new Pair(v,wt));
        }

        public int dijakstra(int src,int d){
            int distance[] = new int[nodes];
            boolean visited[] = new boolean[nodes];
            for(int i=0;i<this.nodes;i++){
                visited[i] =false;
                distance[i] = Integer.MAX_VALUE;
            }
            distance[src] = 0;
            for(int i=0;i<nodes;i++){
                int u = getMindisNode(distance,visited);
                visited[u] = true;
                for(Pair p : this.adj[u]){
                    if(!visited[p.dest] && distance[u] + p.wt < distance[p.dest]){
                        distance[p.dest] = distance[u] + p.wt;
                    }
                }
            }
            int count=0;
            for(int i=0;i<this.nodes;i++){
                // System.out.println("Distance from src : "+src+" to destinaton : "+ i+ " is : "+distance[i]);
                if(distance[i]<=d) count++;
            }

            return count;
        }

        public int getMindisNode(int dis[],boolean visited[]){
            int minDis = Integer.MAX_VALUE;
            int minNode = -1;
            for(int i=0;i<nodes;i++){
                if(!visited[i] && dis[i] < minDis){
                    minDis = dis[i];
                    minNode = i;
                }
            }
            return minNode;
        }

    }
    // fast I/O
    static class Scan
    {
        private byte[] buf=new byte[1024];    //Buffer of Bytes
        private int index;
        private InputStream in;
        private int total;
        public Scan()
        {
            in=System.in;
        }
        public int scan()throws IOException    //Scan method used to scan buf
        {
            if(index>=total)
            {
                index=0;
                total=in.read(buf);
                if(total<=0)
                    return -1;
            }
            return buf[index++];
        }
        public int scanInt()throws IOException
        {
            int big=0;
            int n=scan();
            while(isWhiteSpace(n))    //Removing starting whitespaces
                n=scan();
            int neg=1;
            if(n=='-')                //If Negative Sign encounters
            {
                neg=-1;
                n=scan();
            }
            while(!isWhiteSpace(n))
            {
                if(n>='0'&&n<='9')
                {
                    big*=10;
                    big+=n-'0';
                    n=scan();
                }
                else throw new InputMismatchException();
            }
            return neg*big;
        }
        private boolean isWhiteSpace(int n)
        {
            if(n==' '||n=='\n'||n=='\r'||n=='\t'||n==-1)
                return true;
            return false;
        }
    }

    static class Print
    {
        private final BufferedWriter bw;
        public Print()
        {
            this.bw=new BufferedWriter(new OutputStreamWriter(System.out));
        }
        public void print(Object object)throws IOException
        {
            bw.append(""+object);
        }
        public void println(Object object)throws IOException
        {
            print(object);
            bw.append("\n");
        }
        public void close()throws IOException
        {
            bw.close();
        }
    }

    public static void main (String[] args) throws IOException
    {
        try {
            Scan in = new Scan();
            Print out = new Print();
            int N = in.scanInt();
            Graph g = new Graph(N);
            int src = in.scanInt();
            int T = in.scanInt();
            int connect = in.scanInt();
            while (connect-- != 0) {
                int a = in.scanInt() - 1;
                int b = in.scanInt() - 1;
                int wt = in.scanInt();
                g.addEdge(b, a, wt);
            }
            System.out.print(g.dijakstra(src - 1, T));
        }
        catch (Exception e){
            return;
        }
    }
}