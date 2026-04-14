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
        if(root==null){
            return 0;
        }
        int res =0;
        HashMap<TreeNode, Integer> hm =new HashMap<>();
        hm.put(root,Integer.MIN_VALUE);
        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        while(!s.isEmpty()){
            TreeNode node = s.pop();
            int rootMax = hm.get(node);
            int max = Math.max(rootMax,node.val);
            if(max==node.val){
                res++;
            }
            if(node.left!=null){
                s.push(node.left);
                hm.put(node.left,max);
            }
            if(node.right!=null){
                s.push(node.right);
                hm.put(node.right,max);
            }
        }
        return res;
    }
}
