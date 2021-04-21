package leetcode.SpringRecruit.ArrayAndString;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/6 14:45
 */
public class Q80_删除有序数组中的重复项2 {
    // 1. 递归
    class Solution {
        int mark = 0x3f3f3f3f;
        public int removeDuplicates(int[] nums) {
            int n = nums.length;
            int cnt = 0;

            for(int i = 0; i < n - 1; i++) {
                if(nums[i] == nums[i + 1]) {
                    int j = i + 2;
                    while(j < n && nums[j] == nums[i]) {
                        nums[j++] = mark;
                        cnt++;
                    }
                    i = j - 1;
                }
            }
            int ans = n - cnt;
            // System.out.println(Arrays.toString(nums));
            modify(-1, 0, nums, true);
            // System.out.println(Arrays.toString(nums));

            return ans;
        }
        private void modify(int pre, int cur, int[] nums, boolean isFirst) {
            int n = nums.length;
            if(cur == n) {
                return;
            }
            if(nums[cur] == mark) {
                if(isFirst) {
                    modify(cur, cur + 1, nums, false);
                } else {
                    modify(pre, cur + 1, nums, false);
                }
            } else {
                if(pre == -1) {
                    modify(-1, cur + 1, nums, true);
                    return;
                }
                // System.out.println(pre + " " + nums[pre] + " " + cur + " " + nums[cur]);
                // System.out.println(Arrays.toString(nums));
                for(int i = cur ;i < n ; i++) {
                    nums[pre++] = nums[i];
                }
                int p = 0;
                for(int i = 0 ;i < n ; i++) {
                    if(nums[i] == mark) {
                        p = i;
                        break;
                    }
                }
                if(p != 0) {
                    // System.out.println(cur + " " + p + " " + nums[p]);
                    // System.out.println(Arrays.toString(nums));

                    modify(p - 1, p, nums, true);
                }
            }
        }
    }
    // 2 .双指针
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i = 2, j = 2;
        while(j < n) {
            if(nums[i - 2] == nums[j]) {
                j++;
            } else {
                nums[i] = nums[j];
                i++;
                j++;
            }
        }
        return i;
    }
}
