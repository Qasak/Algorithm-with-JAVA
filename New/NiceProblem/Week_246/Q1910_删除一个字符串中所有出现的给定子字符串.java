package leetcode.contest.Week_246;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/29 18:37
 */
public class Q1910_删除一个字符串中所有出现的给定子字符串 {
    // O(n^2+n*m)
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        int idx = sb.indexOf(part);
        while(idx != -1) {
            sb.replace(idx, idx + part.length(), "");
            idx = sb.indexOf(part);
        }
        return sb.toString();
    }
    // KMP

}
