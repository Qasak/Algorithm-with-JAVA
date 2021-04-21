package leetcode.template.Sort;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/11 11:47
 */
public class Q912_Sort {
    public int[] sortArray(int[] nums) {
        // 归并
        // mergeSort(nums, 0, nums.length - 1);
        // 快排
        quickSort(nums, 0, nums.length - 1);
        // 堆排
        return nums;
    }
    public void heapSort(int[] nums) {
        int len = nums.length - 1;
        buildMaxHeap(nums, len);
        for (int i = len; i >= 1; --i) {
            swap(nums, i, 0);
            len -= 1;
            maxHeapify(nums, 0, len);
        }
    }

    public void buildMaxHeap(int[] nums, int len) {
        for (int i = len / 2; i >= 0; --i) {
            maxHeapify(nums, i, len);
        }
    }

    public void maxHeapify(int[] nums, int i, int len) {
        for (; (i << 1) + 1 <= len;) {
            int lson = (i << 1) + 1;
            int rson = (i << 1) + 2;
            int large;
            if (lson <= len && nums[lson] > nums[i]) {
                large = lson;
            } else {
                large = i;
            }
            if (rson <= len && nums[rson] > nums[large]) {
                large = rson;
            }
            if (large != i) {
                swap(nums, i, large);
                i = large;
            } else {
                break;
            }
        }
    }

    private void mergeSort(int[] nums, int l, int r) {
        if(l < r) {
            int m = (l + r) >>> 1;
            mergeSort(nums, l, m);
            mergeSort(nums, m + 1, r);

            int p1 = l;
            int p2 = m + 1;
            int n = r - l + 1;
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
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    private int partition(int[] nums, int l, int r) {
        swap(nums, l + (int) Math.random() * (r - l + 1), r);
        int more = r;
        int cur = l;
        int p = nums[r];
        while(cur < more) {
            // <= | >
            // 小于等于p直接走，大于p的放到大于区间，直到小于等于p后，再往后走
            if(nums[cur] <= p) {
                cur++;
            } else {
                swap(nums, cur, --more);
            }
        }
        swap(nums, cur, r);
        return cur;
    }
    private void quickSort(int[] nums, int l, int r) {
        if(l < r) {
            int p = partition(nums, l, r);
            quickSort(nums, l, p - 1);
            quickSort(nums, p + 1, r);
        }
    }
}
