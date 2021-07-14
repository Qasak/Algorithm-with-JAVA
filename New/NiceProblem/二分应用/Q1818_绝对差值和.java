package leetcode.contest.NiceProblem.二分应用;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/14 8:39
 */
public class Q1818_绝对差值和 {
    //
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        // [1,28,21]
        // [9,21,20]
        // 对于每一个i，从nums1中找一个最接近nums2[i]的nums1[i]
        int n = nums1.length;
        int mod = (int)(1e9 + 7);
        int[] tmp = new int[n];
        int[] abs = new int[n];
        for(int i = 0; i < n; i++) {
            tmp[i] = nums1[i];
            abs[i] = Math.abs(nums1[i] - nums2[i]);
        }
        Arrays.sort(tmp);
        // System.out.println(Arrays.toString(tmp));
        int[] diff = new int[2];
        for(int i = 0; i < n; i++) {
            if(nums2[i] <= tmp[n - 1]) {
                // System.out.println("ub: " + ub(tmp, nums2[i]));
                int t = abs[i] - Math.abs(nums2[i] - ub(tmp, nums2[i]));
                if(t > diff[0]) {
                    diff[0] = t;
                    diff[1] = i;
                }
            }
            if(nums2[i] >= tmp[0]) {
                // System.out.println("lb: " + lb(tmp, nums2[i]));
                int t = abs[i] - Math.abs(nums2[i] - lb(tmp, nums2[i]));
                if(t > diff[0]) {
                    diff[0] = t;
                    diff[1] = i;
                }
            }
        }
        // System.out.println(Arrays.toString(diff));

        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(i == diff[1]) {
                abs[i] -= diff[0];
            }
            ans += abs[i];
            if(ans >= mod) {
                ans -= mod;
            }
        }
        return ans;
    }
    private int ub(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while(l < r) {
            int m = (l + r) >>> 1;
            if(nums[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return nums[l];
    }
    private int lb(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while(l < r) {
            int m = (l + r + 1) >>> 1;
            if(nums[m] > target) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        return nums[l];
    }


    public int minAbsoluteSumDiff1(int[] nums1, int[] nums2) {
        int mod = (int) (1e9 + 7);
        int n = nums1.length;
        int[] abs = new int[n];
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < n; i++) {
            set.add(nums1[i]);
            abs[i] = Math.abs(nums1[i] - nums2[i]);
        }
        int diff = 0;
        int idx = 0;
        for(int i = 0; i < n; i++) {
            Integer x = set.ceiling(nums2[i]);
            Integer y = set.floor(nums2[i]);
            if(x != null) {
                int t = abs[i] - Math.abs(x - nums2[i]);
                if(t > diff) {
                    diff = t;
                    idx = i;
                }
            }
            if(y != null) {
                int t = abs[i] - Math.abs(y - nums2[i]);
                if(t > diff) {
                    diff = t;
                    idx = i;
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(i == idx) {
                abs[i] -= diff;
            }
            ans += abs[i];
            if(ans >= mod) {
                ans -= mod;
            }
        }
        return ans;
    }

    public int minAbsoluteSumDiff2(int[] nums1, int[] nums2) {
        // [1,28,21]
        // [9,21,20]
        // 对于每一个i，从nums1中找一个最接近nums2[i]的nums1[i]
        int n = nums1.length;
        int mod = (int)(1e9 + 7);
        int[] tmp = nums1.clone();
        Arrays.sort(tmp);
        long ans = 0;
        long max = 0;
        for(int i = 0; i < n; i++) {
            int a = nums1[i], b = nums2[i];
            int abs = Math.abs(a - b);
            ans += abs;
            int j = ceiling(tmp, b);
            int t = abs - Math.abs(tmp[j] - b);
            if(j > 0) {
                t = Math.max(t, abs - Math.abs(tmp[j - 1] - b));
            }
            max = Math.max(max, t);
        }
        return (int) ((ans - max) % mod);
    }
    // 返回>= target的元素下标
    private int ceiling(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while(l < r) {
            int m = (l + r) >>> 1;
            if(nums[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
    // 返回<= target的元素下标
    private int floor(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while(l < r) {
            int m = (l + r + 1) >>> 1;
            if(nums[m] > target) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        return l;
    }
}
