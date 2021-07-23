package leetcode.contest.Rating1300.差分数组;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/23 2:34
 */
public class Q1893_检查是否区域内所有整数都被覆盖 {
    // int[] d:每个元素的个数
    // d[i] = nums[i] - nums[i - 1]
    // nums[i] = nums[i - 1] + d[i]
    public boolean isCovered(int[][] ranges, int left, int right) {
        int n = 52;
        int[] d = new int[n];
        d[left]++;
        d[right + 1]--;
        for(int[] t : ranges) {
            d[t[0]]--;
            d[t[1] + 1]++;
        }
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += d[i];
            if(i >= left && i <= right) {
                if(sum > 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
