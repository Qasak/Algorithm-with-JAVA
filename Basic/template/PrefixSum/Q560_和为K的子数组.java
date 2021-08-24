package leetcode.template.PrefixSum;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/5/29 12:24
 */
public class Q560_和为K的子数组 {
    // 不用枚举左右边界，仅枚举有边界，通过Map找到右边边界对应的左边界即可
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] pre = new int[n + 1];
        for(int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans += map.getOrDefault(pre[i + 1] - k, 0);
            map.put(pre[i + 1], map.getOrDefault(pre[i + 1], 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        BigDecimal f = new BigDecimal("123.456789");
        BigDecimal g = new BigDecimal("123.456789");
        System.out.println(f.add(g));
    }
}
