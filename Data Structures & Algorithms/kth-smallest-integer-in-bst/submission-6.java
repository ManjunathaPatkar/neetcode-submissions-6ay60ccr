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
    Integer count =0;
    Integer val = null;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root,k);
        return val;
    }
     private void inOrder(TreeNode root, int k){
        if(count==k){
            return;
        }
        if(root.left!=null){
            inOrder(root.left,k);
        }
        count++;
        if(count==k){
            val = root.val;
        }
        if(root.right!=null){
            inOrder(root.right,k);
        }
    }
}
