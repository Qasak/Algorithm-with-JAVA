class Solution {
public:
    int reverse(int x) {
        int ans = 0;
        int t;
        while(x!=0)
        {
            t=x%10;
            x=x/10;
            if(ans>INT_MAX/10 || (ans==INT_MAX/10 && t>INT_MAX%10)) return 0;
            if(ans<INT_MIN/10 || (ans==INT_MIN/10 && t<INT_MIN%10)) return 0;
            ans = ans*10+t;
        }
        return ans;
    }
};
class Solution {
public:
    int reverse(int x) {
        long ans=0;
        while(x)
        {
            ans=ans*10+x%10;
            x/=10;
        }
        if(ans>INT_MAX||ans<INT_MIN)
            return 0;
        return ans;

    }
};