class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        int n = Profits.length;
        // 每次找<= W的项目中利润最大的
        int[][] t = new int[n][2];
        for(int i = 0; i < n; i++) {
            t[i][0] = Profits[i];
            t[i][1] = Capital[i];
        }
        Map<Integer, Integer> f = new HashMap<>();
        Arrays.sort(t, (a, b) -> (a[1] - b[1]));
        // 满足W的项目, 按利润高低排序
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> (b - a));
        int i = 0;
        while(k-- > 0) {
            while(i < n && t[i][1] <= W) {
                q.offer(t[i++][0]);
            }
            if(q.isEmpty()) {
                break;
            }
            // 每次加最大的
            W += q.poll();
        }
        return W;
    }
}