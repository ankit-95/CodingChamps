package com.codingchamps.SPOJ.BFS;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.*;

public class Akbar_SPOJ {

    static class Graph{
        int nodes;
        ArrayList<Integer> adj[];
        Graph(int nodes){
            this.nodes = nodes;
            adj = new ArrayList[nodes];
            for(int i=0;i<nodes;i++){
                adj[i] = new ArrayList<>();
            }
        }

        public void addEdge(int u,int v){
            adj[u].add(v);
            adj[v].add(u);
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

    static class Pair{
        int value;
        int depth;
        Pair(int val,int dep){
            this.value = val;
            this.depth = dep;
        }
    }
    public static boolean calculate(Graph g,int strength[],int N){

        Queue<Pair> q = new LinkedList<>();
        boolean visited[] = new boolean[N+1];
        for(int i=0;i<strength.length;i++){
            if(strength[i]!=-1){
                q.add(new Pair(i,strength[i]));
                visited[i] = true;
            }
        }
        while(!q.isEmpty()){
            Pair p = q.remove();
            int curStrength = p.depth;
            for(int v : g.adj[p.value]){
                if(!visited[v] && curStrength-1>=0){
                    visited[v] = true;
                    q.add(new Pair(v,curStrength-1));
                }
            }
        }

        for(int i=1;i<N+1;i++){
            if(visited[i]==false)
                return false;
        }
        return true;
    }
    public static void main(String args[]) throws IOException {
        Scan in = new Scan();
        Print out = new Print();
        int t = in.scanInt();
        while(t-->0){
            int N = in.scanInt();
            int R = in.scanInt();
            int M = in.scanInt();
            Graph g = new Graph(N+1);
            while(R-->0){
                int i = in.scanInt();
                int j = in.scanInt();
                g.addEdge(i,j);
                g.addEdge(j,i);
            }
            int strength[] = new int[N+1];
            Arrays.fill(strength,-1);
            while(M-->0){
                int i = in.scanInt();
                int j = in.scanInt();
                strength[i] = j;
            }
            if(calculate(g,strength,N)){
                System.out.println("Yes");
            } else
                System.out.println("No");
       }
    }
}
