from bisect import bisect_right

class Solution:
    def stoneGameV(self, stoneValue: list[int]) -> int:
        n = len(stoneValue)
        if n == 1:
            return 0

        prefix = [0] * (n + 1)
        for i in range(n):
            prefix[i + 1] = prefix[i] + stoneValue[i]
        dprefix = [2 * x for x in prefix]

        dp  = [[0] * n for _ in range(n)]
        mxL = [[0] * n for _ in range(n)]  # mxL[i][j] = max over p in [i,j] of dp[i][p] + sum(i,p)
        mxR = [[0] * n for _ in range(n)]  # mxR[i][j] = max over q in [i,j] of dp[q][j] + sum(q,j)

        for i in range(n):
            mxL[i][i] = stoneValue[i]
            mxR[i][i] = stoneValue[i]

        for length in range(2, n + 1):
            for i in range(n - length + 1):
                j = i + length - 1
                T = prefix[j + 1] - prefix[i]
                target = 2 * prefix[i] + T
                # largest m in [i+1, j] with 2*prefix[m] <= target
                idx = bisect_right(dprefix, target, i + 1, j + 1) - 1

                best = 0
                if idx >= i + 1:
                    p = idx - 1  # split point: left = sum(i,p) is the largest left <= T/2
                    if p >= i:
                        best = max(best, mxL[i][p])
                    left_p = prefix[p + 1] - prefix[i]
                    if 2 * left_p == T:          # exact tie: Alice picks either side
                        best = max(best, left_p + max(dp[i][p], dp[p + 1][j]))
                    if p + 2 <= j:
                        best = max(best, mxR[p + 2][j])
                else:
                    # even the smallest left part already exceeds half -> right side always kept
                    best = max(best, mxR[i + 1][j])

                dp[i][j] = best
                mxL[i][j] = max(mxL[i][j - 1], dp[i][j] + T)
                mxR[i][j] = max(mxR[i + 1][j], dp[i][j] + T)

        return dp[0][n - 1]