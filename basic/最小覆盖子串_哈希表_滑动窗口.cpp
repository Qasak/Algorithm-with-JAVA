/*
给你一个字符串 S、一个字符串 T 。请你设计一种算法，可以在 O(n) 的时间复杂度内，从字符串 S 里面找出：包含 T 所有字符的最小子串。

 

示例：

输入：S = "ADOBECODEBANC", T = "ABC"
输出："BANC"
 

提示：

如果 S 中不存这样的子串，则返回空字符串 ""。
如果 S 中存在这样的子串，我们保证它是唯一的答案。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-window-substring
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/


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
                ++left;
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