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
    unordered_map<char, int> charset_t, charset_s;
    bool check() {
        for(auto c_i:charset_t) {
            char t=c_i.first;
            if(charset_s[t]<c_i.second)
                return false;
        }
        return true;
    }
    string minWindow(string s, string t) {
        int n=s.size();
        int m=t.size();
        if(!n || !m) return "";
        for(int i=0; i<m;i++) {
            charset_t[t[i]]++;
        }
        int l,r,min_l,min_r;
        int min_len=INT_MAX;
        l=r=min_l=min_r=0;
        while(r<n) {
            if(charset_t.find(s[r])!=charset_t.end()) { // 如果是T中的字符
                charset_s[s[r]]++;
            }
            while(check() && r<s.size()) { // S的窗口中的字符数量和T的字符数量匹配
                if(r-l+1<min_len) { // 该窗口小于之前的窗口：记录l,r和长度
                    min_l=l;
                    min_r=r;
                    min_len=r-l+1;
                }
                if(charset_s.find(s[l])!=charset_s.end()) // 移动窗口左端点，若左端点字符在集合中，则数量--， 直到匹配不上
                    charset_s[s[l]]--;
                l++;
            }
            r++;
        }
        if(min_len==INT_MAX)
            return "";
        return s.substr(min_l, min_r-min_l+1);
    }
};

class Solution {
public:
    string minWindow(string s, string t) {
        int n=s.size();
        int m=t.size();
        int mp[128]={0}; // ASCII一共128个
        for (int i=0;i<m;i++) // t中的所有元素加入集合
            mp[t[i]]++;
        int l, r, min_l, min_r, min_len;
        l=r=min_l=min_r=0;
        min_len=INT_MAX;
        while(r<n) {
            if(mp[s[r]]-- > 0) { // 超出的元素继续减，但不再减集合的大小
                m--;
            }
            while(m==0) {
                if(r-l+1<min_len) {
                    min_l=l;
                    min_r=r;
                    min_len=r-l+1;
                }
                if(mp[s[l]]++ ==0) { // 恢复集合: "ADOBECODEBANC" 注意B出现两次,mp值-1, 如果if(mp[s[l]] ==0) 则不能恢复到集合中
                    m++;
                }
                l++;
            }
            r++;
        }
        return min_len==INT_MAX ? "" : s.substr(min_l, min_r-min_l+1);
    }
};