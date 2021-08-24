package leetcode.template.Sort;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/9 11:09
 */
public class ReversPairs_51 {
    int cnt = 0;
    public int reversePairs(int[] nums) {
		// [0, n - 1]
        mergeSort(nums, 0, nums.length - 1);
        return cnt;
    }
    private void mergeSort(int[] nums, int l, int r) {
        if(l < r) {
            int m = l + (r - l) / 2;
            mergeSort(nums, l, m);
            mergeSort(nums, m + 1, r);

            int p1 = l;
            int p2 = m + 1;
            // 数组1 [l, m]
			// 数组2 [m + 1, r]
            while(p1 <= m && p2 <= r) {
				// [p1, m]个数都比nums[p2]大
                if(nums[p1] > nums[p2]) {
                    cnt += m - p1 + 1;
                    p2++;
                } else {
                    p1++;
                }
            }

            merge(nums, l, r);
        }
    }
    private void merge(int[] nums, int l, int r) {
        int m = l + (r - l) / 2;
        int p1 = l;
        int p2 = m + 1;
		// [l, r]
        int n = r - l + 1;
		// 合并两个有序数组后复制给原数组
        int[] tmp = new int[n];
        int i = 0;
        while(p1 <= m && p2 <= r) {
            tmp[i++] = nums[p1] < nums[p2] ? nums[p1++] : nums[p2++];
        }
        while(p1 <= m) {
            tmp[i++] = nums[p1++];
        }
        while(p2 <= r) {
            tmp[i++] = nums[p2++];
        }
        for(int k = 0; k < n; k++) {
            nums[k + l] = tmp[k];
        }
    }
}
