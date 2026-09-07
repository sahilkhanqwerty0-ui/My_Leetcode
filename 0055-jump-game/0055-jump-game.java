class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // If the current index is beyond the maximum reachable index, return false
            if (i > maxReach) {
                return false;
            }
            
            // Update the furthest index reachable
            maxReach = Math.max(maxReach, i + nums[i]);
            
            // If we can already reach or pass the last index, return true early
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        
        return true;
    }
}