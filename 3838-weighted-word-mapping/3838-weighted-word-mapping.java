class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder ans = new StringBuilder();

        for (String word : words) {
            int sum = 0;

            for (int i = 0; i < word.length(); i++)
                sum = (sum + weights[word.charAt(i) - 'a']) % 26;

            ans.append((char)('a' + 25 - sum));
        }

        return ans.toString();
    }
}