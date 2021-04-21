package leetcode.template.Sort;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/3 17:07
 */
public class Q51_ReversePair {
    int ans;
    int[] tmp;
    public int reversePairs(int[] nums) {
        ans = 0;
        int n = nums.length;
        tmp = new int[n];
        mergeSort(nums, 0, n - 1);
        return ans;
    }
    public void mergeSort(int[] nums, int l, int r) {
        if(l >= r) {
            return;
        }
        int m = (l + r) >>> 1;
        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, r);
        int i = l;
        int p1 = l;
        int p2 = m + 1;
        while(p1 <= m && p2 <= r) {
            if(nums[p1] <= nums[p2]) {
                ans += p2 - m - 1;
                tmp[i++] = nums[p1++];
            } else {
                tmp[i++] = nums[p2++];
            }
        }
        while(p1 <= m) {
            ans += p2 - m - 1;
            tmp[i++] = nums[p1++];
        }
        while(p2 <= r) {
            tmp[i++] = nums[p2++];
        }
        for(int j = l; j <= r; j++) {
            nums[j] = tmp[j];
        }
    }
}
