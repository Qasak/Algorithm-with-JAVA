package leetcode.SpringRecruit.ArrayAndString;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/9 16:53
 */
public class QJZ03_数组中的重复数字 {
    // 不用排序算法和集合
    // O(n) O(1)
    // 所有数字都在 0～n-1 的范围内
    // 自哈希/ 鸽巢原理

    //             // 相同的元素会修改相同的位置
    //            // 如果该位置被其他元素修改过，则还原
    public int findRepeatNumber(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            // System.out.println(Arrays.toString(nums));
            int k = nums[i] < 0 ? nums[i] + n : nums[i];
            if(nums[k] < 0) {
                // System.out.println(k + " " + nums[k] + " " + i + " " + nums[i]);
                return k;
            }
            nums[k] -= n;
        }
        return -1;
    }
}
