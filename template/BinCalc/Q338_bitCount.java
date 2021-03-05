package leetcode.template.BinCalc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/3 9:27
 */
public class Q338_bitCount {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for(int i = 1; i <= num; i++) {
            ans[i] = ans[i & (i - 1)] + 1;
        }
        return ans;
    }
    // 2 : 10; 4 : 100; 8 : 1000
    // 3 : 11; 5 : 101; 9 : 1001
    public int[] countBits1(int num) {
        int[] ans = new int[num + 1];
        for(int i = 1; i <= num; i++) {
            ans[i] = (i & 1) == 1 ? ans[i - 1] + 1 : ans[i >> 1];
//            ans[i] = ans[(i >> 1)] + (i & 1);

        }
        return ans;
    }
    public int[] countBits2(int num) {
        int[] ans = new int[num + 1];
        for(int i = 1; i <= num; i++) {
            // (i & -i) == lowbit
            // i & (i - 1) == i - (i & -i)
            ans[i] = ans[i - (i & -i)] + 1;
        }
        return ans;
    }
    public static int bitCount(int i) {
        // HD, Figure 5-2
        i = i - ((i >>> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        i = (i + (i >>> 4)) & 0x0f0f0f0f;
        i = i + (i >>> 8);
        i = i + (i >>> 16);
        return i & 0x3f;
    }
    public static void main(String[] args) {
        List<Integer> tmp = new ArrayList<>();
        tmp.add(0, 2);
        tmp.add(1, 3);

        System.out.println(tmp);
    }
}
