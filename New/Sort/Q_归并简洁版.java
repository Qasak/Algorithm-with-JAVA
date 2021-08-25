package leetcode.template.Sort;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/24 15:57
 */
public class Q_归并简洁版 {
    int[] tmp;
    void mergeSort(int[] nums, int l, int r) {
        if(l >= r) {
            return;
        }
        mergeSort(nums, l, (l + r) / 2);
        mergeSort(nums, (l + r) / 2 + 1, r);
        int idx = l, i = l, j = (l + r) / 2 + 1;
        while(i <= (l + r) / 2 && j <= r) {
            if(nums[i] < nums[j]) {
                tmp[idx++] = nums[i++];
            } else {
                tmp[idx++] = nums[j++];
            }
        }
        while(i <= (l + r) / 2) {
            tmp[idx++] = nums[i++];
        }
        while(j <= r) {
            tmp[idx++] = nums[j++];
        }
        for(int k = l; k <= r; k++) {
            nums[k] = tmp[k];
        }
    }
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        tmp = new int[n];
        mergeSort(nums, 0, n - 1);
        return nums;
    }
}
