package leetcode.contest.NiceProblem;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/15 11:49
 */
public class Q852_山脉数组的峰顶索引 {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int l = 0, r = n;
        while(l < r) {
            int m = (l + r) >>> 1;
            if(m == 0) {
                return m;
            }
            if(m == n - 1) {
                return n - 1;
            }
            if(arr[m] > arr[m + 1] && arr[m] > arr[m - 1]) {
                return m;
                // 上坡
            } else if(arr[m] > arr[m - 1] && arr[m] < arr[m + 1]) {
                l = m + 1;
                // 下坡
            } else if(arr[m] < arr[m - 1] && arr[m] > arr[m + 1]) {
                r = m;
            }
        }
        return l;
    }
    // 当 check(mid) == true 调整的是 l 时：计算 mid 的方式应该为 mid = l + r + 1 >> 1
    // 当 check(mid) == true 调整的是 r 时：计算 mid 的方式应该为 mid = l + r >> 1：
    public int peakIndexInMountainArray1(int[] arr) {
        int n = arr.length;
        int l = 1, r = n - 1;
        while(l < r) {
            int m = (l + r + 1) >>> 1;
            if(arr[m] > arr[m - 1]) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}
