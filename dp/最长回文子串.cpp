class Solution {
public:
    bool dp[5005][5005];
    int max_len;
    string ans;
    string longestPalindrome(string s) {
        int n=s.size();
        for(int len=0;len<n;len++) {
            for(int i=0;i<n;i++) {
                int j=i+len;
                if(len==0)
                    dp[i][j]=true;
                else if(len==1)
                    dp[i][j]=(s[i]==s[j]);
                else {
                    dp[i][j]=dp[i+1][j-1] && (s[i]==s[j]);
                }
                if(dp[i][j] && len+1>max_len)  {
                    max_len=len+1;
                    ans=s.substr(i, len+1);
                }
            }
        }
        return ans;
    }
};