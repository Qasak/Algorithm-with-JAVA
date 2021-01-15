package leetcode.template.Array;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/14 14:50
 */
public class Q628_MaxProdThree {
    // pq模拟
    // O(nlogn)
    public int maximumProduct(int[] nums) {
        // - - +
        // + + +
        //

        // - - -
        // -1 -2 -3 -4 -5


        // -1 * -2 * -3
        // -6
        int prod = 1;
        List<Integer> neg = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int i : nums) {
            if(i < 0) {
                neg.add(i);
            }
            pq.add(i);
        }
        int max = pq.peek();
        for(int i = 0; i < 3; i++) {
            prod *= pq.poll();
        }
        if(neg.size() < 2) {
            return prod;
        }
        Collections.sort(neg);
        int t = max;
        for(int i = 0; i < 2; i++) {
            t *= neg.get(i);
        }
        return Math.max(prod, t);
    }
    // 直接排序
    // O(nlogn)
    public int maximumProduct1(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return Math.max(nums[n - 1] * nums[n - 2] * nums[n - 3], nums[0] * nums[1] * nums[n - 1]);
    }


    // 手动模拟: 找最大的三个数/ 最小的两个数
    // O(n)
    final int min = -1001;
    final int max = 1001;
    public int maximumProduct2(int[] nums) {
        int a, b, c, d ,e;
        a = b = c = min;
        d = e = max;
        int n = nums.length;
        for(int i : nums) {
            if(i > c) {
                if(i > a) {
                    c = b;
                    b = a;
                    a = i;
                }
                else if(i > b) {
                    c = b;
                    b = i;
                }
                else {
                    c = i;
                }
            }
            if(i < d) {
                if(i < e) {
                    d = e;
                    e = i;
                } else {
                    d = i;
                }
            }
        }
        return Math.max(a * b * c, a * d * e);
    }
}
