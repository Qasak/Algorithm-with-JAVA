package leetcode.contest.Rating1600.曼哈顿距离;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/22 20:22
 */
public class Q789_逃脱阻碍者 {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int tx = target[0], ty = target[1];
        int d = Math.abs(tx) + Math.abs(ty);
        for(int[] g : ghosts) {
            int dd = Math.abs(tx - g[0]) + Math.abs(ty - g[1]);
            if(dd <= d) {
                return false;
            }
        }
        return true;
    }

}
