package leetcode.template.Simulation;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/22 10:57
 */
public class Q415_StringAdd {
    public String addStrings(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        char[] A = num1.toCharArray();
        char[] B = num2.toCharArray();
        int i = n - 1;
        int j = m - 1;
        int t = 0;
        StringBuilder sb = new StringBuilder();
        for(; i >= 0 || j >= 0; i--, j--) {
            int sum = t;
            if(i >= 0) {
                sum += A[i] - '0';
            }
            if(j >= 0) {
                sum += B[j] - '0';
            }
            sb.append(sum % 10);
            t = sum / 10;
        }
        if(t > 0) {
            sb.append(t);
        }
        return sb.reverse().toString();
    }
}
