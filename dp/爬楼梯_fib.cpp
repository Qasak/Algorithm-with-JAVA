class Solution {
public:
    int fib(int n) {
        int x=1;
        int y=1;
        int z=1;
        for(int i=2;i<=n;i++) {
            z=x+y;
            x=y;
            y=z;
        }
        return z;
    }
    int climbStairs(int n) {
        return fib(n);
    }
};