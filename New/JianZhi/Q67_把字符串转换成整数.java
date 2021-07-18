package leetcode.JianZhi;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/18 8:12
 */
public class Q67_把字符串转换成整数 {
    public int strToInt(String str) {
        String s = str.trim();
        s = s.split(" ")[0];
        char[] cs = s.toCharArray();
        int i = 0, n = cs.length;
        long ans = 0;
        if(n == 0) {
            return 0;
        }
        boolean isNeg = (cs[0] == '-') ;
        int neg = 1;
        if(isNeg) {
            i++;
            neg = -1;
        }
        if(cs[0] == '+') {
            i++;
        }
        while(i < n) {
            if(!Character.isDigit(cs[i]) ) {
                return (int) (neg * ans);
            }
            ans *= 10;
            ans += (int) (cs[i++] - '0');
            if((isNeg && ans >= 2147483648L) || (!isNeg && ans >= 2147483647L)) {
                return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

        }
        return (int) (neg * ans);
    }
    public static void main(String[] args) {
        String a = " 1 ";
    }
}
