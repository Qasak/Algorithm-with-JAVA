/**
给出一个区间的集合，请合并所有重叠的区间
 intervals = [[1,3],[2,6],[8,10],[15,18]]
 [[1,6],[8,10],[15,18]]
*/



class Solution {
    public int[][] merge(int[][] intervals) {
		// 1.给出的区间可能是无序的，需要先排序
		// 以下按左端点从小到大排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int n = intervals.length;
        int i = 0;
		// 2. 将合并的结果放入list：扫描每一个线段，记录其左右端点l,r ；
		// 看当前的右端点是否和下一段的左端点有相交(>=)，r不断向右扩展至小于下一段的左端点，此时j指向下一个应扩展的段 
        ArrayList<int[]> ansList = new ArrayList<int[]>();
        while(i < n) {
            // 记录当前段的左右端点 
            int l = intervals[i][0];
            int r = intervals[i][1];
			// 从下一段开始
            int j = i + 1;
			// >=不满足时，说明r < 下一段的左端点，不再扩展
            while(j < n && r >= intervals[j][0]) {
                r = Math.max(r, intervals[j][1]);
                j++;
            }
            ansList.add(new int[] {l, r});
            i = j;
        }
		// List.toArray: 返回一个包含此列表中所有元素的数组
		// 入参T: 返回的数组类型
        return ansList.toArray(new int[ansList.size()][2]);
    }
}