class Solution {
public:
    string minWindow(string s, string t) {
        if(s.empty() || t.empty()) 
            return "";
        multiset<char> pattern, tmp;
        for(int i=0;i<t.size(); i++) {
            pattern.insert(t[i]);
        }
        int n=s.size();
        int m=t.size();
        // if(m>n)
        //     return "";
        int left,right,min_left,min_right;
        int min_len=((unsigned)(1<<31>>31))>>1;
        
        for(int i=0;i<n;i++) {
            left=right=i;
            tmp=pattern;
            while(!tmp.empty() && right<n) {

                if(tmp.find(s[right])!=tmp.end()) {
                    tmp.erase(tmp.find(s[right]));
                }
                right++;
            }
            if(tmp.empty() && right-left+1<min_len) {
                min_len=right-left+1;
                min_left=left;
                min_right=right;

            }
        }
        
        if(min_len==((unsigned)(1<<31>>31))>>1) 
            return "";
        char ans[n+1];
        for(int i=min_left;i<min_right;i++) {
            sprintf(ans+i-min_left, "%c", s[i]);
        }
        return ans;
    }
};