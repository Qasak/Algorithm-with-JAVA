package leetcode.SpringRecruit.ArrayAndString;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/18 11:25
 */
public class Q283_移动零 {
    // i指向要填的位置，j指向当前元素
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int i = 0, j = 0;
        while(j < n) {
            if(nums[j] != 0) {
                nums[i++] = nums[j++];
            } else {
                j++;
            }
        }
        while(i < n) {
            nums[i++] = 0;
        }
    }

    public static void main(String[] args) {
        int a = (int) 1e5;
        System.out.println(a);
    }
}
