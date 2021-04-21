package leetcode.template.String;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/19 19:02
 */
public class Q680_IsPalindromeII {
    public boolean validPalindrome(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        boolean flag = true;
        boolean a = true, b = true;
        // 删左边
        int l = 0, r = n - 1;
        while(l < r) {
            if(cs[l] != cs[r]) {
                if(flag) {
                    flag = false;
                    l++;
                    continue;
                } else {
                    a = false;
                    break;
                }
            }
            l++; r--;
        }
        flag = true;
        l = 0; r = n - 1;
        while(l < r) {
            if(cs[l] != cs[r]) {
                if(flag) {
                    flag = false;
                    r--;
                    continue;
                } else {
                    b = false;
                    break;
                }
            }
            l++; r--;

        }
        return a || b;
    }

    // 方法2
    public boolean validPalindrome1(String s) {
        char[] ch = s.toCharArray();
        int i = 0;
        int j = ch.length - 1;
        while(i < j){
            if(ch[i] == ch[j]){
                i++;
                j--;
            }else{
                return isValid(ch, i, j - 1) || isValid(ch, i + 1, j);//左跨一个或者右跨一个
            }
        }
        return true;
    }

    public boolean isValid(char[] ch, int i, int j){
        while(i < j){
            if(ch[i] == ch[j]){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
}
