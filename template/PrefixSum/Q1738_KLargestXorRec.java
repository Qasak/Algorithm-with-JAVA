package leetcode.template.PrefixSum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/25 15:35
 */
public class Q1738_KLargestXorRec {
    public int kthLargestValue(int[][] matrix, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] pre = new int[n + 1][m + 1];

        // [[10,9,5],
        // [2,0,4],
        // [1,0,9],
        // [3,4,8]]

        // pre[i + 1][j + 1] : 第i行第j列之前的前缀和
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                pre[i + 1][j + 1] = matrix[i][j] ^ pre[i + 1][j];
            }
        }
        for(int j = 0; j < m; j++) {
            for(int i = 0; i < n; i++) {
                pre[i + 1][j + 1] = pre[i + 1][j + 1] ^ pre[i][j + 1];
                q.add(pre[i + 1][j + 1]);
            }
        }
        int ans = 0;
        for(int i = 0; i < k; i++) {
            ans = q.poll();
        }
        return ans;
    }
    public int kthLargestValue1(int[][] matrix, int k) {
        List<Integer> list = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] pre = new int[n + 1][m + 1];
        // pre[i + 1][j + 1] : 第i行第j列之前的前缀和
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                pre[i + 1][j + 1] = matrix[i][j] ^ pre[i + 1][j];
            }
        }
        for(int j = 0; j < m; j++) {
            for(int i = 0; i < n; i++) {
                pre[i + 1][j + 1] = pre[i + 1][j + 1] ^ pre[i][j + 1];
                list.add(pre[i + 1][j + 1]);
            }
        }
        Collections.sort(list, (a, b) -> b - a);
        return list.get(k - 1);
    }
}
