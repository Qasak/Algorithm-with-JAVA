package leetcode.template.Math;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/19 17:20
 */
public class Q360_有序转化数组 {
    int aa;
    int bb;
    int cc;
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        aa = a;
        bb = b;
        cc = c;
        int n = nums.length;
        int[] ans = new int[n];
        if(a == 0) {
            if(b >= 0) {
                for(int i = 0; i < n; i++) {
                    ans[i] = f(nums[i]);
                }
            } else {
                for(int i = n - 1; i >= 0; i--) {
                    ans[n - 1 - i] = f(nums[i]);
                }
            }
            return ans;
        }
        double axis = -((double)b / (2 * (double)a));
        double min = 9999999;
        // int axis = -(b / (2 * a));
        // int min = 9999999;
        // System.out.println(axis);
        int idx = -1;
        for(int i = 0; i < n; i++) {
            if(Math.abs(axis - nums[i]) < min) {
                min = Math.abs(axis - nums[i]);
                idx = i;
            }
        }
        // System.out.println(idx);
        if(a > 0) {
            int i = idx, j = idx + 1, k = 0;
            if(j == n) {
                while(i >= 0) {
                    ans[k++] = f(nums[i--]);
                }
            }
            while(i >= 0 && j < n) {
                if(f(nums[i]) < f(nums[j])) {
                    ans[k++] = f(nums[i--]);
                } else {
                    ans[k++] = f(nums[j++]);
                }
            }
            while(i >= 0) {
                ans[k++] = f(nums[i--]);
            }
            while(j < n) {
                ans[k++] = f(nums[j++]);
            }
        } else {
            int i = idx, j = idx + 1, k = n - 1;
            if(j == n) {
                while(i >= 0) {
                    ans[k--] = f(nums[i--]);
                }
            }
            while(i >= 0 && j < n) {
                if(f(nums[i]) > f(nums[j])) {

                    ans[k--] = f(nums[i--]);
                } else {
                    ans[k--] = f(nums[j++]);
                }
            }
            while(i >= 0) {
                ans[k--] = f(nums[i--]);
            }
            while(j < n) {
                ans[k--] = f(nums[j++]);
            }
        }
        return ans;
    }
    public int f(int x) {
        return x * (aa * x + bb) + cc;
    }
}
