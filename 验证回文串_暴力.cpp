class Solution {
public:
    bool isPalindrome(string s) {
        if(s.empty()) 
            return true;
        int n=s.size()+1;
        char ss[n];
        memset(ss,0,sizeof(ss));
        int m=0;
        for (int i = 0; i < n;)
        {
            if(65<=s[i]&&s[i]<=90) {
                ss[m++]=s[i++]+32;
            }

            else if((97<=s[i]&&s[i]<=122)||(48<=s[i]&&s[i]<=57))
                ss[m++]=s[i++];
            else
                i++;

        }
        int i=0;
        int j=m-1;
        while(i<=j) {
            if(ss[i++]!=ss[j--]) {
                return false;
            }
        }
        return true;
    }
};