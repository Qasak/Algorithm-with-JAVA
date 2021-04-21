/*

输入：n = 3, k = 27
输出："aay"
**/
public class Q2 {
    public String getSmallestString(int n, int k) {
        char[] res = new char[n];
		// 当前应该填的位置下标
        int i = n - 1;
        while (i >= 0) {
			// 为什么和k - i 比 ： 保证当前位置填的是最大值，假设前面的位置全是1
			// k = 5, i = 3
			// k - i = 2
			// k = 3
			// k = 3, i = 2
			// k - i = 1
			// k = 2
            int curValue = Math.min(26, k - i);
            k -= curValue;
            res[i] = (char)('a' + curValue - 1);
            i--;
        }
        return String.valueOf(res);
    }
}
