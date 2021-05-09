package NewCoder.ByteDance_2019;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/31 18:37
 */

/*
机器人正在玩一个古老的基于DOS的游戏。游戏中有N+1座建筑——从0到N编号，从左到右排列。编号为0的建筑高度为0个单位，编号为i的建筑的高度为H(i)个单位。

起初， 机器人在编号为0的建筑处。每一步，它跳到下一个（右边）建筑。假设机器人在第k个建筑，且它现在的能量值是E, 下一步它将跳到第个k+1建筑。它将会得到或者失去正比于与H(k+1)与E之差的能量。如果 H(k+1) > E 那么机器人就失去 H(k+1) - E 的能量值，否则它将得到 E - H(k+1) 的能量值。

游戏目标是到达第个N建筑，在这个过程中，能量值不能为负数个单位。现在的问题是机器人以多少能量值开始游戏，才可以保证成功完成游戏？

5
3 4 3 2 4

4

输入例子2:
3
4 4 4

输出例子2:
4

输入例子3:
3
1 6 4

输出例子3:
3
* */
public class Q7_机器人跳跃 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] t = sc.nextLine().split(" ");
        int[] h = new int[n];
        for(int i = 0; i < n; i++) {
            h[i] = Integer.parseInt(t[i]);
        }
        double[] dp = new double[n];
        // 在这个过程中，能量值不能为负数个单位 -> 最后一步的能量为0
        for(int i = n - 2; i >= 0; i--) {
            dp[i] = (Math.ceil(h[i + 1] + dp[i + 1])) / 2;
        }
        System.out.println((int) Math.ceil((dp[0] + h[0]) / 2));
    }

}
