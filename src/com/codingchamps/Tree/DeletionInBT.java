package com.codingchamps.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class DeletionInBT {

    public static void inOrder(TreeTemplate.Node temp){
        if(temp==null)
            return;
        inOrder(temp.left);
        System.out.print(temp.data+" ");
        inOrder(temp.right);
    }

    public static void deletion(TreeTemplate.Node root, TreeTemplate.Node delete){
        Queue<TreeTemplate.Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeTemplate.Node temp = q.poll();
            if(temp==delete){
                temp=null;
                return;
            }
            if(temp.right!=null){
                if(temp.right == delete){
                    temp.right = null;
                    return;
                } else
                    q.add(temp.right);
            }
            if(temp.left!=null){
                if(temp.left == delete){
                    temp.left = null;
                    return;
                } else
                    q.add(temp.left);
            }
        }
    }
    public static TreeTemplate.Node deletionBT(TreeTemplate.Node root, int key){

        if(root==null){
            return null;
        }
        if(root.data == key && root.left==null && root.right==null){
            root=null;
            return null;
        }
        //Write your code here and return the root of the changed tree
        TreeTemplate.Node keyNode = null;
        TreeTemplate.Node temp=null;
        Queue<TreeTemplate.Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            temp = q.poll();
            if(temp.data ==key){
                keyNode = temp;
            }
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
        }
        if(keyNode!=null){
            int x = temp.data;
            deletion(root,temp);
            keyNode.data = x;
        }
        return root;
    }

    public static void main(String args[]){
        TreeTemplate tree = new TreeTemplate();
        tree.root = new TreeTemplate.Node(1);
        tree.root.left = new TreeTemplate.Node(4);
        tree.root.right = new TreeTemplate.Node(7);
        tree.root.left.left = new TreeTemplate.Node(5);
        tree.root.left.right = new TreeTemplate.Node(6);

        System.out.print(" :: Level Order Insertion :: \n");
        System.out.print("Before Deletion : ");
        inOrder(tree.root);

        tree.root = deletionBT(tree.root, 1);

        System.out.print("\nAfter Deletion : ");
        inOrder(tree.root);
    }
}
