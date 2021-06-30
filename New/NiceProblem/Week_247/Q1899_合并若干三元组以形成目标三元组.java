package leetcode.contest.Week_247;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/30 17:25
 */
public class Q1899_合并若干三元组以形成目标三元组 {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        // int a = target[0], b = target[1], c = target[2];
        int cnt = 0;
        int n = triplets.length;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < n; j++) {
                if(triplets[j][0] > target[0] || triplets[j][1] > target[1] || triplets[j][2] > target[2]) {
                    continue;
                }
                if(triplets[j][i] == target[i]) {
                    cnt++;
                    break;
                }
            }
        }
        return cnt == 3;
    }
}
