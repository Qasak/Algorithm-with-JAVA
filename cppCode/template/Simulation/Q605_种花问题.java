package leetcode.template.Simulation;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/10 0:03
 */
public class Q605_种花问题 {
    public boolean canPlaceFlowers(int[] flowerbed, int m) {
        int cnt = 0;
        int n = flowerbed.length;
        if(n == 1) {
            cnt = flowerbed[0] == 0 ? 1 : 0;
            return cnt >= m;
        }
        for(int i = 0; i < n; ) {
            if(flowerbed[i] == 1) {
                i += 2;
            } else {
                if(i == 0) {
                    if(flowerbed[1] == 0) {
                        flowerbed[i] = 1;
                        cnt++;
                    }
                    i += 2;
                } else if(i == n - 1) {
                    if(flowerbed[i - 1] == 0) {
                        cnt++;
                    }
                    i++;
                } else if(flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    cnt++;
                    flowerbed[i] = 1;
                    i += 2;
                } else {
                    i++;
                }
            }
        }
        return cnt >= m;
    }
}
