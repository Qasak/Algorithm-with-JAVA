package leetcode.contest.Rating1800.模拟;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/19 10:07
 */
public class Q755_倒水 {
    int[] tmp;
    public int[] pourWater(int[] heights, int V, int K) {
        int n = heights.length;
        tmp = new int[n + 2];
        tmp[0] = 0x3f3f3f3f;
        tmp[n + 1] = 0x3f3f3f3f;
        for(int i = 1; i < n + 1; i++) {
            tmp[i] = heights[i - 1];
        }
        while(V > 0) {
            int min = tmp[K + 1];
            int idx = K + 1;
            for(int i = K + 1; i >= 0; i--) {
                if(tmp[i] > min) {
                    break;
                } else {
                    if(tmp[i] < min) {
                        idx = i;
                    }
                    min = tmp[i];
                }
            }
            if(min < tmp[K + 1]) {
                if(min < tmp[K]) {
                    tmp[idx]++;
                } else {
                    tmp[K]++;
                }
                V--;
                continue;
            }
            min = tmp[K + 1];
            idx = K + 1;
            for(int i = K + 1; i < n + 2; i++) {
                if(tmp[i] > min) {
                    break;
                } else {
                    if(tmp[i] < min) {
                        idx = i;
                    }
                    min = tmp[i];
                }
            }
            if(min < tmp[K + 1]) {
                tmp[idx]++;
            } else {
                tmp[K + 1]++;
            }
            V--;
        }
        int[] ans = new int[n];
        for(int i = 1; i < n + 1; i++) {
            ans[i - 1] = tmp[i];
        }
        return ans;
    }
}
