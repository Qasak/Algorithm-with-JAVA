/**
给出一个无重叠的 ，按照区间起始端点排序的区间列表
intervals = [[1,3],[6,9]], newInterval = [2,5]
[[1,5],[6,9]]
*/

// 注意，题目输入的段是有序的

// 1.因为新段可能引起合并，所以需要不断更新新段的 l,r
// 2.找到合适的位置插入已合并一系列段后的新.新段
// 3. 合适的位置，插入新段：
	// 假设这样一种情况：新段不与任何一个段合并=>新段不与任何一个段相交
	// 由于从左向右扫，若r < lc 则完全可以插入(前面的段已判定过，未与新段相交，换句话说，有足够大的空隙够新段插入)。
	// 若l > rc,此时插入的话，有可能空隙不够(虽然不会与当前段相交，但可能与后面段相交)
	
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int l = newInterval[0];
        int r = newInterval[1];
        ArrayList<int[]> res = new ArrayList<int[]>();
        int n = intervals.length;
        // 检测是否应插入在最后(扫完了还没有严格大于新段的段(此时新段是(可能)合并后的段)，则新段应放在最后面)
        boolean placed = false;
        for(int[] interval : intervals) {
			// 没有交集
			// 1.大：不确定，加入当前，继续
			if(l > interval[1]) {
                res.add(interval);
			
			// 2.小：空隙够，先插合并后新段，再插当前
			// 再往后走，都比它大了(有序)，为了只插入一次：引入一个标志
            } else if(r < interval[0]) {
                if(!placed) {
                    placed = true;
                    res.add(new int[] {l, r});
                }
                res.add(interval);
			// 有交集，更新新段
            } else {
                l = Math.min(l, interval[0]);
                r = Math.max(r, interval[1]);
            }
        }
		// 新段并没有被插入：说明1. l > intervals[n-1][1]（应插在最后） 或 最后一段被合并了，插入新段和最后段合并的段
			//反正都是插在最后
        if(!placed) {
            res.add(new int[] {l, r});
        }
        return res.toArray(new int[res.size()][2]);
    }
}