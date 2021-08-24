package leetcode.template.BinSearch;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/31 17:48
 */
public class Q1539_KthPositive {
    // 1 2 3 4 5 6 7 8 9 10 11
    // _ 2 3 4 _ _ 7 _ _ _  11
    // 对每个元素，都可以唯一确定到第i个元素为止，缺失的元素数量是ai - i - 1
    // [2,3,4,7,11]
    // 2 - 0 - 1 = 1
    // 7 - 3 - 1 = 3
    // 11 - 4 -1 = 6

    // brutal
    public int findKthPositive1(int[] arr, int k) {

        int i = 1;
        int j = 0;
        while(k > 0) {
            if(j < arr.length && i == arr[j]) {
                i++;
                j++;
            } else {
                i++;
                k--;
            }
        }
        return i - 1;
    }
    public int findKthPositive(int[] arr, int k) {
        if (arr[0] > k) {
            return k;
        }

        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            int x = mid < arr.length ? arr[mid] : Integer.MAX_VALUE;
            if (x - mid - 1 >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return k - (arr[l - 1] - (l - 1) - 1) + arr[l - 1];
    }
}
