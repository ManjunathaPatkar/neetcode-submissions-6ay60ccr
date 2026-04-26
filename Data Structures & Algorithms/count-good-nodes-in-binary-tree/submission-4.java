class Solution {
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;

        int count = 0;
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, root.val));

        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            TreeNode node = p.node;
            int maxSoFar = p.max;

            if (node.val >= maxSoFar) {
                count++;
            }

            int newMax = Math.max(maxSoFar, node.val);

            if (node.right != null) {
                stack.push(new Pair(node.right, newMax));
            }
            if (node.left != null) {
                stack.push(new Pair(node.left, newMax));
            }
        }

        return count;
    }

    static class Pair {
        TreeNode node;
        int max;
        Pair(TreeNode n, int m) {
            node = n;
            max = m;
        }
    }
}