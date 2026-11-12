class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);

        List<Integer> ans = new ArrayList<>();

        for (int sum : map.keySet())
            if (map.get(sum) == max)
                ans.add(sum);

        return ans.stream().mapToInt(i -> i).toArray();
    }

    int dfs(TreeNode root) {
        if (root == null) return 0;

        int sum = root.val + dfs(root.left) + dfs(root.right);

        int freq = map.merge(sum, 1, Integer::sum);
        max = Math.max(max, freq);

        return sum;
    }
}