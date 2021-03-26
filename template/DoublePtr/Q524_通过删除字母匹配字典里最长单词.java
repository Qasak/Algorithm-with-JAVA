package leetcode.template.DoublePtr;

import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/19 15:56
 */
public class Q524_通过删除字母匹配字典里最长单词 {
    // 1. 双指针
    public String findLongestWord(String s, List<String> dictionary) {
        int n = s.length();
        String ans = "";
        for(String word : dictionary) {
            int i = 0, j = 0;
            char[] cs = s.toCharArray();
            char[] ct = word.toCharArray();
            int m = ct.length;
            while(i < n && j < m) {
                if(cs[i] == ct[j]) {
                    i++; j++;
                } else {
                    i++;
                }
            }
            if(j == m) {
                if(word.length() > ans.length() ||
                        (word.length() == ans.length() && word.compareTo(ans) < 0)) {
                    ans = word;
                }
            }
        }
        return ans;
    }
}
