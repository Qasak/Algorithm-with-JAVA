package NiceProblem.Week258;

public class Q3_两个回文子序列长度的最大乘积 {
    // 暴
    class Solution {
        int ans = 0;
        public int maxProduct(String s) {
            dfs(new StringBuilder(), new StringBuilder(), s, 0);
            return ans;
        }
        void dfs(StringBuilder s1, StringBuilder s2, String s, int idx) {
            if(check(s1.toString()) && check(s2.toString())) {
                ans = Math.max(ans, s1.length() * s2.length());
            }
            int n = s.length();
            if(idx == n) {
                return;
            }
            int len1 = s1.length(), len2 = s2.length();
            dfs(s1.append(s.charAt(idx)), s2, s, idx + 1);
            s1.setLength(len1);
            dfs(s1, s2.append(s.charAt(idx)), s, idx + 1);
            s2.setLength(len2);
            dfs(s1, s2, s, idx + 1);

        }

        boolean check(String s) {
            char[] cs = s.toCharArray();
            int l = 0, r = s.length() - 1;
            while(l < r) {
                if(cs[l] != cs[r]) {
                    return false;
                }
                l++; r--;
            }
            return  true;
        }
    }
}
