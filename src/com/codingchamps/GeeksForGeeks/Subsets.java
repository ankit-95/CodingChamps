package com.codingchamps.GeeksForGeeks;

import java.util.ArrayList;

public class Subsets {
    public static void getSubSets(int index,ArrayList<Integer> data,ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ans){
        if(index==data.size()){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(data.get(index));
        getSubSets(index+1,data,list,ans);
        list.remove(list.size()-1);
        getSubSets(index+1,data,list,ans);
    }
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A)
    {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        getSubSets(0,A,new ArrayList<Integer>(),ans);
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> ar = new ArrayList<>();
        ar.add(1);
        ar.add(2);
        ar.add(3);

        ArrayList<ArrayList<Integer>> ans =  subsets(ar);
        System.out.println(ans);
    }
}
