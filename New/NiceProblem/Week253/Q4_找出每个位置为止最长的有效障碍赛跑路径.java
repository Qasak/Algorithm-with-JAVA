package leetcode.contest.Week253;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/8 19:24
 */
public class Q4_找出每个位置为止最长的有效障碍赛跑路径 {
    public static int[] longestObstacleCourseAtEachPosition(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        Arrays.fill(f, 1);
        // d[len] : 长度为len的上升子序列的末尾元素
        int[] d = new int[n + 1];
        int len = 1;
        d[len] = nums[0];
        for(int i = 1; i < n; i++) {
            if(nums[i] >= d[len]) {
                d[++len] = nums[i];
                f[i] = len;
            } else {
                // 找到第一个大于当前元素的位置l
                int l = 1, r = len + 1;
                while(l < r) {
                    int m = (l + r) >>> 1;
                    if(d[m] <= nums[i]) {
                        l = m + 1;
                    } else {
                        r = m;
                    }
                }
                d[l] = nums[i];
//                if(i == 5) {
//                    System.out.println(Arrays.toString(d));
//                    System.out.println(nums[l]);
//                }
                f[i] = l;
            }
        }
//        System.out.println(Arrays.toString(f));
        return f;
    }

    public static void main(String[] args) {
        // [1,2,2,3,3,2]
        int[] nums = new int[]{3,1,5,6,4,2};
        longestObstacleCourseAtEachPosition(nums);
    }
}
