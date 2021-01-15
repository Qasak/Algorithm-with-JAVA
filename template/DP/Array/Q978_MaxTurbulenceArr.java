package leetcode.template.DP.Array;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/13 17:52
 */
public class Q978_MaxTurbulenceArr {
    // n^2复杂度
    public int maxTurbulenceSize(int[] arr) {
        // 9,4,2,10,7,8,8,1,9
        // 0 1 2 3  4 5 6 7 8
        //   [        ]

        // 4 8 12 16
        // 0 1 2  3

        //
        int n = arr.length;
        int len = 1;
        // int l = 0;
        for(int i = 0; i < n - 1; i++) {
            if(arr[i] == arr[i + 1]) {
                continue;
            }
            // 第一个数 > 第二个数 flag true
            boolean flag = (arr[i] > arr[i + 1]);
            // 1 2 3
            int r = i;
            while(r < n - 1 && ((flag && arr[r] > arr[r + 1]) || (!flag && arr[r] < arr[r + 1])) ) {
                len = Math.max(len, r + 2 - i);
                flag = !flag;
                r++;
            }
            // l++;
        }
        return len;
    }

    // 滑窗
    // 最长交替子序列：
    // 结束条件：元素不再交替
    public int maxTurbulenceSize1(int[] arr) {
        int n = arr.length;
        int l = 0;
        int len = 1;
        for(int i = 1; i < n; i++) {
            // x y z
            // x < y > z
            // x > y < z
            int c = Integer.compare(arr[i - 1], arr[i]);
            if(i == n - 1 || c * Integer.compare(arr[i], arr[i + 1]) != -1) {
                if(c != 0) {
                    len = Math.max(len, i - l + 1);
                }
                l = i;
            }
        }
        return len;
    }
    // 376摆动序列
    // dp1
    public int maxTurbulenceSize2(int[] arr) {
        int n = arr.length;
        int len, small, big;
        len = small = big = 1;
        for(int i = 1; i < n; i++) {
            if(arr[i] > arr[i - 1]) {
                big = small + 1;
                small = 1;
            } else if(arr[i] < arr[i - 1]) {
                small = big + 1;
                big = 1;
            } else {
                small = big = 1;
            }
            len = Math.max(len, Math.max(small, big));
        }
        return len;
    }
    // dp2
    public int maxTurbulenceSize3(int[] arr) {
        int n = arr.length;
        int[] up = new int[n];
        int[] down = new int[n];
        int len = 1;
        Arrays.fill(up, 1);
        Arrays.fill(down, 1);
        for(int i = 1; i < n; i++) {
            if(arr[i] > arr[i - 1]) {
                up[i] = down[i - 1] + 1;
            } else if(arr[i] < arr[i - 1]) {
                down[i] = up[i - 1] + 1;
            }
            len = Math.max(len, Math.max(down[i], up[i]));
        }
        return len;
    }
}
