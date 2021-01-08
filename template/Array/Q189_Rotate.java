package leetcode.template.Array;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/8 0:09
 */
public class Q189_Rotate {
    // 1 暴力O(kn)
    public void rotate(int[] nums, int k) {
        // 1 2 3 4 5 6 7
        //       1 2 3 4 5 6 7

        //
        int n = nums.length;
        if(k == 0 || n == 0) {
            return;
        }
        k %= n;
        // 4 : 0, 1, 2,3
        // for(int i = 0; i < k; i++)
        // 4: 4,3,2,1
        // while(k > 0) { k--; }
        for(int i = 0; i < k; i++) {
            int t = nums[n - 1];
            for(int j = n - 1; j >= 1; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = t;
        }
    }
    // 2 翻转 O(n)
    public void rotate1(int[] nums, int k) {
        // 1 2 3 4 5 6 7
        //       1 2 3 4 5 6 7

        //
        int n = nums.length;
        if(k == 0 || n == 0) {
            return;
        }
        k %= n;
        // 1,2,3,4,5,6,7

        // 7,6,5,4,3,2,1
        // 5,6,7,1,2,3,4


        // while(k > 0) {
        //     int t = nums[n - 1];
        //     for(int j = n - 1; j >= 1; j--) {
        //         nums[j] = nums[j - 1];
        //     }
        //     nums[0] = t;
        //     k--;
        // }

        // for(int i = 0; i < k; i++) {
        //     swap(nums, n - 1 - i, (n - i + k) % n);
        // }
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);

    }
    // 1 2 3
    // 1 2 3 4
    private void reverse(int[] nums, int i, int j) {
        // i < j
        //
        while(i <= j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            i++;
            j--;
        }

    }
    // 3 gcd
}
