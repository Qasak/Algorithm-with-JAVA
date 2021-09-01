class Solution {
    public int numberOfUniqueGoodSubsequences(String binary) {
        char[] cs = new StringBuilder(binary).reverse().toString().toCharArray();
        int mod = (int) 1e9 + 7;
        int n = cs.length;
        int one = 0, zero = 0;
        boolean hasZero = false;
        for(int i = 0 ; i < n; i++) {
            if(cs[i] == '0') {
                zero = (zero + one + 1) % mod;
                hasZero = true;
            } else {
                one = (zero + one + 1) % mod;
            }
        }
        int ans = one;
        if(hasZero) {
            ans = (ans + 1) % mod;
        }
        return ans;
    }
}