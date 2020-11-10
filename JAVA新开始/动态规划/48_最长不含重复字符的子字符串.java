/*
请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。

输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
**/


/*
暴力：O(N^3): 长度为N的字符串有(1+N)*N /2个子字符串(复杂度O(N^2))
判断是否有重复字符：O(N)


**/

/*
动态规划：
dp[j] : 以字符s[j] 结尾的”最长不重复子字符串“的长度
转移：固定有边界j, 设字符s[j]左边距离最近的相同字符为s[i](s[i] = s[j])
如果j-i > dp[j - 1], 说明i在不重复子字符串的左边， dp[j] = dp[j - 1] + 1
否则 说明i在 不重复子字符串里面，dp[j] = j-i;
**/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        // tmp: 保存dp[i - 1]，初始值为0
        int mxLen = 0, tmp = 0;
        char[] cs = s.toCharArray();
        for(int j = 0; j < cs.length; j++) {
            //获取与s[j]相同字符的最近的索引s[i]
			// -1 则说明s[j]的左边没有相同字符
            int i = map.getOrDefault(cs[j], -1);
			// 完成获取相同字符的下标后，将当前字符也插入(或更新)到字符-最近下标映射
            map.put(cs[j], j);
			// j-i的长度(即两个重复字符之间的长度 (i, j] )比以j-1结尾的”最长不重复子字符串“长度大：说明i在”最长不重复子字符串“的左边
			// 那么这个串还没有重复的字符，因此在之前的基础上加上新来的j字符，长度对应+1
			// 否则，dp[j]的串是被i掐断的dp[j-1]的串，长度为(i, j]的长度，即j-i
            tmp = j - i > tmp ? tmp + 1 : j - i;
            mxLen = Math.max(mxLen, tmp);
        }
        return mxLen;
    }
}


/*
双指针/滑动窗口

**/

class Solution {
    public int lengthOfLongestSubstring(String s) {
		// j指针遍历字符s, 哈希表统计字符s[j]最后一次出现的索引
        Map<Character, Integer> dic = new HashMap<>();
		// i: 左指针，记录不含重复子串的左边界
        int i = -1, res = 0;
        for(int j = 0; j < s.length(); j++) {
			// 如果哈希表中存在j字符，拿到上次j字符出现的位置与当前窗口的更大值(若j的位置在当前窗口之前，可能有重复的值)
            // max保证左边界不会往回走 -> 舍弃掉的左边界的区间必然是有重复元素的
            if(dic.containsKey(s.charAt(j))) {
				i = Math.max(i, dic.get(s.charAt(j)));
			}
            // 哈希表更新
            dic.put(s.charAt(j), j); 
			// 更新最大长度，i j 是两个相同的字符，故长度为(i, j]的长度： j - i
            res = Math.max(res, j - i); 
        }
        return res;
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int mxLen = 0;
        int l = 0;
        char[] cs = s.toCharArray();
        for(int i = 0; i < cs.length; i++) {
            while(set.contains(cs[i])) {
                set.remove(cs[l]);
                l++;
            }
            mxLen = Math.max(mxLen, i - l + 1);
            set.add(cs[i]);
        }
        return mxLen;
    }
}