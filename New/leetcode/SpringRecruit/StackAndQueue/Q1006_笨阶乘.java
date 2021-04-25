package leetcode.SpringRecruit.StackAndQueue;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/1 12:50
 */
public class Q1006_笨阶乘 {
    public int clumsy(int N) {
        int ans = 0;
        if(N >= 4) {
            return N * (N - 1) / (N - 2) + (N - 3) + dfs(N - 4);
        } else if(N == 3) {
            return 6;
        } else if(N == 2) {
            return 2;
        } else {
            return 1;
        }
    }
    public int dfs(int N) {
        if(N <= 0) {
            return 0;
        }
        if(N >= 3) {
            return -N * (N - 1) / (N - 2) + (N - 3) + dfs(N - 4);
        } else if(N == 2) {
            return -2;
        } else {
            return -1;
        }
    }
    // 栈

}
