package com.codingchamps.Tree;

import java.util.*;

public class BoundaryTraversalBT {

    Node root;
    public static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    BoundaryTraversalBT(){
        root=null;
    }

    public void leftView(Node root,HashSet<Integer> visited){
        root = root.left;
        while(root!=null){
           // if(root.left!=null && root.right!=null){
                if(!visited.contains(root.data)){
                    System.out.print(root.data+" ");
                    visited.add(root.data);
                }
           // }
            if(root.left==null)
                root = root.right;
            else root = root.left;
        }
    }

    public void rightView(Node root,HashSet<Integer> visited){
        root = root.right;
        ArrayList<Integer> arr = new ArrayList<>();
        while(root!=null){
            //if(root.left!=null && root.right!=null){
                if(!visited.contains(root.data)){
                    arr.add(root.data);
                    visited.add(root.data);
                }
           // }
            if(root.right==null)
                root = root.left;
            else root = root.right;
        }
        for(int i = arr.size()-1;i>=0;i--){
            System.out.print(arr.get(i)+" ");
        }
    }

    public class Pair{
        Node node;
        int level;
        Pair(Node node, int level){
            this.node = node;
            this.level = level;
        }
    }
    public void bottomView(Node root,HashSet<Integer> visited){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        Map<Integer,Integer> map = new TreeMap<>();
        while(!q.isEmpty()){
            Pair temp = q.remove();
            map.put(temp.level, temp.node.data);
            if(temp.node.left!=null){
                q.add(new Pair(temp.node.left,temp.level-1));
            }
            if(temp.node.right!=null){
                q.add(new Pair(temp.node.right,temp.level+1));
            }
        }
        for(Map.Entry<Integer,Integer> v : map.entrySet()){
            if(!visited.contains(v.getValue()))
                System.out.print(v.getValue()+" ");
        }
    }

    public void boundaryTraversal(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data + " ");
        HashSet<Integer> visited = new HashSet<>();
        leftView(root,visited);
        bottomView(root,visited);
        rightView(root,visited);
    }
    public static void main(String[] args) {

        BoundaryTraversalBT t = new BoundaryTraversalBT();
        t.root = new Node(1);
        t.root.left = new Node(2);
        t.root.right = new Node(8);
 //       t.root.left.left = new Node(4);
        t.root.left.right = new Node(3);
        t.root.left.right.left = new Node(4);
        t.root.left.right.right = new Node(5);
        t.root.left.right.right.left = new Node(6);
        t.root.left.right.right.left.left = new Node(7);

        t.boundaryTraversal(t.root);

    }
}
