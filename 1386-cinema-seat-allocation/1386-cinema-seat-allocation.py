from collections import defaultdict

class Solution:
    def maxNumberOfFamilies(self, n: int, reservedSeats: list[list[int]]) -> int:
        rows = defaultdict(set)
        for r, s in reservedSeats:
            if 2 <= s <= 9:
                rows[r].add(s)

        total = (n - len(rows)) * 2  # untouched rows get 2 groups each

        for seats in rows.values():
            left  = not (seats & {2, 3, 4, 5})
            mid   = not (seats & {4, 5, 6, 7})
            right = not (seats & {6, 7, 8, 9})
            if left and right:
                total += 2
            elif left or mid or right:
                total += 1

        return total