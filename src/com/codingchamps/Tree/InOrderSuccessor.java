package com.codingchamps.Tree;

public class InOrderSuccessor {

    public static TreeTemplate.Node minValue(TreeTemplate.Node current){
        while(current.left!=null){
            current = current.left;
        }
        return current;
    }
    // returns the inorder successor of the Node x in BST (rooted at 'root')
    public static TreeTemplate.Node inorderSuccessor(TreeTemplate.Node root,TreeTemplate.Node n){
        if(n.right!=null){
            return minValue(n.right);
        }
        TreeTemplate.Node succ = null;
        while(root!=null){
            if(n.data < root.data){
                succ = root;
                root = root.left;
            }
            else if(n.data > root.data){
                root = root.right;
            }
            else
                break;
        }
        return succ;
    }

    public static void main(String args[]){
        TreeTemplate tree = new TreeTemplate();
        tree.root = new TreeTemplate.Node(7);
        tree.root.left = new TreeTemplate.Node(6);
        tree.root.right = new TreeTemplate.Node(9);
        tree.root.left.left = new TreeTemplate.Node(3);
        tree.root.right.left = new TreeTemplate.Node(8);
        tree.root.right.right = new TreeTemplate.Node(10);

        TreeTemplate.Node temp = tree.root.right;
        System.out.println("Inorder Successor of 9 is : " + inorderSuccessor(tree.root,temp).data);
    }
}
