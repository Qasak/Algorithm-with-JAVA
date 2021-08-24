package leetcode.template.Probability;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/29 10:55
 */
public class 切三角形 {
    public static void main(String[] args) {
        Random rand = new Random();
        int cnt = 0;
        for(int i = 0; i < 10000; i++) {
            double[] t = new double[3];
            double L = 10;
            t[0] = L * rand.nextDouble();
            t[1] = L * rand.nextDouble();
            while (t[0] + t[1] > L) {
                t[0] = L * rand.nextDouble();
                t[1] = L * rand.nextDouble();
            }
            t[2] = L - t[1] - t[0];
            Arrays.sort(t);
//            System.out.println(t[0] + " " + t[1] + " " + t[2] + " " + (t[0] + t[1] + t[2]));
            if(t[0] + t[1] > t[2]) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
