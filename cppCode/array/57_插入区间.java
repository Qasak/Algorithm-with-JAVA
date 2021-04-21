class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int l = newInterval[0];
        int r = newInterval[1];
        ArrayList<int[]> res = new ArrayList<int[]>();
        int n = intervals.length;
        // 检测是否应插入在最后(扫完了还没有严格大于新段的段(此时新段是(可能)合并后的段)，则新段应放在最后面)
        boolean placed = false;
        for(int[] interval : intervals) {
            // 如果新段严格在当前段左边，则应该先插入新段，再插入当前段
            // 如果新段严格在当前段右边，则应该先插入当前段，继续循环，直到找到满足上面条件的段
            // 否则，有相交情况，更新l,r
            if(r < interval[0]) {
                if(!placed) {
                    placed = true;
                    res.add(new int[] {l, r});
                }
                res.add(interval);
            } else if(l > interval[1]) {
                res.add(interval);
            } else {
                l = Math.min(l, interval[0]);
                r = Math.max(r, interval[1]);
            }
        }
        if(!placed) {
            res.add(new int[] {l, r});
        }
        int[][] ans = new int[res.size()][2];
        for(int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}