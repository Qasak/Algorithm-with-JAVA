package leetcode.template.Window;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/4 0:09
 */
public class Q644_FindMaxAverageII {
    // 1. 暴力
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double ans = Integer.MIN_VALUE;
        double sum;
        for(int len = k; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                sum = 0;
                for(int j = i; j <= i + len - 1; j++) {
                    sum += nums[j];
                }
                if(sum / len > ans) {
                    ans = sum / len;
                }
            }
        }
        return ans;
    }
    // 2. 前缀和 一次优化
    public double findMaxAverage1(int[] nums, int k) {
        int n = nums.length;
        double ans = Integer.MIN_VALUE;
        double sum ;
        int[] pre = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            pre[i] = nums[i - 1] + pre[i - 1];
        }
        // n - k + 1
        for(int len = k; len <= n; len++) {
            // sum of [i, j]
            for (int i = 0; i + len - 1 < n; i++) {
                sum = pre[i + len] - pre[i];
                if(sum / len > ans) {
                    ans = sum / len;
                }
            }
        }
        return ans;
    }
    // 而由于平均值和前缀和  (pre_sum)、区间长度两个变量有关，不具有单调性，必须去掉一个变量的影响。

    public static void main(String[] args) {
        BigInteger d = new BigInteger("601855739b6bc77ea235dc5c", 16);
        BigInteger e = new BigInteger("6018558a9b6bc77ea235dc96", 16);
        BigInteger f = new BigInteger("601837f89b6bc77ea23575fc", 16);
        BigInteger a = new BigInteger("601854fd9b6bc77ea235d98e", 16);
        BigInteger b = new BigInteger("601855449b6bc77ea235db28", 16);
        BigInteger c = new BigInteger("6018555c9b6bc77ea235dbda", 16);


        System.out.println(f.subtract(a).toString(16));
        System.out.println(a.subtract(b).toString(16));
        System.out.println(b.subtract(c).toString(16));
        System.out.println(c.subtract(d).toString(16));

        System.out.println(d.subtract(e).toString(16));
        System.out.println(e.subtract(f).toString(16));
        /*





        4297  -> 5e9e bc70 c2a9 a83b e578 5ed8 24280
        4298  -> 5e9e bc70 c2a9 a83b e578 5eb3 24243
        4299  -> 5e9e bc70 c2a9 a83b e578 5f04 24324
        4301  -> 5e9e bc70 c2a9 a83b e578 5e8a 24202
        4302  -> 5e9e bc70 c2a9 a83b e578 5ec4 24260
        4303  -> 5e9e bc70 c2a9 a83b e578 5e63 24163
        4304  -> 5e9e bc70 c2a9 a83b e578 5e4a 24138
        4305  -> 5e9e bc70 c2a9 a83b e578 5e35 24117
        4306  -> 5e9e bc70 c2a9 a83b e578 5e9c 24220
        4307  -> 5e9e bc70 c2a9 a83b e578 5e22 24098
        4308  -> 5e9e bc70 c2a9 a83b e578 5e79 24185
        4310  -> 5e9e bc70 c2a9 a83b e578 5e0d 24077

        124 ->   5ea116ecc2a9a83be5943a5a
        125 ->   5e9eb173c2a9a83be56edf13
        126 ->   5e9c7fa5c2a9a83be591cddb

        22686 -> 5fa4 2b25 509b d17f afdb ab45
        23282 -> 5fc26d86f66aedd6e3b549d1
        23421 -> 5fc8faa7f66aedd6e3ce469e
        23430 -> 5fc7c193f66aedd6e3c952f5

        24617 -> 5ff0763c9b6bc77ea2ad297e
        24759 -> 5ff478959b6bc77ea2b70a04
        25381 -> 5ffda68b9b6bc77ea2d692e7

        26034 -> 60147a2e9b6bc77ea22b59fe
        26105 -> 601837f89b6bc77ea23575fc
        26106 -> 601854fd9b6bc77ea235d98e
        26107 -> 601855449b6bc77ea235db28
        26108 -> 6018555c9b6bc77ea235dbda
        26109 -> 601855739b6bc77ea235dc5c
        26110 -> 6018558a9b6bc77ea235dc96
        26111 -> 601855a19b6bc77ea235dce1


        26141 -> 601940f69b6bc77ea238a8d0
        26142 -> 6019873e9b6bc77ea238f69c
        26143 -> 6019b53a9b6bc77ea2391521
        **/
    }
}
