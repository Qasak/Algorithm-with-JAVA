package leetcode.SpringRecruit.ArrayAndString;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/6 15:39
 */
public class Q26_删除有序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i = 1, j = 1;
        while(j < n) {
            if(nums[i - 1] == nums[j]) {
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
