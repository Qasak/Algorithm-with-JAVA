package leetcode.template.BIT;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/3 15:48
 */
public class Q315_BIT {
    // 和「堆」一样，树状数组的 0 号下标不放置元素，从 1 号下标开始使用。
    // c[x] : x的右边有几个大于x的元素
    // 初始化树状数组的时间代价是 O(n)O(n)；通过值获取离散化 id 的操作单次时间代价为 O(logn)；对于每个序列中的每个元素，都会做一次查询 \rm idid、单点修改和前缀和查询，总的时间代价为 O(n \log n)O(nlogn)
    int[] c;
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        for(int i = 0; i < n; i++) {
            nums[i] -= min;
        }
        c = new int[max - min + 1];
        Integer[] ans = new Integer[n];
        for(int i = n - 1; i >= 0; i--) {
            ans[i] = getSum(nums[i]);
            // 值里面有0，+1：零号下标不放元素
            update(nums[i] + 1);
        }
        return Arrays.asList(ans);

    }
    public int getSum(int x) {
        int ans = 0;
        while(x > 0) {
            ans += c[x];
            x &= (x - 1);
        }
        return ans;
    }
    public void update(int x) {
        while(x < c.length) {
            c[x] += 1;
            x += x & -x;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        PriorityQueue<int[]> buy = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        PriorityQueue<int[]> sell = new PriorityQueue<>();

    }
}
