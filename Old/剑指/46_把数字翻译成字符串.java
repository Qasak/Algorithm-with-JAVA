/**
给定一个数字，我们按照如下规则把它翻译为字符串：
0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译
*/

// 记数字num第i为数字为xi, eg: num = 12258 n=5, x1=1
// dp[i]: 表示以xi为结尾的数字的翻译方案数
// dp[i] = dp[i - 1] + dp[i - 2] 
// dp[i - 1]:单独翻译xi
// dp[i - 2]:整体翻译x(i-1), xi (满足在[10, 25])



/*
初始值：
显然：dp[1] = 1，dp[2] = dp[1] + dp[0] = 2(如果合法)
所以dp[0] = 1
空间优化：
a: dp[i]
b: dp[i-1]
滚动前进
**/
class Solution {
    public int translateNum(int num) {
		String s = String.valueOf(num);
		int a, b;
		a = b = 1;
		for(int i = 2; i <= s.size(); i++) {
			int c = s.subString(i-2, i).compareTo("10") >=0 && s.subString(i-2, i).compareTo("25") <=0 ? a + b : a;
			b = a;
			a = c;
		}
		return a;
    }
}