class Solution {
    public int[][] kClosest(int[][] points, int K) {
        Queue<Pair<int[], Integer>> pq = new PriorityQueue<>(new Comparator<Pair<int[], Integer>>() {
            @Override
            public int compare(Pair<int[], Integer> o1, Pair<int[], Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        ArrayList<int[]> ans = new ArrayList<>();
        for(int[] p : points) {
            pq.add(new Pair<>(p, p[0] * p[0] + p[1] * p[1]));
        }
        while(K-- > 0) {
            ans.add(pq.peek().getKey());
            pq.poll();
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}
