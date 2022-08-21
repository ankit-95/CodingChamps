/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    
    Node first = null;
    Node last = null;
    
    public void helper(Node root){
        if(root!=null){
            helper(root.left);
            if(last!=null){
                last.right = root;
                root.left = last;
            } else {
                first = root;
            }
            last = root;
            helper(root.right); 
        }
    }
    public Node treeToDoublyList(Node root) {
        if(root==null)
            return root;
        helper(root);
        last.right = first;
        first.left = last;
        return first;
    }
}