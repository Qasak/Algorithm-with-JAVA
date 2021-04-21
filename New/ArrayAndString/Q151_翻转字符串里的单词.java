package leetcode.SpringRecruit.ArrayAndString;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/27 10:08
 */
public class Q151_翻转字符串里的单词 {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder ans = new StringBuilder();
        for(String ss : s.split(" +")) {
            ans.insert(0, ss + " ");
        }
        ans.setLength(ans.length() - 1);
        return ans.toString();
    }
    public String reverseWords1(String s) {
        String[] t = s.trim().split(" +");
        Collections.reverse(Arrays.asList(t));
        return String.join(" ", Arrays.asList(t));
    }
    public static void main(String[] args) {
        String s = " a aavv ";
        s = s.trim();
        System.out.println(s);
    }
}
