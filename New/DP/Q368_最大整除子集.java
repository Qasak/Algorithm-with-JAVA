package leetcode.SpringRecruit.DP;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/23 10:35
 */
public class Q368_最大整除子集 {
    // 记忆化 不会
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();

        for(int j = 0; j < n; j++) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(nums[j]);
            // 2 12 18
            for(int i = j + 1; i < n; i++) {
                int a = tmp.get(tmp.size() - 1);
                if((nums[i] % a == 0)) {
                    tmp.add(nums[i]);
                }
            }
            System.out.println(tmp);
            if(tmp.size() > ans.size()) {
                ans = new ArrayList<>(tmp);
            }
        }
        return ans;
    }
    public static int[] getArr(int n) {
        int[] ans = new int[n];
        int idx = 0;
        for(int i = 1; i <= n; i++) {
            ans[idx++] = i;
        }
//        System.out.println(Arrays.toString(ans));
        return ans;
    }

    class Solution {
        int max = 0;
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        public List<Integer> largestDivisibleSubset(int[] nums) {
            int n = nums.length;

            Arrays.sort(nums);
            for(int i = 0;  i < n; i++) {
                map.put(nums[i], i);
            }
            dfs(nums, 0, new ArrayList<>());
            System.out.println(max);
            return ans;
        }
        public void dfs(int[] nums, int idx, List<Integer> path) {

            int n = nums.length;
            if(path.size() != 0) {
                if(n - map.get(path.get(0)) < max) {
                    return;
                }
            }
            System.out.println(path);

            if(idx == n) {
                if(path.size() > ans.size()) {
                    max = path.size();
                    ans = new ArrayList<>(path);
                }
                return;
            }

            if(path.size() == 0) {
                path.add(nums[idx]);
                dfs(nums, idx + 1, path);
                path.remove(path.size() - 1);

                dfs(nums, idx + 1, path);
            } else {
                int a = path.get(path.size() - 1);
                if(nums[idx] % a == 0) {
                    path.add(nums[idx]);
                    dfs(nums, idx + 1, path);
                    path.remove(path.size() - 1);

                }
                dfs(nums, idx + 1, path);
            }
        }
    }
    public List<Integer> largestDivisibleSubset1(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        // dp[i] : 选择nums[i]时的最大长度
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        int maxVal = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if((nums[i] % nums[j]) == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if(dp[i] > maxLen) {
                maxLen = dp[i];
                maxVal = nums[i];
            }
        }
        if(maxLen == 1) {
            ans.add(nums[0]);
            return ans;
        }
        for(int i = n - 1; i >= 0 && maxVal > 0; i--) {
            if(dp[i] == maxLen && (maxVal % nums[i]) == 0) {
                ans.add(nums[i]);
                maxLen--;
                maxVal = nums[i];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        // [9,18,90,180,360,720]
        // 9, 18, 54, 108, 540
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27};
//        int[] nums = new int[]{1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,131072,262144,524288,1048576,2097152,4194304,8388608,16777216,33554432,67108864,134217728,268435456,536870912,1073741824};
        Q368_最大整除子集 q = new Q368_最大整除子集();
        Q368_最大整除子集.Solution s =  q.new Solution();
//        s.largestDivisibleSubset(nums);
//        int[] nums = getArr(1000);
//        int[] nums = new int[]{9,75,12,18,90,4,36,8,28,2};
        System.out.println(s.largestDivisibleSubset(nums));
    }
}

