class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0, kk = k;
        for(int c : chalk) {
            sum += c;
        }
        kk = kk - (kk / sum) * sum;
        int i = 0;
        while(kk >= chalk[i]) {
            kk -= chalk[i++];
        }   
        return i;
    }
}