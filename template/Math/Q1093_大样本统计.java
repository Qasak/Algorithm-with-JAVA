package leetcode.template.Math;

import java.util.Scanner;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/19 18:11
 */
public class Q1093_大样本统计 {
    public double[] sampleStats(int[] count) {
        double[] ans = new double[5];
        for(int i = 0; i < 256; i++) {
            if(count[i] != 0) {
                ans[0] = i;
                break;
            }
        }
        for(int i = 255; i >= 0; i--) {
            if(count[i] != 0) {
                ans[1] = i;
                break;
            }
        }
        double sum = 0;
        int n = 0;
        int max = 0;
        int most = 0;
        for(int i = 0; i < 256; i++) {
            if(count[i] > max) {
                max = count[i];
                most = i;
            }
            sum += (double) i * count[i];
            if(count[i] > 0) {
                n += count[i];
            }
        }
        ans[2] = sum / n;

        ans[4] = most;
        int a = n / 2 + 1;
        int b = (n - 1) / 2 + 1;
        double c = -1;
        double d = -1;
        for(int i = 0; i < 256; i++) {
            if(count[i] > 0) {
                if(c != -1 && d != -1) {
                    break;
                }
                if(a > count[i]) {
                    a -= count[i];
                } else {
                    if(a == count[i]) {
                        a -= count[i];
                    }
                    if(c == -1) {
                        c = i;
                    }
                }
                if(b > count[i]) {
                    b -= count[i];
                } else {
                    if(b == count[i]) {
                        b -= count[i];
                    }
                    if(d == -1) {
                        d = i;
                    }
                }
            }
        }
        ans[3] = (c + d) / 2;
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 0;
        int b = 0;
        while(sc.hasNext()) {
            a = sc.nextInt();
            b = sc.nextInt();
            System.out.println(a + " " + b);
        }



    }
}
