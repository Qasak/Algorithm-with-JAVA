class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int n = intervals.length;
        int i = 0;
        ArrayList<int[]> ansList = new ArrayList<int[]>();
        while(i < n) {
            // 记录当前段的左右端点 
            int l = intervals[i][0];
            int r = intervals[i][1];
            int j = i + 1;
            // 从下一段开始，若下一段和当前段右端点有交集(下一段左端点<=当前段右端点，即 intervals[j][0] <= t)
            // 则应将这两段合并：当前段的右端点改为这两段右端点的最大值，继续比较下一段
            // 合并完成后，当前段右端点已经<下一段左端点(t < interval[j][0])
            // 将当前段加入结果集合
            // 更新起点为下一段(i = j)
            while(j < n && r >= intervals[j][0]) {
                r = Math.max(r, intervals[j][1]);
                j++;
            }
            ansList.add(new int[] {l, r});
            i = j;
        }
        return ansList.toArray(new int[ansList.size()][2]);
    }
}