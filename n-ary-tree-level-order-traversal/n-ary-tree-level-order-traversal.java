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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null)
            return ans;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            while(size-->0){
                Node top = q.remove();
                list.add(top.val);
                for(Node child : top.children){
                    q.add(child);
                }
            }
            ans.add(new ArrayList<>(list));
        }
        return ans;
    }
}