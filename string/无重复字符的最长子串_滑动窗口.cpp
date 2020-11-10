/*
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/


class Solution {
public:
    int lengthOfLongestSubstring(string s) {
		// 记录不重复字符的集合
        unordered_set<char> lookup;
        int maxStr = 0;
		// 窗口左边界
        int left = 0;
		// 窗口向右延申，一旦遇到在集合中出现过的字符，就在集合中删除窗口中最左边的字符，
		// 直到这个字符不在窗口中
		// 然后更新最长长度，再将这个字符插入集合
        for(int i = 0; i < s.size(); i++) {
			
            while (lookup.find(s[i]) != lookup.end()){
                lookup.erase(s[left]);
                left++;
            }
            maxStr = max(maxStr,i-left+1);
            lookup.insert(s[i]);
		}
        return maxStr;
    }
};

