package leetcode.SpringRecruit.String;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/12 10:17
 */
public class Q179_最大数 {
    // [1,2,3,4,5,6,7,8,9,0]
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if((a + b).compareTo(b + a) < 0) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < n; i++) {
            ans.append(arr[i]);
        }
        for(int i = 0; i < n; i++) {
            if(ans.length() == 0 || ans.charAt(i) != '0') {
                break;
            } else if(ans.charAt(i) == '0') {
                ans.deleteCharAt(i);
                i--;
            }
        }
        if(ans.length() == 0) {
            ans.append(0);
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        String a = "123";
        String b = "1234";
        StringBuilder ans = new StringBuilder(b);
        for(int i = 0 ; i < ans.length(); i++) {
            System.out.println(ans + " " + ans.length() + " " + i);
            ans.deleteCharAt(i);
        }
    }
}
