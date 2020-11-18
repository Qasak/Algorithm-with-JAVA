class Solution {
public:
    bool isPalindrome(string s) {
        int n=s.size();
        if(!n) return true;
        string ss;
        int i=0;
        while(i<n) {
            if(isalnum(s[i])) {
                ss+=tolower(s[i]);
            }
            i++;
        }
        int l=0, r=ss.size()-1;
        while(l<r) {
            if(ss[l++] != ss[r--]) return false;
        }
        return true;
    }
};