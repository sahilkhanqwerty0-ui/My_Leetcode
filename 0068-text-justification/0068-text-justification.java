class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int j = i, len = 0;

            while (j < words.length && len + words[j].length() + (j - i) <= maxWidth) {
                len += words[j].length();
                j++;
            }

            int gaps = j - i - 1;
            StringBuilder sb = new StringBuilder();

            // Last line or single word
            if (j == words.length || gaps == 0) {
                for (int k = i; k < j; k++) {
                    if (k > i) sb.append(" ");
                    sb.append(words[k]);
                }
                while (sb.length() < maxWidth) sb.append(" ");
            } 
            else {
                int spaces = (maxWidth - len) / gaps;
                int extra = (maxWidth - len) % gaps;

                for (int k = i; k < j; k++) {
                    sb.append(words[k]);

                    if (k < j - 1) {
                        sb.append(" ".repeat(spaces + (k - i < extra ? 1 : 0)));
                    }
                }
            }

            ans.add(sb.toString());
            i = j;
        }

        return ans;
    }
}