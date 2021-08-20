package Mitsuha.序列DP;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/20 18:18
 */
public class Q10_正则表达式 {
    // 本题关键是分析当出现 a* 这种字符时，是匹配 0 个 a、还是 1 个 a、还是 2 个 a ...
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        char[] cs = s.toCharArray(), cp = p.toCharArray();
        // 长度：好表达空串的情况
        // f[i][j] :s长度为i，p长度为j时，是否完全匹配
        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;
        // 空串可以匹配(x)*情况，所以从0开始
        for(int i = 0; i <= n; i++) {
            // 非空串匹配空匹配符都是false, 从1开始(第一个字符)
            // 保证每次出现字符 * 时，前面都匹配到有效的字符
            for(int j = 1; j <= m; j++) {
                if(i == 0) {
                    // 空串，只能忽略当前b*两个字符
                    if(cp[j - 1] == '*') {
                        f[i][j] = f[i][j - 2];
                    }
                    continue;
                }
                char a = cs[i - 1];
                char b = cp[j - 1];

                if(b == '*') {
                    char bb = cp[j - 2];
                    // b(*)前一个字符bb和a是否匹配
                    // 不匹配只能选择匹配0次
                    if(bb != a && bb != '.') {
                        f[i][j] = f[i][j - 2];
                        // 匹配：0次或多次a均可匹配bb*
                    } else {
                        f[i][j] = f[i][j - 2] || f[i - 1][j];
                    }
                } else {
                    if(b == a || b == '.')
                        f[i][j] = f[i - 1][j - 1];
                }
            }
        }
        return f[n][m];
    }
}
