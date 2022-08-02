/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "";
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        String ans = "";
        ans+=root.val+" ";
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(temp.left!=null){
                ans+=temp.left.val+" ";
                q.add(temp.left);
            }
            else {ans+="# ";}
            if(temp.right!=null){
                ans+=temp.right.val+" ";
                q.add(temp.right);
            }
            else {ans+="# ";}
        }
        return ans;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("") || data.length()==0)
            return null;
        String values[] = data.split("\\s");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        for(int i=1;i<values.length;i++){
            TreeNode parent = q.remove();
            if(!values[i].equals("#")){
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if(!values[++i].equals("#")){
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));