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
    Integer prev = null;
    Boolean isValid = true;
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        inOrder(root);
        return isValid;
    }
    private void inOrder(TreeNode root){
        if(!isValid){
            return;
        }
        if(root.left!=null){
            inOrder(root.left);
        }
        if(prev!=null){
            if(root.val<=prev){
                isValid =false;
            }
        }
        prev= root.val;
        if(root.right!=null){
            inOrder(root.right);
        }
    }
}
