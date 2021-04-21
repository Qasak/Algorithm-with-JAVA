class Solution {
public:
    string reverseWords(string s) {
        if(s.empty()) return "";
        
        string ans;
        vector<string> tmp;
        int i=0;
        int n=s.size();
        while(i<n && s[i]==' ') i++;
        while(i<n) {
            string word;
            while(i<n && s[i]!=' ') {
                word.push_back(s[i]);
                i++;
            }
            tmp.push_back(word);
            while(i<n && s[i]==' ') i++;
        }
        while(!tmp.empty()) {
            ans+=*(tmp.end()-1);
            tmp.pop_back();
            ans+=' ';
        }
        if(ans.empty())
            return "";
        ans.resize(ans.size()-1);
        return ans;
    }
};