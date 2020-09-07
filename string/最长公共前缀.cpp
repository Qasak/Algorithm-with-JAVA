class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if(strs.empty()) return "";
        string p=strs[0]; 
        int n=strs.size();
        int r;
        for(int i=1;i<n;i++) {
            int m=strs[i].size();
            int k=p.size();
            for(r=0; r<m && r<k;r++) {
                if(strs[i][r]!=p[r])
                    break;
            }
            p=p.substr(0,r);
        }
        return p;
    }
};