class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return ans;
    }

    void dfs(TreeNode root, String path) {
        if (root == null) return;

        path += root.val;

        if (root.left == null && root.right == null) {
            ans.add(path);
            return;
        }

        path += "->";
        dfs(root.left, path);
        dfs(root.right, path);
    }
}