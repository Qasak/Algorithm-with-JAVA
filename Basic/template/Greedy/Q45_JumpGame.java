package leetcode.template.Greedy;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/20 20:23
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *     从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 * 
 */
public class Q45_JumpGame {
    // 1 Greedy
    public int jump(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        int pos = n - 1;
        while(pos > 0) {
            for(int i = 0; i < pos; i++) {
                // 从前往后找，能到达poS位置，则选最小的那个
                if(i + nums[i] >= pos) {
                    pos = i;
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }
    // 我们维护当前能够到达的最大下标位置，记为边界。我们从左到右遍历数组，到达边界时，更新边界并将跳跃次数增加 1。

    public int jump1(int[] nums) {
        int cnt = 0;
        int end = 0;
        int maxPos = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if(i == end) {
                cnt++;
                end = maxPos;
            }
        }
        return cnt;
    }
}
