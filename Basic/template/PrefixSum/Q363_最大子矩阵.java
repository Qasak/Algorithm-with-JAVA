package leetcode.template.PrefixSum;

import java.util.TreeSet;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/11 16:02
 */
public class Q363_最大子矩阵 {
    int[][] pre;
    // O(m ^ 2 n logn)
    public int maxSumSubmatrix(int[][] matrix, int k) {
        /*
        [[1,0,1],
        [0,-2,3]]
        */
        // <= k
        int n = matrix.length;
        int m = matrix[0].length;
        pre = new int[n + 1][m + 1];
        // pre[n][m] : [(0, 0), (n, m)) 的矩阵的元素和
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                pre[i + 1][j + 1] = pre[i][j + 1] + pre[i + 1][j] + matrix[i][j] - pre[i][j];
            }
        }
        int ans = Integer.MIN_VALUE;
        // 行数远远大于列数
        for(int y1 = 0; y1 < m; y1++) {
            for(int y2 = y1; y2 < m; y2++) {
                // 求不大于k的最大值
                // x + k == sum
                // x = sum - k
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                for(int x2 = 0; x2 < n; x2++) {
                    int target = 0;
                    int sum = sumRange(0, y1, x2, y2);
                    // ceiling == lowerBound
                    if(set.ceiling(sum - k) != null) {
                        target = set.ceiling(sum - k);
                        ans = Math.max(ans, sum - target);
                    }
                    set.add(sum);
                }
            }
        }
        return ans;
    }
    private int sumRange(int x1, int y1, int x2, int y2) {
        int sum = pre[x2 + 1][y2 + 1] - pre[x2 + 1][y1] - pre[x1][y2 + 1] + pre[x1][y1];
        return sum;
    }

    //
    public int maxSumSubmatrix1(int[][] matrix, int k) {
        int n=matrix.length;
        int m=matrix[0].length;
        int max=Integer.MIN_VALUE;
        for(int l=0;l<m;l++){
            int[] rowSum=new int[n];
            for(int r=l;r<m;r++){
                for(int i=0;i<n;i++){
                    rowSum[i]+=matrix[i][r];
                }
                max=Math.max(max,dp(rowSum,k));
            }
        }
        return max;

    }
    // 返回rowSum中<=k的最大值
    int dp(int[]rowSum,int k){
        int rowsum=rowSum[0];
        int rowMax=rowsum;
        int res=Integer.MIN_VALUE;
        for(int i=1;i<rowSum.length;i++){
            if(rowsum>0){
                rowsum+=rowSum[i];
            }else{
                rowsum=rowSum[i];
            }
            rowMax=Math.max(rowsum,rowMax);
        }
        if(rowMax<=k){
            return rowMax;
        }
        int max=Integer.MIN_VALUE;
        for(int l=0;l<rowSum.length;l++){
            int sum=0;
            for(int r=l;r<rowSum.length;r++){
                sum+=rowSum[r];
                if(sum>max&&sum<=k) {
                    max=sum;
                }
                if(max==k) {
                    return max;
                }
            }
        }
        return max;
    }

    //求不超过k的最大子数组之和
    public int maxSubArray(int[] nums,int k) {
        int maxValue = nums[0];
        int dp = 0;
        for(int i=0; i<nums.length; i++) {
            if(dp > 0) {
                dp = dp + nums[i];
            }else {
                dp = nums[i];
            }
            if(dp > maxValue) {
                maxValue = dp;
            }
        }
        if(maxValue <= k) return maxValue;
        maxValue = -Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++) {
            int sum = 0;
            for(int j=i; j<nums.length; j++) {
                sum += nums[j];
                if(sum > maxValue && sum <= k) {
                    maxValue = sum;
                }
            }
        }
        return maxValue;
    }
}
