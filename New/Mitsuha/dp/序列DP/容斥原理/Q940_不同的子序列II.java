class Solution {
    public int distinctSubseqII(String s) {
        int mod = (int) 1e9 + 7;
        int[] f = new int[26];
        char[] cs = s.toCharArray();
        int n = s.length();
        for(int i = 0; i < n; i++) {
            int ch = cs[i] - 'a';
            int cur = 1;
            for(int j = 0; j < 26; j++) {
                cur = (cur + f[j]) % mod;
            }
            f[ch] = cur;
        }
        int ans = 0;
        for(int t : f) {
            ans = (ans + t) % mod;
        }
        return ans;
    }
}