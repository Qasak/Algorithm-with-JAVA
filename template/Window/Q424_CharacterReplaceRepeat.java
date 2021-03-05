package leetcode.template.Window;

import java.util.HashMap;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/2 10:50
 */
public class Q424_CharacterReplaceRepeat {
    public int characterReplacement(String s, int k) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int[] cnt = new int[n];
        int l = 0, r = 0;
        // 当前区间字母数量的众数
        int mode = 0;
        for(; r < n; r++) {
            cnt[cs[r] - 'A']++;
            mode = Math.max(mode, cnt[cs[r] - 'A']);
            // 当前区间长度 - 当前区间字母数量的众数 > k时，需要收缩左边界
            if(r - l + 1 - mode > k) {
                cnt[cs[l] - 'A']--;
                l++;
            }
        }
        return r - l;
    }
    public int characterReplacement1(String s, int k) {
        int len = s.length();
        int left = 0, right = 0;
        int res = 0;
        //记录每个字符的个数
        HashMap<Character, Integer> window = new HashMap<>();
        int maxCount = 0;//记录该窗口内最多的字符
        while(right < len){
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c,0) + 1);//窗口该值+1
            maxCount = Math.max(maxCount, window.get(c));//刷新最大值
            if(right - left + 1 - maxCount > k){//长度大于修改后最长，maxCount代表该窗口最多字符 + k（修改次数）就是该窗口修改后最优解长度
                char d = s.charAt(left);
                window.put(d, window.get(d) - 1);//窗口删掉一个字符
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
    // 重复字母 -> 统计区间内的众数
    // 替换 k 次 -> 不够替换时缩小区间
    public int characterReplacement2(String s, int k) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int l = 0, ans = 0;
        int[] cnt = new int[26];
        int m = 0;
        for(int r = 0; r < n; r++) {
            cnt[cs[r] - 'A']++;
            m = Math.max(m, cnt[cs[r] - 'A']);
            if(r - l + 1 - m > k) {
                cnt[cs[l] - 'A']--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
