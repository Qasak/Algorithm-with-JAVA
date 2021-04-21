class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int n,l,r,cnt,mxcnt;
        n=s.size();
        mxcnt=0;
        unordered_map<char, bool> mp;
        for(int i=0;i<n;i++) {
            cnt=0;
            l=r=i;
            mp.clear();
            while(r<n) {
                if(mp.count(s[r]))
                    break;
                mp[s[r++]]=true;
                if(++cnt>mxcnt)
                    mxcnt=cnt;
            }
        }
        return mxcnt;
    }
};