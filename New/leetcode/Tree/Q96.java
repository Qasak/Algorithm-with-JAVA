package leetcode.template.Tree;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/19 16:25
 */
public class Q96 {
    // 以 1 ... n 为节点组成的二叉搜索树有多少种？
    public int numTrees(int n) {
        // 假设 n 个节点存在二叉排序树的个数是 G (n)，令 f(i) 为以 i 为根的二叉搜索树的个数，则
        // G(n) = f(1) + f(2) + ... + f(n)

        // f(i) = G(i - 1) * G(n - i)
        // G(0) = 1
        // G(n) = G(0) * G(n - 1) + G(1) * G(n - 2) + ... + G(n - 1) * G(0)
        int[] G = new int[n + 1];
        // 当序列长度为 1（只有根）或为 0（空树）时，只有一种情况
        G[0] = 1;
        G[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
    public int numTrees1(int n) {
        // 提示：我们在这里需要用 long 类型防止计算过程中的溢出
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }

}
