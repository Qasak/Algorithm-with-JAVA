package leetcode.SpringRecruit.ArrayAndString;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/27 9:44
 */
public class Q189_旋转数组 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        int rsft = n - (k % n);
        int idx = 0;
        for(int i = rsft; i < n; i++) {
            ans[idx++] = nums[i];
        }
        for(int i = 0; i < rsft; i++) {
            ans[idx++] = nums[i];
        }
        for(int i = 0; i < n; i++) {
            nums[i] = ans[i];
        }
    }
    class Solution {
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            k = k % n;
            reverse(nums, 0, n - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, n - 1);
        }
        public void reverse(int[] nums, int i, int j) {
            while(i < j) {
                swap(nums, i, j);
                i++; j--;
            }
        }
        public void swap(int[] nums, int i, int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
}
