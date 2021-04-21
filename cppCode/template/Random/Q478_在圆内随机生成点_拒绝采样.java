package leetcode.template.Random;

import java.util.Random;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/10 21:36
 */
public class Q478_在圆内随机生成点_拒绝采样 {
    double r;
    double x;
    double y;

    public double[] randPoint() {
        double[] ans = new double[2];
        double a = (2 * Math.random() - 1) * r + x;
        double b = (2 * Math.random() - 1) * r + y;
        while(true) {
            if((a - x) * (a - x) + (b - y) * (b - y) <= r * r) {
                break;
            } else {
                a = (2 * Math.random() - 1) * r + x;
                b = (2 * Math.random() - 1) * r + y;
            }
        }
        ans[0] = a;
        ans[1] = b;
        return ans;
    }
    public static void main(String[] args) {
        Random rand = new Random();
        for(int i = 0; i < 10; i++) {
            System.out.println(rand.nextDouble());
        }
        System.out.println(Math.random());
    }
}
