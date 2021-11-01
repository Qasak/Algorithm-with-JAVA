class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int[] pre = new int[n + 1];
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, Integer.MIN_VALUE);
        Arrays.fill(right, Integer.MAX_VALUE);
        for(int i = 0; i < n; i++) {
            if(cs[i] == '|') {
                left[i] = i; right[i] = i;
            }
        }
        for(int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], left[i]);
        }
        for(int i = n - 2; i >= 0; i--) {
            right[i] = Math.min(right[i + 1], right[i]);
        }
        for(int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + (cs[i] == '|' ? 1 : 0);
        }
        int[] ans = new int[queries.length];
        int idx = 0;
        for(int[] q : queries) {
            int l = right[q[0]], r = left[q[1]];
            ans[idx++] = l <= r ? (r - l + 1 - (pre[r + 1] - pre[l])) : 0;
        }
        return ans;  

    }
}