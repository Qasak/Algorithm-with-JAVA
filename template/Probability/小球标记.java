package leetcode.template.Probability;

import java.util.Random;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/29 12:09
 */
public class 小球标记 {
    public static void main(String[] args) {
        int n = 10000;
        Random rand = new Random();
        boolean[] balls = new boolean[n];
        for(int i = 0; i < n; i++) {
            balls[rand.nextInt(n)] = true;
        }
        int cnt = 0;
        for(boolean f : balls) {
            if(f) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
