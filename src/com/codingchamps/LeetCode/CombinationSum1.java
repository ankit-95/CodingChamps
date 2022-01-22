package com.codingchamps.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum1 {
    public static void combinationSumProb1(int ar[], int index, int target, List<Integer> list, List<List<Integer>> ans){
        if(index==ar.length){
            if(target==0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        if(ar[index] <= target){
            list.add(ar[index]);
            combinationSumProb1(ar,index,target-ar[index],list,ans);
            list.remove(list.size()-1);
        }
        combinationSumProb1(ar,index+1,target,list,ans);
    }

    public static void main(String[] args) {
        // Combinations of given Sum
        List<List<Integer>> ans = new ArrayList<>();
        int ar[] = {2,3,6,7};
        int target = 7;
        combinationSumProb1(ar,0,target,new ArrayList<>(),ans);
        System.out.println(ans);
    }
}
