package leetcode.SpringRecruit.Hash;

import javax.swing.text.html.HTMLDocument;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/12 23:30
 */
public class Q523_数组中的k_diff数对 {
    public int findPairs(int[] nums, int k) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();

        while(it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            if(k == 0) {
                if(entry.getValue() > 1) {
                    ans++;
                }
            } else {
                if(map.containsKey(entry.getKey() + k)) {
                    ans++;
                }
                if(map.containsKey(entry.getKey() - k)) {
                    ans++;
                }
            }
            it.remove();
        }
        return ans;
    }

    // 排序+去重
    public int findPairs1(int[] nums, int k) {
        Arrays.sort(nums);
        int cnt = 0;
        int n = nums.length;
        int pre = 0x3f3f3f3f;
        int start = 0;
        // 1 1 3 4 5
        for(int i = 1; i < n; i++) {
            if(start < i && nums[i] != pre && nums[i] - nums[start] == k) {
                cnt++;
                pre = nums[i];
            } else if(nums[i] - nums[start] > k) {
                start++;
                i--;
            }
        }
        return cnt;
    }
}
