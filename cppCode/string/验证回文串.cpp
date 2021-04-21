/*
"aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"

aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxj

aguokepatgbnvfqmgmlucupuufxoohdfpgjdmysgvhmvffcnqxj
*/

class Solution {
public:
    bool validPalindrome(string s) {
        int l=0;
        int r=s.size()-1;
        while(l<r) {
            if(s[l]==s[r]) {
                l++;
                r--;
            } else { 
                bool flag1=true;
                bool flag2=true;
                for(int i=l+1, j=r; i<j; i++,j--) {
                    if(s[i] != s[j]) {
                        flag1=false;
                        break;
                    } 
                }
                for(int i=l, j=r-1; i<j; i++,j--) {
                    if(s[i] != s[j]) {
                        flag2=false;
                        break;
                    } 
                }
                return flag1||flag2;
            }
        }
        return true;
    }
};