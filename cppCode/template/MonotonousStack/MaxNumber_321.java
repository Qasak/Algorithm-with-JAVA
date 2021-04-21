package leetcode.template.MonotonousStack;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/2 13:10
 *
 * 输入:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 *
 * [6, 5]
 * [9, 8, 3]
 * 输出:
 * [9, 8, 6, 5, 3]
 *
 * m = 4, n = 6
 * start = 0, end = 4
 *
 *

 *
 * 输入:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * 输出:
 * [6, 7, 6, 0, 4]
 *
 * 输入:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * 输出:
 * [9, 8, 9]
 *
 * (k <= m + n)
 * 从同一个数组中取出的数字保持其在原数组中的相对顺序。
 *
 * 5,6,4
 * 5,4,8,3
 * k = 7
 * 5,6,5,4,8,4,3
 *
 *
 *
 * [6,5,3,2]
 * [6,5,2]
 * [6,6,5,5,3,2]
 *
 */

/**
 * 令数组nums1的长度为 m，数组nums2的长度为 n，
 * 则需要从数组nums1中选出长度为 x的子序列，
 * 以及从数组nums2中选出长度为 y 的子序列
 * 其中 x+y=k，且满足 0≤x≤m 0≤y≤n。
 * 需要遍历所有可能的 x 和 y 的值，
 * 对于每一组 x 和 y 的值，得到最大数。
 * 在整个过程中维护可以通过拼接得到的最大数。
 * */

/**
 * 对于每一组 x 和 y 的值，得到最大数的过程分成两步，
 * 第一步是分别从两个数组中得到指定长度的最大子序列，
 * 第二步是将两个最大子序列合并。
 * */
/**
 * 第一步可以通过单调栈实现。
 * 单调栈满足从栈底到栈顶的元素单调递减，
 * 从左到右遍历数组，遍历过程中维护单调栈内的元素，
 * 需要保证遍历结束之后单调栈内的元素个数等于指定的最大子序列的长度。
 * 遍历结束之后，将从栈底到栈顶的元素依次拼接，即得到最大子序列。
 * */

/**
 * 第二步需要自定义比较方法。
 * 首先比较两个子序列的当前元素，
 * 如果两个当前元素不同，则选其中较大的元素作为下一个合并的元素，
 * 否则需要比较后面的所有元素才能决定选哪个元素作为下一个合并的元素。
 * */
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 单调栈核心代码(< 单减：最大)：
 * insert x
 * while (!sta.empty() && sta.top()<x)
 *     sta.pop()
 * sta.push(x)
 *
 * 单减栈：求最大
 * 单增栈：求最小
 *
 * */
/**
 * 为了找到长度为 k 的最大数，需要从两个数组中分别选出最大的子序列，
 * 这两个子序列的长度之和为 k
 * 两个子序列的长度最小为 0，最大不能超过 k 且不能超过对应的数组长度。
 *
 * */

/**
 * 步骤：
 * 1.保证数组有序的前提下，找到每个数组最大的组合；
 * 2.保证两个数组有序的前提下，找到它们的最大拼接；
 *
 * 单调栈的特性，使得它能轻松地处理第一点，
 * */
public class MaxNumber_321 {

    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length;
        int[] ans = new int[k];
        for(int i = 0; i <= Math.min(k, n); i++) {
            // 第一个数组最多取k个
            // +第二个数组元素后足够取满k个
            if(k - i <= m) {
                int[] tmp1 = maxSubsequence(nums1, i);
                int[] tmp2 = maxSubsequence(nums2, k - i);
                int[] tmp3 = merge(tmp1, tmp2);
                // 不能只比较当前值，如果当前值相等还需要比较后续哪个大
                if(compare(tmp3, 0, ans, 0)) {
                    System.arraycopy(tmp3, 0, ans, 0, k);
                }
            }
        }
        return ans;
    }
    private static int[] merge(int[] a, int[] b) {
        int n = a.length + b.length;
        int[] res = new int[n];
        int cur = 0, p1 = 0, p2 = 0;
        while(cur < n) {
            if(compare(a, p1, b, p2)) {
                res[cur++] = a[p1++];
            } else {
                res[cur++] = b[p2++];
            }
        }
        return res;
    }


    // 不能用普通的合并两个有序数组
    // 这两个数组不一定是有序的
    // [6,7]
    // [6,0,4]
    // 5

    /**
    private static int[] merge(int[] a, int[] b) {
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        int n = a.length + b.length;
        int[] res = new int[n];
        int cur = 0, p1 = 0, p2 = 0;
        while(p1 < a.length && p2 < b.length) {
            if(a[p1] > b[p2]) {
                res[cur++] = a[p1++];
            } else {
                res[cur++] = b[p2++];
            }
        }
        while(p1 < a.length) {
            res[cur++] = a[p1++];
        }
        while(p2 < b.length) {
            res[cur++] = b[p2++];
        }
        return res;
    }
    */
    private static boolean compare(int[] a, int p1, int[] b, int p2) {
        // b到头了，选a的数
        if(p2 >= b.length) {
            return true;
        }
        if(p1 >= a.length) {
            return false;
        }
        if(a[p1] > b[p2]) {
            return true;
        }
        if(a[p1] < b[p2]) {
            return false;
        }
        // 如果相等，继续
        return compare(a, p1 + 1, b, p2 + 1);
    }

    // 需要保留k个数字
    private static int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        // 需要删除t 个数字
        int t = n - k;
        for(int i = 0; i < n; i++) {
            while(!deque.isEmpty() && deque.peekLast() < nums[i] && t > 0) {
                deque.pollLast();
                t--;
            }
            deque.offer(nums[i]);
        }
        for(int i = 0; i < t; i++) {
            deque.pollLast();
        }
        int[] ans = new int[k];
        int i = 0;
        while(!deque.isEmpty()) {
            ans[i++] = deque.pollFirst();
        }
        return ans;
    }
    // O(k(m + n + k^2))
    public static void main(String[] args) {
        int[] nums1 = new int[]{6,7};
        int[] nums2 = new int[]{6,0,4};
        // [6, 6, 7, 0, 4]
        // [6, 7, 6, 0, 4]
        int k = 5;
        int[] ans = MaxNumber_321.maxNumber(nums1, nums2, k);
        System.out.println(Arrays.toString(ans));
    }

}
