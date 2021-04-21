package leetcode.template.Probability;

import java.util.Random;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/29 10:55
 */
public class 硬币_正正反 {
    public static void main(String[] args) {
        String a = "110";
        String b = "100";
        int cnt = 0;
        int cnt1 = 0;
        Random rand = new Random();
        char[] t = new char[]{'0', '1'};
        for(int i = 0; i < 10000; i++) {
            StringBuilder ans = new StringBuilder();
            while (true) {
                if(ans.length() > 3) {
                    ans.deleteCharAt(0);
                }
                if(ans.toString().equals(a)) {
                    cnt++;
                    break;
                }
                if(ans.toString().equals(b)) {
                    cnt1++;
                    break;
                }
                ans.append(t[rand.nextInt(2)]);
            }
        }
        System.out.println((double) cnt / (double)(cnt1 + cnt));
    }
}
