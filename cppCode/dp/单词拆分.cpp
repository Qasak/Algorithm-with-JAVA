class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        int n=s.size();
        vector<vector<bool>> dp(n, vector<bool>(n, false));
        set<string> word_dict(wordDict.begin(), wordDict.end());
        for(int i=0;i<n;i++) {
            for(int j=i; j<n;j++) {
                string tmp=s.substr(i, j-i+1);
                cout<<tmp<<endl;
                if(word_dict.find(tmp)!=word_dict.end()) {
                    cout<<i<<" "<<j<<endl;
                    dp[i][j]=true;
                    
                }

            }
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(j+1<n)
                    if(dp[0][j] && dp[j+1][i])
                        dp[0][i]=true;
            }

        }
        return dp[0][n-1];
    }
};