package leetcode.SpringRecruit.DP;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/11 11:27
 */
public class Q1411_给Nx3网格涂色的方案数 {
    public int numOfWays(int n) {
        // abc: 012 021 102 120 201 210
        // aba: 010 020 101 121 202 212

        /*
            abc 012
            abc 120 201

            abc 012
            aba 101 121

            aba 010
            aba 101 121 202

            aba 010
            abc 102 201
        */
        int mod = (int) 1e9 + 7;
        long abc = 6;
        long aba = 6;
        for(int i = 1; i < n; i++) {
            long abc_ = (abc * 2 + aba * 2) % mod;
            long aba_ = (abc * 2 + aba * 3) % mod;
            abc = abc_;
            aba = aba_;
        }
        return (int) (abc + aba) % mod;
    }
}
