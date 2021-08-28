class Solution {
    public int maximalRectangle(char[][] matrix) {
        int ans = 0;
        // 单调递增栈
        int n = matrix.length;
        if(n == 0) {
            return 0;
        }
        int m = matrix[0].length;
        // 高
        int[] f = new int[m];
        int[] len = new int[m];
        f[0] = matrix[0][0] - '0';
        len[0] = f[0];
        ans = len[0];
        for(int i = 1; i < m; i++) {
            f[i] = matrix[0][i] - '0';
            len[i] = f[i] == 1 ? len[i - 1] + 1 : 0;
            ans = Math.max(ans, len[i]);
        }
        for(int i = 1; i < n; i++) {
            int[] g = new int[m + 2];
            Deque<Integer> stk = new LinkedList<>();
            stk.push(-1);
            for(int k = 0; k < m; k++) {
                if(matrix[i][k] == '1') {
                    g[k] = f[k] + 1;
                }
                while(stk.size() != 1 && g[k] < g[stk.peek()]) {
                    int h = g[stk.pop()];
                    int r = k;
                    int l = stk.peek();
                    ans = Math.max(ans, h * (r - l - 1));
                }
                stk.push(k);
            }
            while(stk.size() != 1 ) {
                int h = g[stk.pop()];
                int r = m;
                int l = stk.peek();
                ans = Math.max(ans, h * (r - l - 1));
            }
            f = g;
        }
        return ans;
    }
}