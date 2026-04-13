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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
       Queue<TreeNode> q=new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode p=q.poll();
            if(isSame(p,subRoot)){
                return true;
            }
            if(p.left!=null){
                q.offer(p.left);
            }
            if(p.right!=null){
                q.offer(p.right);
            }
        }
        return false;
    }
      public boolean isSame(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        return isSame(p.right,q.right) && isSame(p.left,q.left);
    }
}
