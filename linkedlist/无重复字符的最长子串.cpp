class Solution {
public:
    int first=0;
    int last=0;
    int mxcnt=0;
    int lengthOfLongestSubstring(string s) {
        int n=s.size();
        while(last<n) {
            bool ascii[127] = {0};
            bool flag=true;
            int cnt=0;
            while(last<n && flag) {
                int idx=(int)s[last];
                if(ascii[idx]) {
                    first++;
                    flag=false;
                    last=first;
                } else {
                    ascii[idx]=1;
                    last++;
                    cnt++;
                    if(cnt>mxcnt) {
                        mxcnt=cnt;
                    }
                }
            }
        }
        return mxcnt;
    }
};