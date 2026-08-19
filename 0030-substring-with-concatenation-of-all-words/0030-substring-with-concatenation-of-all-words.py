from collections import Counter

class Solution:
    def findSubstring(self, s: str, words: list[str]) -> list[int]:
        if not s or not words:
            return []

        word_len = len(words[0])
        num_words = len(words)
        window_len = word_len * num_words
        n = len(s)
        if n < window_len:
            return []

        target = Counter(words)
        result = []

        for offset in range(word_len):
            left = offset
            count = 0
            window = Counter()

            for right in range(offset, n - word_len + 1, word_len):
                word = s[right:right + word_len]

                if word in target:
                    window[word] += 1
                    count += 1

                    # too many copies of this word -> shrink from the left
                    while window[word] > target[word]:
                        left_word = s[left:left + word_len]
                        window[left_word] -= 1
                        left += word_len
                        count -= 1

                    if count == num_words:
                        result.append(left)
                        # slide window by one word to look for the next match
                        left_word = s[left:left + word_len]
                        window[left_word] -= 1
                        left += word_len
                        count -= 1
                else:
                    # word not in target at all -> reset window entirely
                    window.clear()
                    count = 0
                    left = right + word_len

        return result