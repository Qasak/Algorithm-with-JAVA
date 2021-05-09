package NewCoder.ByteDance_2019;


import java.io.Serializable;
import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/31 16:16
 */

/*
*
输入描述:
第一行包含一个正整数N，代表测试用例的个数。

每个测试用例的第一行包含一个正整数M，代表视频的帧数。

接下来的M行，每行代表一帧。其中，第一个数字是该帧的特征个数，接下来的数字是在特征的取值；比如样例输入第三行里，2代表该帧有两个猫咪特征，<1，1>和<2，2>
所有用例的输入特征总数和<100000

N满足1≤N≤100000，M满足1≤M≤10000，一帧的特征个数满足 ≤ 10000。
特征取值均为非负整数。

输出描述:
对每一个测试用例，输出特征运动的长度作为一行
*
如果特征<a, b>在持续帧里出现，那么它将构成特征运动。比如，特征<a, b>在第2/3/4/7/8帧出现，那么该特征将形成两个特征运动2-3-4 和7-8。
现在，给定每一帧的特征，特征的数量可能不一样。小明期望能找到最长的特征运动。
*
输入例子1:
*
1
3
2 0 0 1 1
2 0 1 3 3
2 3 3 4 4
*
2

例子说明1:
特征<1,1>在连续的帧中连续出现3次，相比其他特征连续出现的次数大，所以输出3
* */
public class Q4_特征提取 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while(n-- > 0) {
            int m = sc.nextInt();
            HashMap<Pair<Integer, Integer>, Integer>[] dp = new HashMap[m];
            for(int i = 0; i < m; i++) {
                dp[i] = new HashMap<>();
            }
            int ans = 1;
            String k = sc.nextLine();
            String line1 = sc.nextLine();
            String[] t1 = line1.split(" ");
            int[] nums1 = new int[t1.length];
            for(int i = 0; i < t1.length; i++) {
                nums1[i] = Integer.parseInt(t1[i]);
            }
            for(int i = 1; i < 2 * nums1[0]; i += 2) {
                dp[0].put(new Pair<>(nums1[i], nums1[i + 1]), 1);
            }
            for(int i = 1; i < m; i++) {
                String line = sc.nextLine();
                String[] t = line.split(" ");
                int[] nums = new int[t.length];
                for (int j = 0; j < t.length; j++) {
                    nums[j] = Integer.parseInt(t[j]);
                }
                for (int j = 1; j < 2 * nums[0]; j += 2) {
                    Pair<Integer, Integer> tmp = new Pair<>(nums[j], nums[j + 1]);
                    if((int)dp[i - 1].getOrDefault(tmp, 0) > 0) {
                        dp[i].put(tmp, dp[i - 1].get(tmp) + 1);
                    } else {
                        dp[i].put(tmp, 1);
                    }
                    ans = Math.max(ans, dp[i].get(tmp));

                }
            }
            System.out.println(ans);
        }
    }
}
class Pair<K,V> {
    int x;
    int y;
    public Pair(int xx, int yy) {
        x = xx;
        y = yy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return x == pair.x &&
                y == pair.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
