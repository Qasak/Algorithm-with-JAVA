package leetcode.template.Window;

import Utils.FileUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/18 9:51
 */
public class Q995 {
    // 模拟：超时
    public static int minKBitFlips(int[] A, int K) {
        int n = A.length;
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(A[i] == 1) {
                continue;
            }
            if(i + K > n) {
                return -1;
            }
            cnt++;
            int start = i;
            boolean flag = false;
            for(int j = 0; j < K; j++) {
                if(A[i + j] == 1) {
                    A[i + j] = 0;
                } else {
                    A[i + j] = 1;
                }
                if(!flag && A[i + j] == 0) {
                    flag = true;
                    start = i + j;
                }
            }
            i = start - 1;
        }
        return cnt;
    }
    // 差分数组
    public static int minKBitFlips1(int[] A, int K) {
        int n = A.length;
        int[] diff = new int[n + 1];
        int ans = 0, revCnt = 0;
        for (int i = 0; i < n; ++i) {
            // diff[i] : A[i]反转次数 - A[i - 1]反转次数
            revCnt += diff[i];
            System.out.println(revCnt + " " + ans);
            if ((A[i] + revCnt) % 2 == 0) {
                if (i + K > n) {
                    return -1;
                }
                ++ans;
                ++revCnt;
                --diff[i + K];
            }
        }
        return ans;
    }

    public static int minKBitFlips2(int[] A, int K) {
        int n = A.length;
        int[] diff = new int[n + 1];
        int ans = 0, revCnt = 0;
        for (int i = 0; i < n; ++i) {
            System.out.println(revCnt + " " + ans);

            // diff[i] : A[i]反转次数 - A[i - 1]反转次数
            // revCnt : 在窗口内的反转次数
            revCnt ^= diff[i];
            if ((A[i] + revCnt) % 2 == 0) {
                if (i + K > n) {
                    return -1;
                }
                ans++;
                revCnt ^= 1;
                // 离开窗口时取消这次累加的效果
                diff[i + K] ^= 1;
            }
        }
        return ans;
    }
    // 滑动窗口


    public static void main(String[] args) {
        String in = FileUtil.getString("src/main/resources/in.txt");
        List<Integer> arr = new ArrayList<>();
        for(char c: in.toCharArray()) {
            if(c == '0') {
                arr.add(0);
            }
            if(c == '1') {
                arr.add(1);
            }
        }

        int n = 15295;
        int[] a = arr.stream().mapToInt(Integer::valueOf).toArray();
        System.out.println(minKBitFlips2(a, n));
        System.out.println(a.length);
    }
}
