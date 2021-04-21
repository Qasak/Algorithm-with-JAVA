package leetcode.template.Range;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/1 11:24
 */
public class Q303_PreSum {
    class NumArray {
        int[] pre;
        public NumArray(int[] nums) {
            int n = nums.length;
            pre = new int[n + 1];
            for(int i = 0; i < n; i++) {
                pre[i + 1] = pre[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return pre[j + 1] - pre[i];
        }
    }
}
