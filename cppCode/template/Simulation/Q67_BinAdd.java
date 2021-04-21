package leetcode.template.Simulation;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/22 22:30
 */
public class Q67_BinAdd {
    public String addBinary(String a, String b) {
        int c = 0;
        StringBuilder ans = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        while(i >= 0 || j >= 0 || c > 0) {
            int sum = c;
            if(i >= 0) {
                sum += (a.charAt(i) - '0');
            }
            if(j >= 0) {
                sum += (b.charAt(j) - '0');
            }
            ans.append((char)(sum % 2 + '0'));
            c = sum / 2;
            i--; j--;
        }
        return ans.reverse().toString();
    }
}
