class Solution {
public:
    string convert(string s, int numRows) {
        string res;
        if(s.empty() || numRows < 1) return res;
        if(numRows == 1) return s;
        int i=0, n=s.size();
        vector<string> tmp(numRows);
        for(int i=0;i<n;i++) {
            int line=i % (numRows-1);
            int order=i/(numRows-1);
            if(order % 2==0) // 偶数
                tmp[line].push_back(s[i]);
            else
                tmp[numRows-1-line].push_back(s[i]);
        }
        for(auto &w:tmp)
            res+=w;
        return res;
    }
};