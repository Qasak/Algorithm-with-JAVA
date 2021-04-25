package leetcode.HighFreq.old;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/10 18:38
 *
 *
 * 如果 version1 > version2 返回 1，
 * 如果 version1 < version2 返回 -1，
 * 除此之外返回 0。
 * 比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较 忽略任何前导零后的整数值 。
 * 也就是说，修订号 1 和修订号 001 相等
 *
 *
 * 输入：version1 = "1.01", version2 = "1.001"
 * 输出：0
 * 解释：忽略前导零，"01" 和 "001" 都表示相同的整数 "1"
 *
 * 输入：version1 = "1.0.1", version2 = "1"
 * 输出：1
 *
 * 输入：version1 = "7.5.2.4", version2 = "7.5.3"
 * 输出：-1
 *
 */
public class CompareVersion_165 {
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int n = Math.max(s1.length, s2.length);
        for(int i = 0; i < n; i++) {
            int a = i < s1.length ? Integer.parseInt(s1[i]) : 0;
            int b = i < s2.length ? Integer.parseInt(s2[i]) : 0;
            if(a < b) {
                return -1;
            } else if(a > b) {
                return 1;
            }
        }
        return 0;
    }
}
