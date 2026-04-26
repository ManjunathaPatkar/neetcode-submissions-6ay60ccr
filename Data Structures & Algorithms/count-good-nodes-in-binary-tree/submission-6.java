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
    int count;
    public int goodNodes(TreeNode root) {
        count = 0;
        helper(root, Integer.MIN_VALUE);
        return count;
    }

    public void helper(TreeNode node, int max){
        if(node == null){
            return;
        }

        if(node.val >= max){
            max = node.val;
            count++;
        }

        helper(node.left, max);
        helper(node.right, max);
    }
}