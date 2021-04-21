package leetcode.template.Window;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/20 9:30
 */
public class Q697 {
    public int findShortestSubArray(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[50000];
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            cnt[nums[i]]++;
            set.add(nums[i]);
        }
        int f = Arrays.stream(cnt).max().getAsInt();
        List<Integer> tmp = new ArrayList<>();
        for(int i : set) {
            if(cnt[i] == f) {
                tmp.add(i);
            }
        }
        int ans = 50000;
        for(int d : tmp) {
            int l = 0, r = 0;
            for(int i = 0; i < n; i++) {
                if(nums[i] == d) {
                    l = i;
                    break;
                }
            }
            for(int i = n - 1; i >= 0; i--) {
                if(nums[i] == d) {
                    r = i;
                    break;
                }
            }
            ans = Math.min(ans, r - l + 1);
        }
        return ans;
    }
    public int findShortestSubArray1(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], v -> new ArrayList<>()).add(i);
        }
        int d = 0, ans = 50000;
        for(int i : map.keySet()) {
            d = Math.max(d, map.get(i).size());
        }
        // 保存最大的度的左右端点，找到最小值
        for(int i : map.keySet()) {
            if(d == map.get(i).size()) {
                List<Integer> list = map.get(i);
                int r = list.get(list.size() - 1), l = list.get(0);
                ans = Math.min(ans, r - l + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
    }
}
