package leetcode.template.BinSearch;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/4 9:51
 */
public class Q33_Search {
    //  换句话说：一个递增数组分成两个递增子数组
    // 其中左边每个元素都比右边大

    // 确定的元素：
    // target
    // nums[mid]
    // nums[0]:大数组最小的元素 -> 小于大数组最小：小数组
    // nums[n - 1] :小数组最大元素 -> 大于小数组最大：大数组
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n;
        //[l, r)
        while(l < r) {
            int mid = (l + r) / 2;
            // 找到了
            if(nums[mid] == target) {
                return mid;
            }
            // 没有找到:
            // 4,5,6,7,0,1,2
            // 4,5,6,0,1,2,3

            // mid != target
            // mid落在大数组
            if(nums[mid] > nums[n - 1]) {
                // target在小数组
                if(target < nums[0]) {
                    l = mid + 1;
                    // target也在大数组
                } else {
                    if(target < nums[mid]) {
                        r = mid;
                        // target > nums[mid]
                    } else {
                        l = mid + 1;
                    }
                }
                // target在[mid, 大数组最大)

                // mid在小数组
            } else {
                // target在大数组
                if(target > nums[n - 1]) {
                    r = mid;
                } else {
                    if(target < nums[mid]) {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                }
            }
        }
        return -1;
    }
}
