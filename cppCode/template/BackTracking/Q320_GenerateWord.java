package leetcode.template.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/23 23:30
 */
public class Q320_GenerateWord {
    // 2 ^ n 个 [子集]
    // 输入: "word"
    //输出:
    //["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
    // 16个子集
    // [1,2,3,4] [2,3,4] [1,3,4] [1,2,4] [1,2,3] [3,4] [1,4] [1,2] [2,4] [2,3] [1,3] [2] [3] [4] [1] []
    // 2^n种情况

    List<String> ans;
    public List<String> generateAbbreviations(String word) {
        ans = new ArrayList<>();
        dfs(word, new StringBuilder(), 0, 0);
        return ans;
    }
    // k是连续缩写字符个数
    private void dfs(String word, StringBuilder sb, int idx, int k) {
        int n = word.length();
        int len = sb.length();
        if(idx == n) {
            if(k != 0) {
                sb.append(k);
            }
            ans.add(sb.toString());
            sb.setLength(len);
            return;
        }
        // ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]

        // 不选idx位置的数字
        // 缩写字符 + 1
        dfs(word, sb, idx + 1, k + 1);
        if(k != 0) {
            sb.append(k);
        }
        // 选idx位置的数字
        sb.append(word.charAt(idx));
        // 选了：没有缩写这个字
        dfs(word, sb, idx + 1, 0);
        sb.setLength(len);
    }

    public static void main(String[] args) {
        Q320_GenerateWord s = new Q320_GenerateWord();
        System.out.println(s.generateAbbreviations("word"));
    }
}
