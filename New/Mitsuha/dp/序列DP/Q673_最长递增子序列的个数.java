// 定义 \textit{dp}[i]dp[i] 表示以 \textit{nums}[i]nums[i] 结尾的最长上升子序列的长度，
// \textit{cnt}[i]cnt[i] 表示以 \textit{nums}[i]nums[i] 结尾的最长上升子序列的个数。
// 设 \textit{nums}nums 的最长上升子序列的长度为 \textit{maxLen}maxLen，
// 那么答案为所有满足 \textit{dp}[i]=\textit{maxLen}dp[i]=maxLen 的 ii 所对应的 \textit{cnt}[i]cnt[i] 之和。
class Solution {
    int ans = 0;
    public int findNumberOfLIS(int[] nums) {
        return LCS(nums);
    }
    int LCS(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        int[] cnt = new int[n];
        int maxLen = 0;
        int ans = 0;
        Arrays.fill(f, 1);
        Arrays.fill(cnt, 1);
        for(int i = 0; i < n; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(nums[i] > nums[j]) {
                    // 说明当前不是最长
                    // 刷新成最长递增子序列的个数
                    if(f[j] + 1 > f[i]) {
                        f[i] = f[j] + 1;
                        cnt[i] = cnt[j];
                    } else if(f[j] + 1 == f[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            if(f[i] > maxLen) {
                maxLen = f[i];
                ans = cnt[i];
            } else if(f[i] == maxLen) {
                ans += cnt[i];
            }
        }
        return ans;
    }
}