package leetcode.template.Expression;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/23 10:08
 */
public class Q1111_MaxDepthAfterSplit {
    public int[] maxDepthAfterSplit(String seq) {
        //()()()()()
        // 0011111111
        //(())
        // 1001
        // ((()))
        // 100001
        // ()()
        // 1100/ 0011
        // ()(())
        // 111001/ 000110 / 110000/001111
        // 嵌套的括号区分开
        // (())
        // 1001
        // (((())))
        // 12343210
        // 10100101
        // ()()()()
        // 10101010
        // "()(())()"
        //  00011011
        //  11100111
        int cnt = 0;
        int n = seq.length();
        char[] cs = seq.toCharArray();
        int[] ans = new int[n];
        int j = 0;
        ans[0] = 1;
        for(int i = 0; i < n; i++) {
            if(cs[i] == '(') {
                cnt++;
                if((cnt % 2) == 1) {
                    ans[i] = 1;
                }
            } else {
                cnt--;
                if((cnt % 2) == 0) {
                    ans[i] = 1;
                }
            }

        }
        return ans;
    }
}
