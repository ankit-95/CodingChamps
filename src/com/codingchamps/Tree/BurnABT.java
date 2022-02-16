package com.codingchamps.Tree;

import java.util.*;

public class BurnABT {

    public void markParents(Map<TreeTemplate.Node, TreeTemplate.Node> parent, TreeTemplate.Node root){
        Queue<TreeTemplate.Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeTemplate.Node temp = q.remove();
            if(temp.left!=null){
                parent.put(temp.left,temp);
                q.add(temp.left);
            }
            if(temp.right!=null){
                parent.put(temp.right,temp);
                q.add(temp.right);
            }
        }
    }
    public int burnTree(TreeTemplate.Node root, int data){
        Map<TreeTemplate.Node, TreeTemplate.Node> parent = new TreeMap<>(new Comparator<TreeTemplate.Node>() {
            @Override
            public int compare(TreeTemplate.Node o1, TreeTemplate.Node o2) {
                if(o1.data > o2.data){
                    return 1;
                } else if ( o1.data < o2.data)
                    return -1;
                return 0;
            }
        });
        markParents(parent,root);
        TreeTemplate.Node getNode = findNode(root,data);
        if(getNode ==null)
            return -1;
//        System.out.println(getNode.data);
//        for(Map.Entry<Node,Node> v : parent.entrySet()){
//            System.out.println(v.getKey().data +" child of " + v.getValue().data);
//        }
        // Burn the tree Logic
        Queue<TreeTemplate.Node> q = new LinkedList<>();
        q.add(getNode);
        HashSet<TreeTemplate.Node> visited = new HashSet<>();
        int time =0;
        visited.add(getNode);
        while(!q.isEmpty()){
            int size = q.size();
            int f1=0;
            while(size-->0){
                TreeTemplate.Node temp = q.remove();
                if(temp.left !=null && !visited.contains(temp.left)){
                    q.add(temp.left);
                    visited.add(temp.left);
                    f1=1;
                }
                if(temp.right !=null && !visited.contains(temp.right)){
                    q.add(temp.right);
                    visited.add(temp.right);
                    f1=1;
                }
                if(parent.containsKey(temp) && !visited.contains(parent.get(temp))){
                    q.add(parent.get(temp));
                    visited.add(parent.get(temp));
                    f1=1;
                }
            }
            if(f1==1)
                time++;
        }
        return time;
    }

    public TreeTemplate.Node findNode(TreeTemplate.Node root, int data){
        Queue<TreeTemplate.Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeTemplate.Node temp = q.remove();
            if(temp.data==data){
                return temp;
            }
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeTemplate t = new TreeTemplate();
        t.root = new TreeTemplate.Node(1);
        t.root.left = new TreeTemplate.Node(2);
        t.root.right = new TreeTemplate.Node(3);
        t.root.left.left = new TreeTemplate.Node(4);
        t.root.right.left = new TreeTemplate.Node(5);
        t.root.right.right = new TreeTemplate.Node(6);
        t.root.left.left.right = new TreeTemplate.Node(7);

        BurnABT burnBT = new BurnABT();

        System.out.println("Time taken is seconds to burn the complete tree : "+ burnBT.burnTree(t.root,2));
    }
}
