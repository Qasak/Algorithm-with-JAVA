package leetcode.template.Math;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/9 21:17
 */
public class Q166_FractionToDecimal {

    public static String fractionToDecimal(int a, int b) {
        StringBuilder ans = new StringBuilder();
        // 存余数
        Map<Long, Integer> map = new HashMap<>();
        boolean flag = false;
        long x = a  ;
        long y = b  ;
        int cnt = 0;
        while(x % y != 0) {

            long s = x / y;
            if(s < 0) {
                s = -s;
            }
            ans.append(s);
            if(!flag) {
                ans.append(".");
                flag = true;
            }
            long m = x % y;
            if(map.containsKey(m)) {
                int idx = map.get(m) + ans.indexOf(".");
                ans.insert(idx + 1, "(");
                ans.append(")");
                if((a < 0 && b > 0) || (a > 0 && b < 0)) {
                    return "-" + ans.toString();
                }
                return ans.toString();
            } else {
                map.put(m, cnt);
            }
            x = 10 * m;
        }
        long s = x / y;
        if(s < 0) {
            s = -s;
        }

        ans.append((s));
        if((a < 0 && b > 0) || (a > 0 && b < 0)) {
            return "-" + ans.toString();
        }
        return ans.toString();
    }


    public String fractionToDecimal1(int a, int b) {
        if (a == 0) {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        // If either one is negative (not both)
        if (a < 0 ^ b < 0) {
            ans.append("-");
        }
        // Convert to Long or else abs(-2147483648) overflows
        long x = Math.abs(Long.valueOf(a));
        long y = Math.abs(Long.valueOf(b));
        ans.append(String.valueOf(x / y));
        long m = x % y;
        if (m == 0) {
            return ans.toString();
        }
        ans.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (m != 0) {
            if (map.containsKey(m)) {
                ans.insert(map.get(m), "(");
                ans.append(")");
                break;
            }
            map.put(m, ans.length());
            m *= 10;
            ans.append(String.valueOf(m / y));
            m %= y;
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1, 90));
    }
}
