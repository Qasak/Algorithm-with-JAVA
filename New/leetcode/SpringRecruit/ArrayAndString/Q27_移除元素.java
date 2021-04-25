package leetcode.SpringRecruit.ArrayAndString;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/18 11:17
 */
public class Q27_移除元素 {
    public int removeElement(int[] nums, int val) {
        int i = 0, j = 0;
        while (j < nums.length){
            if(val != nums[j]) {
                nums[i++] = nums[j++];
            } else {
                j++;
            }
        }
        return i;
    }
}
