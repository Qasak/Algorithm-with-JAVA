class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        int[] d = new int[n];
        for(int[] t : bookings) {
            int l = t[0] - 1, r = t[1], w = t[2];
            d[l] += w;
            if(r < n) {
                d[r] -= w;
            }
        }
        ans[0] = d[0];
        for(int i = 1; i < n; i++) {
            ans[i] = d[i] + ans[i - 1];
        }
        return ans;
    }
}