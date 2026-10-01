import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        backtrack(s, 0, 0, "", ans);
        return ans;
    }

    void backtrack(String s, int idx, int parts, String ip, List<String> ans) {
        if (parts == 4) {
            if (idx == s.length())
                ans.add(ip.substring(0, ip.length() - 1));
            return;
        }

        for (int len = 1; len <= 3 && idx + len <= s.length(); len++) {
            String part = s.substring(idx, idx + len);

            if (part.length() > 1 && part.charAt(0) == '0')
                continue;

            int num = Integer.parseInt(part);
            if (num > 255)
                continue;

            backtrack(s, idx + len, parts + 1, ip + part + ".", ans);
        }
    }
}