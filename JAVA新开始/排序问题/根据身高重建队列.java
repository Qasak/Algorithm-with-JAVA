/*
输入:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

输出:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 
**/
// h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数
// 排序这个字典,使之位置符合h,k
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if(0 == people.length || 0 == people[0].length) {
            return new int[0][0];
        }
        // 高的人前面被插矮的人，其k仍是对的
        // 所以要先插高的人，再插矮的人
        // 按身高降序，k升序，k是排在这个人前面且身高大于或等于h的人数
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 若身高相等，按k升序
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        // 由于是降序的，此时list中所有人的身高>=当前的h
        // 
        for(int[] i : people) {
            list.add(i[1], i);
        }
        return list.toArray(new int[list.size()][2]);
    }
}