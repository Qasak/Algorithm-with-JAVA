package leetcode.template.Probability;

import java.util.Random;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/29 12:13
 */
public class 公交车 {
    public static void main(String[] args) {
        int n = 1000000;
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            Random rand = new Random();
            double a = rand.nextDouble() * 30;
            double b = rand.nextDouble() * 20 + 10;
            if(a + b <= 30) {
                cnt++;
            }
        }
        System.out.println( cnt);
    }
}
