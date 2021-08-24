package leetcode.template.PrefixSum;

import java.util.Random;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/5/19 18:20
 */
public class Q1738_找出第k大的异或坐标值 {
    class Solution {
        //   快速选择重复元素较多时会导致效率下降，应采用三路划分
        public int kthLargestValue(int[][] matrix, int k) {
            int n = matrix.length;
            int m = matrix[0].length;
            int[][] pre = new int[n + 1][m + 1];
            int[] tmp = new int[n * m];
            // 只计算当前行的前缀和
            int idx = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    pre[i + 1][j + 1] = matrix[i][j] ^ pre[i][j] ^ pre[i + 1][j] ^ pre[i][j + 1];
                    tmp[idx++] = pre[i + 1][j + 1];
                }
            }
            quickSelect(tmp, 0, n * m - 1, k);
            return tmp[m * n - 1 - k + 1];
        }
        // 从大到小，下标 k - 1
        private void quickSelect(int[] tmp, int l, int r, int k) {
            // System.out.println(Arrays.toString(tmp));
            if(l >= r) {
                return;
            }
            int idx = tmp.length - 1 - k + 1;
            int p = partition(tmp, l, r);
            if(p == idx) {
                return;
            }
            if(p < idx) {
                quickSelect(tmp, p + 1, r, k);
            } else {
                quickSelect(tmp, l, p - 1, k);
            }
        }
        private int partition(int[] tmp, int l, int r) {
            // Random rand = new Random();
            // swap(tmp, l + rand.nextInt(r - l + 1), r);
            int i = l - 1;
            for(int j = l; j < r; j++) {
                if(tmp[j] < tmp[r]) {
                    swap(tmp, ++i, j);
                }
            }
            swap(tmp, ++i, r);
            return i;
        }
        private void swap(int[] tmp, int i, int j) {
            int t = tmp[i];
            tmp[i] = tmp[j];
            tmp[j] = t;
        }
    }


    // 三路划分
    class Solution1 {
        Random rand = new Random();
        public int kthLargestValue(int[][] matrix, int k) {
            int n = matrix.length;
            int m = matrix[0].length;
            int[][] pre = new int[n + 1][m + 1];
            int[] tmp = new int[n * m];
            int idx = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    pre[i + 1][j + 1] = matrix[i][j] ^ pre[i][j] ^ pre[i + 1][j] ^ pre[i][j + 1];
                    tmp[idx++] = pre[i + 1][j + 1];
                }
            }
            quickSelect(tmp, 0, n * m - 1, k - 1);
            return tmp[k - 1];
        }

        // 从大到小，下标 k - 1
        private void quickSelect(int[] results, int l, int r, int idx) {
            if (l == r) {
                return;
            }
            int[] p = partition(results, l, r);
            if(idx <= p[0] - 1) {
                quickSelect(results, l, p[0] - 1, idx);
            } else if(idx >= p[1] + 1) {
                quickSelect(results, p[0] + 1, r, idx);
            }
        }
        private int[] partition(int[] results, int l, int r) {
            swap(results, l + rand.nextInt(r - l + 1), r);
            int i = l - 1;
            int k = r;
            int j = l;
            while(j < k) {
                if(results[j] > results[r]) {
                    swap(results, ++i, j++);
                } else if(results[j] < results[r]) {
                    swap(results, --k, j);
                } else {
                    j++;
                }
            }
            swap(results, j, r);
            return new int[]{i + 1, j};
        }
        private void swap(int[] tmp, int i, int k) {
            int t = tmp[i];
            tmp[i] = tmp[k];
            tmp[k] = t;
        }
    }
}
