/**
给定一个32位正整数 n，
你需要找到最小的32位整数，其与 n 中存在的位数完全相同，并且其值大于n。
如果不存在这样的32位整数，则返回-1。

输入: 12
输出: 21
*/

class Solution {
    public int nextGreaterElement(int n) {
        // valueOf():返回int参数的字符串表示形式。
        String s = String.valueOf(n);
        // toCharArray():返回String的字符数组
        char[] cs = s.toCharArray();
        // 从后向前扫描：目的：找到j元素<i元素的位置
        // // 54321 -> -1 (没有下一个更大的元素)
        //// 12345 -> 12354
        //// 54231 ->
        //
        // 两个指针i,j
        // i指向字符数组最后一个元素
        // j指向字符数组倒数第二个元素
        // 从后向前扫描，直到j==-1
        // 若前一个指针的元素小于后一个指针的元素：跳出
        // 另一个指针k,指向最后一个元素
        // 同样从后向前扫，若找到比j的元素大的，跳出
        // 然后交换k和j的元素
        int m = cs.length;
        int i = m - 1;
        int j = m - 2;
        while(j >= 0) {
            if(cs[j] < cs[i]) {
                break;
            }
            j--;
            i--;
        }
        int k = m - 1;
        if(j == -1) {
            return -1;
        } else {
            while(k >= i) {
                if(cs[k] > cs[j]) {
                    break;
                }
                k--;
            }
            char t = cs[j];
            cs[j] = cs[k];
            cs[k] = t;
            // 范围：左闭右开
            Arrays.sort(cs, i, m);
        }
        // Long.parseLong():将字符串参数解析为带符号的十进制long。
        StringBuilder sb = new StringBuilder();
        for(char c: cs) {
            sb.append(c);
        }
        s = sb.toString();
        long ans = Long.parseLong(s);
        return ans > Integer.MAX_VALUE ? -1 : (int) ans;
    }
}
