package leetcode.contest.NiceProblem.众数技巧;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/9 8:48
 */
public class Q229_求众数2 {
    // 所有超过 n / 3 的数
    // 注意 只可能有两个候选
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int cnt1 = 0, cnt2 = 0;
        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
        for(int i : nums) {
            if(i == a) {
                cnt1++;
                continue;
            }
            if(i == b) {
                cnt2++;
                continue;
            }
            if(cnt1 == 0) {
                a = i;
                cnt1++;
                continue;
            }
            if(cnt2 == 0) {
                b = i;
                cnt2++;
                continue;
            }

            cnt1--; cnt2--;
        }
        // System.out.println(a + " " + b);
        List<Integer> ans = new ArrayList<>();
        cnt1 = 0;
        cnt2 = 0;
        for(int i : nums) {
            if(i == a) {
                cnt1++;
            }
            if(i == b) {
                cnt2++;
            }
        }
        if(cnt1 > n / 3) {
            ans.add(a);
        }
        if(cnt2 > n / 3) {
            ans.add(b);
        }
        return ans;
    }
}
