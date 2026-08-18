from collections import Counter

class Solution:
    def largestInteger(self, nums: list[int], k: int) -> int:
        n = len(nums)
        cnt = Counter(nums)

        if k == n:
            return max(nums)

        if k == 1:
            candidates = [v for v, c in cnt.items() if c == 1]
            return max(candidates) if candidates else -1

        best = -1
        if cnt[nums[0]] == 1:
            best = max(best, nums[0])
        if cnt[nums[-1]] == 1:
            best = max(best, nums[-1])
        return best