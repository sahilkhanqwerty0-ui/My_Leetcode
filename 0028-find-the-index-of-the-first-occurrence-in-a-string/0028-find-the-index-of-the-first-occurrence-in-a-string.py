class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if not needle:
            return 0
        # build the KMP failure/prefix table for needle
        lps = [0] * len(needle)
        k = 0
        for i in range(1, len(needle)):
            while k > 0 and needle[i] != needle[k]:
                k = lps[k - 1]
            if needle[i] == needle[k]:
                k += 1
            lps[i] = k

        # search
        k = 0
        for i in range(len(haystack)):
            while k > 0 and haystack[i] != needle[k]:
                k = lps[k - 1]
            if haystack[i] == needle[k]:
                k += 1
            if k == len(needle):
                return i - len(needle) + 1
        return -1