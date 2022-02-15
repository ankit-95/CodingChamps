package com.codingchamps.Tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class ViewOfTree {

    Node root;
    static int maxLevel;

    ViewOfTree(){
        this.maxLevel = 0;
    }
    public static class Node {
        int data;
        Node left,right;

        Node(int data){
            this.data = data;
            left=right=null;
        }
    }

    public static class Pair{
        Node node;
        int level;
        Pair(Node node, int level){
            this.node = node;
            this.level = level;
        }
    }

    public static void leftView(Node root, int level){
        if(root==null)
            return;
        else {
            if(maxLevel < level){
                System.out.print(root.data+"->");
                maxLevel = level;
            }
            leftView(root.left, level+1);
            leftView(root.right, level+1);
        }
    }

    public static void rightView(Node root, int level){
        if(root==null)
            return;
        else {
            if(maxLevel < level){
                System.out.print(root.data+"->");
                maxLevel = level;
            }
            rightView(root.right, level+1);
            rightView(root.left, level+1);
        }
    }

    public static void topViewOfBT(Node root){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        Map<Integer,Integer> map = new TreeMap<>();
        while(!q.isEmpty()){
            Pair temp = q.remove();
            if(!map.containsKey(temp.level)){
                map.put(temp.level,temp.node.data);
            }
            if(temp.node.left!=null){
                q.add(new Pair(temp.node.left, temp.level-1));
            }
            if(temp.node.right!=null){
                q.add(new Pair(temp.node.right, temp.level+1));
            }
        }

        for(Map.Entry<Integer, Integer> v : map.entrySet()){
            System.out.print(v.getValue()+" ");
        }
    }

    public static void bottomViewBT(Node root){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        Map<Integer,Integer> map = new TreeMap<>();
        while(!q.isEmpty()){
            Pair temp = q.remove();
            map.put(temp.level,temp.node.data);
            if(temp.node.left!=null){
                q.add(new Pair(temp.node.left, temp.level-1));
            }
            if(temp.node.right!=null){
                q.add(new Pair(temp.node.right, temp.level+1));
            }
        }

        for(Map.Entry<Integer, Integer> v : map.entrySet()){
            System.out.print(v.getValue()+" ");
        }
    }
    public static void main(String[] args) {

        ViewOfTree tree1 = new ViewOfTree();

        tree1.root = new Node(1);
        tree1.root.left = new Node(2);
        tree1.root.right = new Node(3);
        tree1.root.left.left = new Node(4);
        tree1.root.left.right = new Node(5);
        tree1.root.right.right = new Node(6);

        System.out.print("Left View of Tree : ");
        leftView(tree1.root,1);

        ViewOfTree tree2 = new ViewOfTree();

        tree2.root = new Node(1);
        tree2.root.left = new Node(2);
        tree2.root.right = new Node(3);
        tree2.root.left.left = new Node(4);
        tree2.root.left.right = new Node(5);
        tree2.root.right.right = new Node(6);

        System.out.print("\nRight View of Tree : ");
        rightView(tree2.root,1);

        System.out.print("\nTop View of Tree : ");
        topViewOfBT(tree2.root);

        System.out.print("\nBotton View of Tree : ");
        bottomViewBT(tree2.root);

    }
}
