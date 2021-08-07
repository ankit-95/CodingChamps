package com.codingchamps.RecursionProblems;


/*In Family of Akaash every male gives birth to first Male and then Female whereas each Female gives birth to first female
then male
We are given nth generation and kth child. We need to find the Gender of child.
Input : N = 3 , k = 4

Tree :
Since Akkash is Male therefore :
                            M                   1st Generation
                      M           F             2nd Generation
                   M     F      F     M         3rd Generation --> N=3 i.e and k=4 which is Male.
                 M   F F   M  F   M M   F       4th Generation
Input : N=3, K=3
Output : Female

*/
public class FamilyProblem {

    public static String kthChildInNthGeneration(String root_node,int n, int k){
        if(n==1 || k==1){
            return root_node;
        }
        double noOfChild = Math.pow(2,n-1);
        int temp = (int) noOfChild/2;
        if(k> temp){
            String new_root = "Male";
            if(root_node.equals("Male")){
                new_root="Female";
            }
            return kthChildInNthGeneration(new_root,n-1,k-temp);
        } else
        return kthChildInNthGeneration(root_node,n-1,k);
    }
    public static void main(String args[]){
        int n=4,k=6;
        System.out.println(k+"th Child of "+n+" Generation id : "+kthChildInNthGeneration("Male",n,k));
    }
}
