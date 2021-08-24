package leetcode.template.MonotonousStack;

import leetcode.contest.WeekContest_217.Q1673_找出最有竞争力的子序列;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/11/29 10:32
 *
 * 整数数组 nums 和一个正整数 k
 * 返回长度为 k 且最具 竞争力 的 nums 子序列。
 *
 * 数组的子序列是从数组中删除一些元素（可能不删除元素）得到的序列
 *
 * 子序列 a 和子序列 b 第一个不相同的位置上
 * 如果 a 中的数字小于 b 中对应的数字
 * 子序列 a 比子序列 b（相同长度下）更具 竞争力
 *
 *
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^9
 * 1 <= k <= nums.length
 *
 *
 * 输入：nums = [3,5,2,6], k = 2
 * 输出：[2,6]
 *
 * nums = [3,5,2,6], k = 3
 *   [2,3,5,6]
 * [3, 2, 6]
 *
 * 输入：nums = [2,4,3,3,5,4,9,6], k = 4
 * 输出：[2,3,3,4]
 *
 *
 * 换句话说，就是再保持原有相对顺序的基础上得到字典序最小的序列
 */
public class MostCompetitive_1673 {
    public static int[] mostCompetitive1(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> st = new LinkedList<>();
        // 保留k个，删除n - k 个
        int t = n - k;
        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && st.peekLast() > nums[i] && t > 0) {
                st.pollLast();
                t--;
            }
            st.offer(nums[i]);
        }
        // 12345
        // k = 4
        // t = 1
        // 删除最末尾的一个

        // 2,4,3,3,5,4,9,6
        // k = 4
        // t = 4
        // 删除4 5 9 , t == 1, 还需要把最后一个6删除
        for(int i = 0; i < t; i++) {
            st.pollLast();
        }
        int[] ans = new int[k];
        int i = 0;
        while(!st.isEmpty()) {
            ans[i++] = st.pollFirst();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,4,3,3,5,4,9,6};
        int k = 4;
        int[] ans = Q1673_找出最有竞争力的子序列.mostCompetitive1(nums, k);
        for(int i: ans) {
            System.out.println(i);
        }

    }
}
