class Solution {
public:
    string mostCommonWord(string paragraph, vector<string>& banned) {
        string::iterator it;
        unordered_map<string, int> m;
        for(string a:banned) {
            m[a]=-1;
        }
        it=paragraph.begin();
        while(it!=paragraph.end()) {

            while(it!=paragraph.end() && !isalpha(*it)) it++;

            string word="";

            while(it!=paragraph.end() && isalpha(*it)) {
                word.push_back(tolower(*it));
                it++;
            }
            if(word!="" && m[word]!=-1){
                if(m.find(word)==m.end())
                    m[word]=0;
                m[word]++;
            }
        }
        int mx=0;
        string ans;
        for(const auto &it:m) {
            if(it.second > mx) {
                ans=it.first;
                mx=it.second;
            }
        }
        return ans;
    }
};