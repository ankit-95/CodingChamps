// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
                        
        }
	}
}

// } Driver Code Ends


class Solution {
    
    public void helper(int index, char ch[],String perm,List<String> ans){
        if(index==ch.length){
            ans.add(perm);
            return; 
        }
        for(int i=index;i<ch.length;i++){
            swap(index,i,ch);
            helper(index+1,ch,perm+ch[index],ans);
            swap(index,i,ch);
        }
    }
    
    public void swap(int a,int b,char ch[]){
        char temp = ch[a];
        ch[a] = ch[b];
        ch[b] = temp;
    }
    public List<String> find_permutation(String S) {
        List<String> ans = new ArrayList<>();
        helper(0,S.toCharArray(),"",ans);
        Collections.sort(ans);
        return ans;
    }
}