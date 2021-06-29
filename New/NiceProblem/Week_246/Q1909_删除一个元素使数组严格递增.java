package leetcode.contest.Week_246;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/29 17:58
 */
public class Q1909_删除一个元素使数组严格递增 {
    // n ^ 2
    // O(N)
    public boolean canBeIncreasing(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n - 1; i++) {
            if(nums[i] >= nums[i + 1]) {
                return check(nums, i) || check(nums, i + 1);
            }
        }
        return true;
    }
    public boolean check(int[] nums, int i) {
        int n = nums.length;
        if(i == 0 || i == n - 1) {
            if(i == 0) {
                return check(nums, 1, n - 1);
            } else {
                return check(nums, 0, n - 2);
            }
        } else {
            return nums[i - 1] < nums[i + 1] && check(nums, 0, i - 1) && check(nums, i + 1, n - 1);
        }
    }
    public boolean check(int[] nums, int l, int r) {
        for(int i = l; i < r; i++) {
            if(nums[i] >= nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // 贪心 O(N)
    // 当出现小于前一个数的情况出现时，判断三个数的关系，逻辑分别为：
    //
    //当前数小于等于前两个数，此时把当前数赋值为前一个数。此时，i++ 后，再比较的时候就是与前一个数的大小关系，相当于删除了当前数。
    //当前数仅小于等于前一个数，大于index往前的第两个数，那么只需要变更前一个数为当前数即可。此时，i++ 后，再比较的时候就是与当前数的大小关系，相当于删除了前一个数。当然，由于前一个数不会再用到，该赋值操作也可略去，代码中注释部分。
    //此时只需要判断这种情况是否只出现了一次，如果次数超过一次，直接结束循环并返回 false
    public boolean canBeIncreasing1(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        for(int i = 1; i < n; i++) {
            if(nums[i] <= nums[i - 1]) {
                cnt++;
                if(cnt > 1) {
                    return false;
                }
                if(i > 1 && nums[i] <= nums[i - 2]) {
                    nums[i] = nums[i - 1];
                }
            }
        }
        return true;
    }
}
