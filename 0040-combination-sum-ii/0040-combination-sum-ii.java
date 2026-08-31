import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), ans);

        return ans;
    }

    void backtrack(int[] a, int target, int start,
                   List<Integer> path, List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < a.length; i++) {

            if (i > start && a[i] == a[i - 1])
                continue;

            if (a[i] > target)
                break;

            path.add(a[i]);

            backtrack(a, target - a[i], i + 1, path, ans);

            path.remove(path.size() - 1);
        }
    }
}