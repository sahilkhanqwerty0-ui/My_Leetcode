class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        
        // Array to store the minimum value from index i to n - 1
        int[] suffMin = new int[n];
        suffMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffMin[i] = Math.min(nums[i], suffMin[i + 1]);
        }
        
        int prefMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            // Track the maximum value from index 0 to i
            prefMax = Math.max(prefMax, nums[i]);
            
            // Instability score: max(nums[0..i]) - min(nums[i..n-1])
            int instabilityScore = prefMax - suffMin[i];
            
            if (instabilityScore <= k) {
                return i;
            }
        }
        
        return -1;
    }
}