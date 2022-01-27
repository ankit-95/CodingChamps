package com.codingchamps.Tree;

public class FloorCeilInBST {
    Node root;
    public static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }
    FloorCeilInBST(){
        root = null;
    }

    public Node insert(Node root, int key){
        if(root==null)
            return new Node(key);
        else if(key < root.data){
            root.left = insert(root.left,key);
        }
        else
            root.right = insert(root.right,key);
        return root;
    }

    public boolean search(Node root,int key){
        if(root==null)
            return false;
        Node temp = root;
        while(temp!=null){
            if(temp.data == key)
                return true;
            else if(key < temp.data){
                temp = temp.left;
            }
            else
                temp = temp.right;
        }
        return false;
    }


    public int floor(Node root, int key){
        Node res = null;
        Node temp = root;
        while(temp!=null){
            if(temp.data == key)
                return temp.data;
            else if(temp.data > key){
                temp = temp.left;
            }
            else{
                res = temp;
                temp = temp.right;
            }
        }
        return res.data;
    }


    public int ceil(Node root, int key){
        Node res = null;
        Node temp = root;
        while(temp!=null){
            if(temp.data == key)
                return temp.data;
            else if(temp.data < key){
                temp = temp.right;
            }
            else{
                res = temp;
                temp = temp.left;
            }
        }
        return res.data;
    }

    public boolean searchRec(Node root, int key){
        if(root==null)
            return false;
        if(root!=null && root.data == key)
            return true;
        if(root!=null && key<root.data){
            return searchRec(root.left,key);
        }
        return searchRec(root.right,key);
    }
    public void inOrder(Node root){
        if(root==null)
            return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public static void main(String args[]){
        FloorCeilInBST t = new FloorCeilInBST();
        t.root = t.insert(t.root,7);
        t.root =  t.insert(t.root,5);
        t.root =  t.insert(t.root,10);
        t.root =  t.insert(t.root,9);
        t.root =  t.insert(t.root,12);
        t.root =  t.insert(t.root,6);
        t.root =  t.insert(t.root,4);


        //  t.inOrder(t.root);

        System.out.print("Floor of BST : "+ t.floor(t.root,11));
        System.out.print("\nCeil of BST : "+t.ceil(t.root,8));
    }
}
