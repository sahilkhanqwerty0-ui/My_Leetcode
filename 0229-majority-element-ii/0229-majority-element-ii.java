class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int a = 0, b = 1, x = 0, y = 0;

        for (int n : nums) {
            if (n == a) x++;
            else if (n == b) y++;
            else if (x == 0) { a = n; x = 1; }
            else if (y == 0) { b = n; y = 1; }
            else { x--; y--; }
        }

        x = y = 0;
        for (int n : nums) {
            if (n == a) x++;
            else if (n == b) y++;
        }

        List<Integer> ans = new ArrayList<>();
        if (x > nums.length / 3) ans.add(a);
        if (y > nums.length / 3) ans.add(b);
        return ans;
    }
}