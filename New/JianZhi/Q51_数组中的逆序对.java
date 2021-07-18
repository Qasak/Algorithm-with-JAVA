package leetcode.JianZhi;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/18 9:14
 */
public class Q51_数组中的逆序对 {
    int[] tmp;
    int ans = 0;
    public int reversePairs(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);

        return ans;
    }
    private void mergeSort(int[] nums, int l, int r) {
        // System.out.println(Arrays.toString(nums));
        if(l >= r) {
            return;
        }
        int m = (l + r) >>> 1;
        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, r);
        int i = l, j = m + 1;
        int idx = l;
        while(i <= m && j <= r) {
            if(nums[i] <= nums[j]) {
                tmp[idx++] = nums[i++];
            } else {
                ans += m - i + 1;
                tmp[idx++] = nums[j++];
            }
        }
        while(i <= m) {
            tmp[idx++] = nums[i++];
        }
        while(j <= r) {
            tmp[idx++] = nums[j++];
        }
        for(int k = l; k <= r; k++) {
            nums[k] = tmp[k];
        }
    }
}
