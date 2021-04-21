package leetcode.template.Simulation;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/22 10:56
 */
public class Q43_StringMultiply {
    public String multiply(String num1, String num2) {
        char[] A = num1.toCharArray();
        char[] B = num2.toCharArray();
        int n = A.length;
        int m = B.length;
        String sum = "";
        for(int i = m - 1; i >= 0; i--) {
            // 进位
            int t = 0;
            StringBuilder cur = new StringBuilder();
            for(int j = n - 1; j >= 0; j--) {
                int b = B[i] - '0';
                int a = A[j] - '0';
                int mul = a * b + t;
                cur.append((char)(mul % 10 + '0'));
                t = mul / 10;
            }
            if(t > 0) {
                cur.append((char)(t + '0'));
            }
            cur.reverse();
            for(int j = 0; j < (m - 1 - i); j++) {
                cur.append('0');
            }
            sum = addStrings(sum, cur.toString());
        }
        return sum.charAt(0) == '0' ? "0" : sum;
    }
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

    // 2. 乘法性质：m 位数 * n 位数 = (m + n) 位数 或 (m + n - 1) 位数
    public String multiply2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        int[] ansArr = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                ansArr[i + j + 1] += x * y;
            }
        }
        for (int i = m + n - 1; i > 0; i--) {
            ansArr[i - 1] += ansArr[i] / 10;
            ansArr[i] %= 10;
        }
        StringBuilder ans = new StringBuilder();
        int idx = ansArr[0] == 0 ? 1 : 0;
        for(; idx < n + m; idx++) {
            ans.append((char) (ansArr[idx] + '0'));
        }
        return ans.toString();
    }
}
