package leetcode.SpringRecruit.ArrayAndString;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/27 9:59
 */
public class Q186_翻转字符串里的单词2 {
    public void reverseWords(char[] s) {
        int n = s.length;
        reverse(s, 0, n - 1);
        int i = 0;
        while(i < n) {
            if(s[i] != ' ') {
                int j = i;
                while(j < n && s[j] != ' ') {
                    j++;
                }
                reverse(s, i, j - 1);
                i = j + 1;
            }
        }
    }

    public void reverse(char[] nums, int i, int j) {
        while(i < j) {
            swap(nums, i, j);
            i++; j--;
        }
    }
    public void swap(char[] nums, int i, int j) {
        char t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
