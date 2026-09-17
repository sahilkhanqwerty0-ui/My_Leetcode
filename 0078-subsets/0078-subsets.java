import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    void backtrack(int i, int[] nums, List<Integer> curr, List<List<Integer>> ans) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        // Take
        curr.add(nums[i]);
        backtrack(i + 1, nums, curr, ans);

        // Don't take
        curr.remove(curr.size() - 1);
        backtrack(i + 1, nums, curr, ans);
    }
}