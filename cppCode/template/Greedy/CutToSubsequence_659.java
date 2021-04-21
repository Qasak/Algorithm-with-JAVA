package leetcode.template.Greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/4 16:05
 *
 * 输入: [1,2,3,3,4,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3
 * 3, 4, 5
 *
 * 输入: [1,2,3,4,4,5]
 * 输出: False
 *
 * 请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。
 */
public class CutToSubsequence_659 {
    // 1,2,3,4,5,6,7
    /**
     * 贪心：
     * 对于数组中的元素 xx，如果存在一个子序列以 x-1 结尾，则可以将 x 加入该子序列中。
     * 将 x 加入已有的子序列总是比新建一个只包含 x 的子序列更优，
     * 因为前者可以将一个已有的子序列的长度增加 1，而后者新建一个长度为 1 的子序列，
     * 而题目要求分割成的子序列的长度都不小于 3，因此应该尽量避免新建短的子序列。
     *
     * 使用两个哈希表，第一个哈希表存储数组中的每个数字的剩余次数，
     * 第二个哈希表存储数组中的每个数字作为结尾的子序列的数量。
     *
     * 1.首先判断元素x是否还有剩余。然后判断是否存在以 x-1 结尾的子序列，即根据第二个哈希表判断 x-1 作为结尾的子序列的数量是否大于 0，
     * 如果大于 0，则将元素 x 加入该子序列中。由于 x 被使用了一次，因此需要在第一个哈希表中将 x 的剩余次数减 1。
     * 又由于该子序列的最后一个数字从 x-1 变成了 x，因此需要在第二个哈希表中将 x-1 作为结尾的子序列的数量减 1，
     * 以及将 x 作为结尾的子序列的数量加 1。
     * 2.否则，x 为一个子序列的第一个数，为了得到长度至少为 3 的子序列，x+1和 x+2 必须在子序列中，
     * 因此需要判断在第一个哈希表中 x+1和 x+2 的剩余次数是否都大于 0。
     *
     *  2.1：当 x+1 和 x+2 的剩余次数都大于 0 时，可以新建一个长度为 3 的子序列 [x,x+1,x+2]。
     *  由于这三个数都被使用了一次，因此需要在第一个哈希表中将这三个数的剩余次数分别减 1。
     *  又由于该子序列的最后一个数字是x+2，因此需要在第二个哈希表中将 x+2 作为结尾的子序列的数量加 1。
     *  2.2：否则，无法得到长度为 3 的子序列 [x,x+1,x+2] ，因此无法完成分割，返回  false。
     *
     * */
    public boolean isPossible(int[] nums) {
        // 剩余元素个数
        Map<Integer, Integer> A = new HashMap<>();
        // 以某元素结尾的子序列数量
        Map<Integer, Integer> B = new HashMap<>();
        for(int x : nums) {
            A.put(x, A.getOrDefault(x, 0) + 1);
        }
        for(int x: nums) {
            int cntx = A.getOrDefault(x, 0);
            if(cntx > 0) {
                int pre = B.getOrDefault(x - 1, 0);
                // 接在x - 1后面
                if(pre > 0) {
                    A.put(x, cntx - 1);
                    B.put(x - 1, pre - 1);
                    B.put(x, B.getOrDefault(x, 0) + 1);
                    // 新开一个
                } else {
                    int c1 = A.getOrDefault(x + 1, 0);
                    int c2 = A.getOrDefault(x + 2, 0);
                    if(c1 == 0 || c2 == 0 ) {
                        return false;
                    }
                    A.put(x, cntx - 1);
                    A.put(x + 1, c1 - 1);
                    A.put(x + 2, c2 - 1);
                    B.put(x + 2, B.getOrDefault(x + 2, 0) + 1);
                }
            }
        }
        return true;
    }
}
