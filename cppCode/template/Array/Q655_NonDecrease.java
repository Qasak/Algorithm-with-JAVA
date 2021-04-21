package leetcode.template.Array;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/7 15:18
 */
public class Q655_NonDecrease {
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        int cnt1 = 0;
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = nums[i];
        }
        // [3,4,2,3]
        // [5,7,1,8]
        for(int i = 0; i < n - 1 ; i++) {
            if(nums[i] > nums[i + 1]) {
                cnt1++;
                nums[i] = nums[i + 1];
                i = i == 0 ? -1 : i - 2;
            }
        }
        int cnt2 = 0;
        for(int i = 0; i < n - 1 ; i++) {
            if(a[i] > a[i + 1]) {
                cnt2++;
                a[i + 1] = a[i];
                i = i == 0 ? -1 : i - 2;
            }
        }
        return cnt1 <= 1 || cnt2 <= 1;
    }
}
