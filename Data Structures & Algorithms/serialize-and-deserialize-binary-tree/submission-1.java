/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {
    StringBuilder sb;
    int i=0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        sb = new StringBuilder();
        preorder(root);
        sb.setLength(sb.length()-1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    // 1,2,null,null,3,4,null,null,5,null,null,
    public TreeNode deserialize(String data) {
        String[] s = data.split(",");
        i=0;
        return helper(s);
    }

    private TreeNode helper(String[] s){
        if(i>=s.length){
            return null;
        }
        if(s[i].equals("null")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s[i]));
        i++;
        root.left = helper(s);
        i++;
        root.right = helper(s);
        return root;
    }
    private void preorder(TreeNode root){
        if(root==null){
            sb.append("null");
            sb.append(",");
            return;
        }
        sb.append(root.val);
        sb.append(",");
        preorder(root.left);
        preorder(root.right);
    }
}
