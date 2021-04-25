package leetcode.SpringRecruit.ArrayAndString;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/21 13:54
 */
public class Q415_字符串相加 {
    public String addStrings(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        int t = 0;
        StringBuilder ans = new StringBuilder();
        int i = n - 1, j = m - 1;
        for(; i >= 0 && j >= 0; i--, j--) {
            int a = c1[i] - '0' + c2[j] - '0' + t;
            ans.insert(0, String.valueOf(a % 10));
            t = a / 10;
        }
        while(i >= 0) {
            int a = c1[i] - '0' + t;
            ans.insert(0, String.valueOf(a % 10));
            t = a / 10;
            i--;
        }
        while(j >= 0) {
            int a = c2[j] - '0' + t;
            ans.insert(0, String.valueOf(a % 10));
            t = a / 10;
            j--;
        }
        if(t > 0) {
            ans.insert(0, String.valueOf(t));
        }
        return ans.toString();
    }
}
