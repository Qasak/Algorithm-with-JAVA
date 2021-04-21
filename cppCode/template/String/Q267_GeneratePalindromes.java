package leetcode.template.String;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/20 10:21
 */
public class Q267_GeneratePalindromes {
    // 我们可以考虑直接枚举回文排列，即枚举一个排列的前半部分，将它的前半部分翻转即可得到一个回文排列
    // aaaabbc -> [aabcbaa, abacaba, baacaab]
    // aab -> aab, aba, baa
    //        baa  aba  aab
    //        aabcbaa /  abacaba  /  baacaab
    int[] cnt;
    List<String> res;
    char single;
    public List<String> generatePalindromes(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        Arrays.sort(cs);
        cnt = new int[128];
        for(char c : cs) {
            cnt[c]++;
        }
        res = new ArrayList<>();
        if(!check(cs)) {
            return res;
        }
        char[] ch = new char[n / 2];
        // aaaabbc
        // aabc
        int idx = 0;
        single = 0;
        for(int i = 0; i < 128; i++) {
            if(cnt[i] % 2 == 1) {
                single = (char)i;
            }
            for(int j = 0; j < (cnt[i] + 1) / 2; j++) {
                ch[idx++] = (char)i;
            }

        }
        return res;
    }
    private void dfs(char[] ch, StringBuilder sb) {
        if(sb.length() == ch.length) {
            String tmp = sb.toString();
            if(single != 0) {
                tmp += String.valueOf(single);
            }
            tmp += sb.reverse().toString();
            res.add(tmp);
            return;
        }

    }
    private boolean check(char[] cs) {
        boolean flag = true;
        for(int i = 0; i < 128; i++) {
            // 奇数仅能出现一次
            if((cnt[i] & 1) == 1) {
                if(!flag) {
                    return false;
                }
                flag = false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Q267_GeneratePalindromes s = new Q267_GeneratePalindromes();
        String a = "aa";
        System.out.println(s.generatePalindromes(a));
        Map<Character, Integer> cnt = new HashMap<>();
        int[] b = new int[]{1,3,2};
        Arrays.sort(b, 1, 2);
    }
}
