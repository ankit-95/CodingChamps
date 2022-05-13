/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    
    public void helper(Node root,List<Integer> list){
        if(root==null)
            return;
        list.add(root.val);
        for(Node child : root.children){
            helper(child,list);
        }
    }
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        helper(root,list);
        return list;
    }
}