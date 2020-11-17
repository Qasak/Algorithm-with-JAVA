class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        ArrayList<int[]> ans = new ArrayList<>();
        Deque<int[]> deque = new LinkedList<>();
        int[][] diff = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        boolean[][] vis = new boolean[R][C];
        vis[r0][c0] = true;
        ans.add(new int[] {r0, c0});
        deque.offer(new int[] {r0, c0});
        while(!deque.isEmpty()) {
            int[] tmp = deque.poll();
            for(int[] k: diff) {
                int x = tmp[0] + k[0];
                int y = tmp[1] + k[1];
                if(x >= 0 && x < R && y >= 0 && y < C && !vis[x][y]) {
                    vis[x][y] = true;
                    int[] p = new int[]{tmp[0] + k[0], tmp[1] + k[1]};
                    ans.add(p);
                    deque.offer(p);
                }
            }
        }
        return ans.toArray(new int[0][2]);
    }
}