class Solution {
    public int findCenter(int[][] edges) {
        int vertices[] = new int[edges.length+2];
        for(int i=0;i<edges.length;i++){
            vertices[edges[i][0]]+=1;
            vertices[edges[i][1]]+=1;      
        }
        
        for(int i=1;i<vertices.length;i++){
            if(vertices[i] == vertices.length-2){
                return i;
            }
        }
        return -1;
    }
}