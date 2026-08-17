class Solution:
    def validSequence(self, word1: str, word2: str) -> list[int]:
        n1, n2 = len(word1), len(word2)

        suf0 = [-1] * (n2 + 1)
        suf0[n2] = n1  # nothing left needed
        i, j = n1 - 1, n2 - 1
        while i >= 0 and j >= 0:
            if word1[i] == word2[j]:
                suf0[j] = i
                j -= 1
            i -= 1

        result = []
        i = 0
        used_mismatch = False
        for j in range(n2):
            placed = False
            while i < n1:
                if word1[i] == word2[j]:
                    result.append(i)
                    i += 1
                    placed = True
                    break
                elif not used_mismatch and suf0[j + 1] != -1 and i + 1 <= suf0[j + 1]:
                    result.append(i)
                    i += 1
                    used_mismatch = True
                    placed = True
                    break
                else:
                    i += 1  # skip, keep looking
            if not placed:
                return []
        return result