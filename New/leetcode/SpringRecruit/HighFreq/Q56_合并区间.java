package leetcode.HighFreq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/24 22:12
 */
public class Q56_合并区间 {
    public int[][] merge(int[][] intervals) {
        // 按x1排序就直接取r = b[1]
        // 按x0第一个排序 需要取 r = Math.max(r, b[1])


        // 如果按x1排序： 举一个反例： [[1,4],[0,4]]
        // 此时l = Math.min(l, b[0])
        // 另一个反例
        // [[2,3],[4,5],[6,7],[8,9],[1,10]]

        // 输出 [[2,3],[4,5],[6,7],[1,10]]
        // 应输出[[1,10]]
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();
        int n = intervals.length;
        int i = 0;
        while(i < n) {
            int[] a = intervals[i];
            int j = i + 1;
            int l = a[0];
            int r = a[1];
            if(j == n) {
                ans.add(new int[]{l, r});
            }
            while(j < n) {
                int[] b = intervals[j];
                if(b[0] <= r) {
                    r = Math.max(r, b[1]);
                    j++;
                    if(j == n) {
                        ans.add(new int[]{l, r});
                    }
                } else {
                    ans.add(new int[]{l, r});
                    break;
                }
            }
            i = j;
        }
        int[][] res = new int[ans.size()][2];
        for(int k = 0; k < ans.size(); k++) {
            res[k][0] = ans.get(k)[0];
            res[k][1] = ans.get(k)[1];
        }
        return res;
    }

    // 不错的代码
    public int[][] merge1(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals.length == 0) {
            return res.toArray(new int[0][]);
        }
        // 对起点终点进行排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int i = 0;
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            // 如果有重叠，循环判断哪个起点满足条件
            while (i < intervals.length - 1 && intervals[i + 1][0] <= right) {
                i++;
                right = Math.max(right, intervals[i][1]);
            }
            // 将现在的区间放进res里面
            res.add(new int[]{left, right});
            // 接着判断下一个区间
            i++;
        }
        return res.toArray(new int[0][]);
    }
}
