package leetcode.template.PrefixSum;

import java.util.Arrays;

/**
 * @author Jason.W
 * @version 1.0
 * @date 2020/12/3 16:53
 *
 * 我们考虑任意一个数对(a,b)，不妨假设a≤b。
 * 假设最终选定的和值为target，则我们可以发现，
 * 对于(a,b)这个数对：
 *
 * 当target<1+a时，需要操作两次；
 * 当1+a≤target<a+b时，需要操作一次；
 * 当target=a+b时，不需要操作；
 * 当a+b<target≤b+limit时，需要操作一次；
 * 当target>b+limit时，需要操作两次。
 * 我们设初始操作次数为两次。令target从数轴最左端开始向右移动，我们会发现：
 *
 * 在1+a，操作次数减少一次；
 * 在a+b，操作次数减少一次；
 * 在a+b+1，操作次数增加一次；
 * 在b+limit+1处，操作次数增加一次。
 *
 *


 */
public class Complementary_1674 {
    // 暴力：O(n*limit)
    // 1.扫描所有对子nums[j], nums[n - j - 1]
    // 2.可能的T:[2, 2 * limit], 对每个对子的和调整为T所需的次数求和
    // 3.过程中统计出最小的移动次数(也可以存到一个数组中，最后统计最小值，该数组可优化为差分数组)
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int[] res = new int[2 + 2 * limit];
        for(int j = 0; j < n / 2; j++) {
            int a = Math.min(nums[j], nums[n - j - 1]);
            int b = Math.max(nums[j], nums[n - j - 1]);
            for(int t = 2; t <= 2 * limit; t++){
                // 区间求和：优化为差分数组
                if(t >= 2 && t < a + 1) {
                    res[t] += 2;
                } else if(t >= a + 1 && t < a + b) {
                    res[t] += 1;
                } else if(t == a + b) {
                    res[t] += 0;
                } else if(t > a + b && t < b + limit + 1) {
                    res[t] += 1;
                } else {
                    res[t] += 2;
                }
            }
        }
        for(int i = 2; i <= 2 * limit; i++) {
            ans = Math.min(ans, res[i]);
        }
        return ans;
    }
    // 差分数组O(n)
    public int minMoves1(int[] nums, int limit) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int[] diff = new int[2 + 2 * limit];
        // 每个pair(a, b)所需要的操作数取决于 (a, b) 与 t的相对位置
        // 如： 当t属于[2, a + 1)， res[t] += 2
        for(int j = 0; j < n / 2; j++) {
            int a = Math.min(nums[j], nums[n - j - 1]);
            int b = Math.max(nums[j], nums[n - j - 1]);
            int p0 = 2;
            int p1 = a + 1;
            int p2 = a + b;
            int p3 = b + limit + 1;
            // [2, a + 1) : 2
            diff[p0] += 2;
            diff[p1] -= 2;
            // [a + 1, a + b) : 1
            diff[p1] += 1;
            diff[p2] -= 1;
            // [a + b + 1, b + limit + 1)
            diff[p2 + 1] += 1;
            diff[p3] -= 1;
            //[b + limit + 1, 2 * limit]
            diff[p3] += 2;
        }
        int sum = 0;
        for(int t = 2; t <= 2 * limit; t++) {
            sum += diff[t];
            ans = Math.min(sum, ans);
        }
        return ans;
    }
}
