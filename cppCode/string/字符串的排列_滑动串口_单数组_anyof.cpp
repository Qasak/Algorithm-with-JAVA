class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        int n1=s1.size();
        int n2=s2.size();
        if(n1>n2) return false;
        vector<int> ch_count(26,0);
        for(int i=0;i<n1;i++) {
            ch_count[s1[i]-'a']++;
            ch_count[s2[i]-'a']--;
        }
        for(int i=n1; i<n2; i++) {
            if(check(ch_count)) return true;
            ch_count[s2[i-n1]-'a']++;
            ch_count[s2[i]-'a']--;
        }
        return check(ch_count);
    }
    bool check(vector<int> &a) {
        return !any_of(a.begin(), a.end(), [](const int &num) {return num;});
    }
};