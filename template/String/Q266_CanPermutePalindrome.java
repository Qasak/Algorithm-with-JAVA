package leetcode.template.String;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/20 10:15
 */
public class Q266_CanPermutePalindrome {
    public boolean canPermutePalindrome(String s) {
        // aaabbb
        // abbbaa
        // bab
        char[] cs = s.toCharArray();
        int[] cnt = new int[128];
        for(char c : cs) {
            cnt[c]++;
        }
        boolean flag = true;
        for(int i: cnt) {
            if((i & 1) == 1) {
                if(!flag) {
                    return false;
                }
                flag = false;
            }
        }
        return true;
    }
}
