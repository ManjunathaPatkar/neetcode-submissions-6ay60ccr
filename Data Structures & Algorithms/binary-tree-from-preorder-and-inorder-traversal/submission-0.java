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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> inIndexMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inIndexMap.put(inorder[i],i);
        }
        return helper(preorder,inorder,0,0,inorder.length-1,inIndexMap);
    }
    private TreeNode helper(
        int[] preorder, int[] inorder,
        int preStart, int inStart, int inEnd, HashMap<Integer,Integer> inIndexMap){
            if(preStart<0 || preStart>preorder.length-1 || inStart> inEnd){
                return null;
            }
            TreeNode root = new TreeNode(preorder[preStart]);
            int inIndex = inIndexMap.get(preorder[preStart]);
            root.left = helper(preorder, inorder, preStart+1, inStart, inIndex-1, inIndexMap);
            root.right= helper(preorder, inorder, preStart+inIndex-inStart+1, inIndex+1, inEnd, inIndexMap);
            return root;
        }

}
