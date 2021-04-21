package leetcode.template.queue;

import leetcode.contest.WeekContest_218.D;

import java.util.BitSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/11 10:00
 *
 * 输入："RD"
 * 输出："Radiant"
 *
 * 输入："RDD"
 * 输出："Dire"
 *
 */
public class _649 {
    /**
     * RRRDDD
     * RD
     * RDRD
     * RDD
     * RDRDRD
     * RDDDRR -> RDD -> D
     *
     * RD -> R
     * DR -> D
     * RDD -> RD -> D
     * DDR -> DD
     *
     * RRDDD -> RRD -> RR
     * 使用两个队列，循环添加
     * */
    static String R = "Radiant";
    static String D = "Dire";
    public static String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(senate.charAt(i) == 'R') {
                r.offer(i);
            } else {
                d.offer(i);
            }
        }
        while(!r.isEmpty() && !d.isEmpty()) {
            // "RRRDDDD"
            int a = r.poll(), b = d.poll();
            if(a < b) {
                r.offer(a + n);
            } else {
                d.offer(b + n);
            }
        }
        return r.isEmpty() ? D : R;
    }
    public String predictPartyVictory1(String senate) {
        int rr = 0;
        int dd = 0;
        int r = 0;
        int d = 0;
        int n = senate.length();
        for (int j = 0; j < n; j++) {
            if (senate.charAt(j) == 'R') {
                rr++;
            } else {
                dd++;
            }
        }
        BitSet bs = new BitSet(n);
        int i = 0;
        // // "RRRDDDD"
        while (rr != 0 && dd != 0) {
            if (!bs.get(i)) {
                if (senate.charAt(i) == 'R') {
                    if (d > 0) {
                        --d;
                        bs.set(i);
                        --rr;
                    } else {
                        ++r;
                    }
                } else {
                    if (r > 0) {
                        --r;
                        bs.set(i);
                        --dd;
                    } else {
                        ++d;
                    }
                }
            }
            i = (i + 1) % senate.length();
        }
        return rr > 0 ? "Radiant" : "Dire";
    }
    public String predictPartyVictory3(String senate) {
        char[] cs = senate.toCharArray();
        int rr = 0, dd = 0;
        int n = cs.length;
        for(int i = 0; i < n; i++) {
            if(cs[i] == 'R') {
                rr++;
            } else {
                dd++;
            }
        }
        int i = 0;
        while(rr !=0 && dd != 0) {
            if (cs[i] == 'R') {
                int j = i;
                // 想要下一个D的下标，将其消除
                // 两个队列，比下标大小，大的消除，小的保留 + n，再放回原队列，进入循环
                while (j < cs.length - 1 && cs[j++] != 'D') {

                }
                cs[j] = '_';
                dd--;
            } else {
                int j = i;
                while (j < cs.length - 1 && cs[j++] != 'R') {

                }
                cs[j] = '_';
                rr--;
            }
            if (rr == 0) {
                return D;
            }
            if (dd == 0) {
                return R;
            }
        }
        return rr == 0 ? D : R;
    }
    public static void main(String[] args) {
        String s = "RRRDDDD";
        System.out.println(predictPartyVictory(s));
    }
}
