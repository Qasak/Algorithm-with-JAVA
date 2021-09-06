package leetcode.contest.Week257;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/9/6 14:12
 */
public class Q_访问完所有房间的第一天 {
    // 模拟：超时
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int n = nextVisit.length;
        int mod = (int) 1e9 + 7;
        int ans = 0;
        int[] cnt = new int[n];
        int all = 0;
        boolean[] vis = new boolean[n];
        int i = 0;
        while(all != n) {
            System.out.println(i);
            if(!vis[i]) {
                all++;
            }
            cnt[i]++;
            vis[i] = true;
            if(cnt[i] % 2 == 0) {
                i = (i + 1) % n;
            } else {
                i = nextVisit[i];
            }
            ans += 1;
            ans = ans % mod;
        }
        return ans - 1;
    }
}
