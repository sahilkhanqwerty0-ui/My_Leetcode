class Solution {
    public String decodeString(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<StringBuilder> strs = new Stack<>();

        StringBuilder curr = new StringBuilder();
        int num = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } 
            else if (c == '[') {
                nums.push(num);
                strs.push(curr);
                num = 0;
                curr = new StringBuilder();
            } 
            else if (c == ']') {
                StringBuilder temp = strs.pop();
                int k = nums.pop();

                while (k-- > 0)
                    temp.append(curr);

                curr = temp;
            } 
            else {
                curr.append(c);
            }
        }

        return curr.toString();
    }
}