package leetcode.SpringRecruit.ArrayAndString;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/18 11:06
 */
public class Q26_删除有序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 1;
        int n = nums.length;
        while(j < n) {
            if(nums[j] == nums[i]) {
                j++;
            } else {
                nums[++i] = nums[j++];
            }
        }
        return i + 1;
    }
}
