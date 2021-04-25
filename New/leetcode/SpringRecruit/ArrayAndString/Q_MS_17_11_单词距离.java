package leetcode.SpringRecruit.ArrayAndString;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/19 13:15
 */
public class Q_MS_17_11_单词距离 {
    public int findClosest(String[] words, String word1, String word2) {
        // i 指向word1, j 指向word2
        int i = 100001, j = 100001;
        int max = words.length;
        for(int k = 0; k < words.length; k++) {
            if(word1.equals(words[k])) {
                i = k;
                max = Math.min(max, Math.abs(i - j));
            }
            if(word2.equals(words[k])) {
                j = k;
                max = Math.min(max, Math.abs(i - j));
            }
        }
        return max;
    }
}
