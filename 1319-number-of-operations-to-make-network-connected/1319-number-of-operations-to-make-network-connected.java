class Solution {
    
    public int find(int parent[],int u){
        if(u!=parent[u]){
            parent[u] = find(parent,parent[u]);
        }
        return parent[u];
    }
    
    public int makeConnected(int n, int[][] connections) {
        
        int parent[] = new int[n];
        for(int i=0;i<n;i++)
            parent[i] = i;
        int extraEdges = 0;
        for(int c[] : connections){
            int u = c[0];
            int v = c[1];
            if(find(parent,u)!=find(parent,v)){
                parent[find(parent,v)] = find(parent,u);
            } else {
                extraEdges++;
            }
        }
        int components = 0;
        for(int i= 0;i<n;i++){
            System.out.print(parent[i]+" ");
            if(i==parent[i])
              components++;  
        }
        
        return extraEdges>=(components-1) ? (components-1) : -1;
    }
}