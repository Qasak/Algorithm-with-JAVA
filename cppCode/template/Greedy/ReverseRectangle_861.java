package leetcode.template.Greedy;

import leetcode.template.MonotonousStack.RemoveKdigits_402;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/7 17:29
 * [0,0,1,1]
 * [1,0,1,0]
 * [1,1,0,0]
 *
 * 1 1 0 0
 * 1 0 1 0
 * 1 1 0 0
 *
 * 1 1 1 1
 * 1 0 0 1
 * 1 1 1 1
 *
 * 1 1 1 1
 * 1 0 0 1
 * 1 1 1 1
 *
 * [1,1,1,1]
 * [1,0,0,1]
 * [1,1,1,1]
 * 15 + 9 + 15 = 39
 *
 *
 *根据题意，能够知道一个重要的事实：
 * 给定一个翻转方案，则它们之间任意交换顺序后，得到的结果保持不变。
 * 因此，我们总可以先考虑所有的行翻转，再考虑所有的列翻转。
 */
public class ReverseRectangle_861 {
    // * [0,0,1,1]
    // * [1,0,1,0]
    // * [1,1,0,0]
    public static int matrixScore(int[][] A) {
        // m * n
        int m = A.length;
        int n = A[0].length;
        int ret = m * (1 << (n - 1));
        for(int j = 1; j < n; j++) {
            int cnt = 0;
            for(int i = 0; i < m; i++) {
                if(A[i][0] == 1) {
                    cnt += A[i][j];
                } else {
                    cnt += 1 - A[i][j];
                }
            }
            cnt = Math.max(cnt, m - cnt);
            ret += cnt * (1 << (n - 1 - j));
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        System.out.println(matrixScore(a));

//        int n = 3, m = 4;
//        for(int i = 0; i < n; i++) {
//            int ans = 0;
//            for(int j = 0; j < m; j++) {
//                ans = (ans | (a[i][m - 1 - j] << j));
//            }
//            System.out.println(ans);
//        }
    }
}
