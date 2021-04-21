class Solution {
public:
    int myAtoi(string str) {
        long ans=0;
        int i=0;
        while(str[i]==' ') i++;
        int sign=1;
        if(str[i]=='-'||str[i]=='+') {
            if(str[i]=='-')
                sign=-1;
            i++;
        }

        int n=str.size();
        while(str[i]>='0' && str[i]<='9' && i<n) {
            ans=ans*10+str[i]-'0';
            if(sign==1 && ans>INT_MAX)
                return INT_MAX;
            if(sign==-1 && -ans<INT_MIN)
                return INT_MIN;
            i++;
        }
        return ans*sign;
            
    }
};