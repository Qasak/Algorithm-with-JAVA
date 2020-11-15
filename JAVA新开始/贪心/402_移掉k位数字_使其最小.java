/*
对于两个相同长度的数字序列，最左边不同的数字决定了这两个数字的大小
若要使得剩下的数字最小，需要保证靠前的数字尽可能小。
**/

class Solution {
    public String removeKdigits(String num, int k) {
        // 要删除的== num长度
        if(num.length() == k) return "0";
        StringBuilder s = new StringBuilder(num);
        // 进行k次查找
        for(int i = 0; i < k; i++) {
            // 找到第一个比后面大的数字，并将其删除
            // 1234 -> 234/134/124/123
            // 4312 -> 312/412/432/431
            // 1432 -> 432/132/142/143
            // 1001 -> 001 -> 1
            // 第一个比后一个字符大的字符的位置
            int idx = 0;
            // 是递增(单调不减)的，就继续
            for(int j = 1; j < s.length() && s.charAt(j) >= s.charAt(j - 1); j++) {
                idx = j;
            }
            // 直到结束 或 当前j位置小于前一个j位置：idx指向前一个位置那个大的元素->删除idx指向元素
            s.delete(idx, idx + 1);
            // 删除前导零
            while(s.length() > 1 && s.charAt(0) == '0') {
                s.delete(0, 1);
            }
            
        }
        return s.toString();
    }
}