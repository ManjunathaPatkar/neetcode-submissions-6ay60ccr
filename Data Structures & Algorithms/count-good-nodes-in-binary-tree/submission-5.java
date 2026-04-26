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
    public int goodNodes(TreeNode root) {
        int[] count = new  int[1];
        helper(root, Integer.MIN_VALUE, count);
        return count[0];
    }

    public void helper(TreeNode node, int max, int[] count){
        if(node == null){
            return;
        }

        if(node.val >= max){
            max = node.val;
            count[0]++;
        }

        helper(node.left, max, count);
        helper(node.right, max, count);
    }
}