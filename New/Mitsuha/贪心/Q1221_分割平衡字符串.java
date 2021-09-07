class Solution {
    public int balancedStringSplit(String s) {
        int n = s.length();
        int cnt = 0, ans = 0;
        char[] cs = s.toCharArray();
        for(int i = 0; i < n; i++) {
            if(cs[i] == 'L') {
                cnt++;
            } else {
                cnt--;
            }
            if(cnt == 0) {
                ans++;
            }
        }
        return ans;
    }
}