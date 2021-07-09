package leetcode.contest.NiceProblem.众数技巧;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/9 8:46
 */
public class QMS17_10_主要元素 {
    // 投票算法
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int major = -1;
        int cnt = 0;
        // 是否存在众数
        for(int i : nums) {
            if(cnt == 0) {
                major = i;
            }
            if(i == major) {
                cnt++;
            } else {
                cnt--;
            }
        }
        // 由于不一定存在主要元素，因此需要第二次遍历数组，验证 major 是否为主要元素
        cnt = 0;
        for(int i : nums) {
            if(i == major) {
                cnt++;
            }
        }
        return cnt >= n / 2 + 1  ? major : -1;
    }
}
