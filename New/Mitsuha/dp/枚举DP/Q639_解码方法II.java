class Solution {
    int mod = (int)1e9+7;
    public int numDecodings(String s) {
        int n = s.length();
        long[] f = new long[3];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);
            int t = c - '0';
            long cnt = 0;
            int p1 = (i - 1) % 3, p2 = (i - 2) % 3;
            // 枚举组成什么 item（A -> 1; B -> 2 ...）
            for (int item = 1; item <= 26; item++) { 
                if (item < 10) { // 该 item 由一个字符组成
                    if (c == '*' || t == item) cnt += f[p1];
                } else { // 该 item 由两个字符组成
                    if (i - 2 < 0) break;
                    char prev = s.charAt(i - 2);
                    int u = prev - '0';
                    int a = item / 10, b = item % 10;
                    if ((prev == '*' || u == a) && (t == b || (c == '*' && b != 0))) cnt += f[p2];
                }
            }
            f[i % 3] = cnt % mod;
        }
        return (int)(f[n % 3]);
    }
}