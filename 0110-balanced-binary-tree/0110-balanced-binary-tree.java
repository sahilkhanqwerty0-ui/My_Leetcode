class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    int height(TreeNode n) {
        if (n == null) return 0;
        int l = height(n.left), r = height(n.right);
        if (l == -1 || r == -1 || Math.abs(l-r) > 1) return -1;
        return 1 + Math.max(l, r);
    }
}