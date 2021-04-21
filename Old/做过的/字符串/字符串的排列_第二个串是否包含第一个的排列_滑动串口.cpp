class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        int n1=s1.size();
        int n2=s2.size();
        if(n1>n2) return false;
        int ch_count1[26]={0};
        int ch_count2[26]={0};
        for(int i=0;i<n1;i++) {
            ch_count1[s1[i]-'a']++;
            ch_count2[s2[i]-'a']++;
        }
        for(int i=n1; i<n2; i++) {
            if(check(ch_count1, ch_count2)) return true;
            ch_count2[s2[i-n1]-'a']--;
            ch_count2[s2[i]-'a']++;
        }
        return check(ch_count1, ch_count2);
    }
    bool check(const int * a, const int * b) {
        for(int i=0;i<26;i++) {
            if(a[i] != b[i])
                return false;
        }
        return true;
    }
};