class Solution {
public:
    unordered_map<char, int> pattern, tmp;
    const int MAX_INT=(unsigned(1<<31>>31))>>1;
    bool check() {
        for(const auto &c:pattern) {
            if(tmp[c.first]<c.second)
                return false;
        }
        return true;
    }
    
    
    string minWindow(string s, string t) {
        for(const auto &c:t) {
            ++pattern[c];
        }
        int left,right,min_left,min_right;
        int min_len=MAX_INT;
        left=0;
        right=0;
        for(const auto &c:s) {
            if(pattern.find(c)!=pattern.end()) {
                ++tmp[c];
            }
                
            
            while(check() && right<s.size()) {
                if(right-left+1<min_len) {
                    min_left=left;
                    min_right=right;
                    min_len=right-left+1;
                }
                if(tmp.find(s[left])!=tmp.end())
                    tmp[s[left]]--;
                left++;
            }
            ++right;

        }
        if(min_len==MAX_INT)
            return "";
        char ans[s.size()+1];
        for(int i=min_left;i<=min_right;i++) {
            sprintf(ans+i-min_left, "%c", s[i]);
        }
        return ans;
    }
};