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

class Solution {
    boolean bal = true;
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        helper(root);
        return bal;
    }

    public int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftHeight = helper(root.left);
        int rightHeight = helper(root.right);
        if(Math.abs(leftHeight-rightHeight)>1){
            bal = false;
        }
        return Math.max(leftHeight,rightHeight)+1;
    }
}
