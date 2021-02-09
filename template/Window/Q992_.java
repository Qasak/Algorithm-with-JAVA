package leetcode.template.Window;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/9 10:05
 */
public class Q992_ {
    // 超时: 拷贝map太慢
    public int subarraysWithKDistinct(int[] A, int K) {
        int n = A.length;
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int cnt = 0;
        for(int r = 0; r < n; r++) {
            map.put(A[r], map.getOrDefault(A[r], 0) + 1);
            while(l <= r && map.size() > K) {
                map.put(A[l], map.get(A[l]) - 1);
                if(map.get(A[l]) == 0) {
                    map.remove(A[l]);
                }
                l++;
            }
            Map<Integer, Integer> map1 = new HashMap<>(map);
            int ll = l;
            while(ll <= r && map1.size() == K) {
                cnt++;
                map1.put(A[ll], map1.get(A[ll]) - 1);
                if(map1.get(A[ll]) == 0) {
                    map1.remove(A[ll]);
                }
                ll++;
            }
        }
        return cnt;
    }


    // O(n^2)
    public int subarraysWithKDistinct1(int[] A, int K) {
        int n = A.length;
        int[] freq = new int[n + 1];
        int l = 0;
        int cnt = 0;
        int distinct = 0;
        for(int r = 0; r < n; r++) {
            if(freq[A[r]] == 0) {
                distinct++;
            }
            freq[A[r]]++;
            while(l <= r && distinct > K) {
                freq[A[l]]--;
                if(freq[A[l]] == 0) {
                    distinct--;
                }
                l++;
            }
            // O(n^2)
            if(distinct < K) {
                continue;
            }
            int[] freq1 = Arrays.copyOf(freq, n + 1);
            int distinct1 = K;
            int ll = l;
            while(ll <= r && distinct1 == K) {
                cnt++;
                freq1[A[ll]]--;
                if(freq1[A[ll]] == 0) {
                    distinct1--;
                }
                ll++;
            }
        }
        return cnt;
    }
    public int subarraysWithKDistinct2(int[] A, int K) {
        int n = A.length;
        int[] freq = new int[n + 1];
        int l = 0;
        int cnt = 0;
        int distinct = 0;
        for(int r = 0; r < n; r++) {
            if(freq[A[r]] == 0) {
                distinct++;
            }
            freq[A[r]]++;
            while(l <= r && distinct > K) {
                freq[A[l]]--;
                if(freq[A[l]] == 0) {
                    distinct--;
                }
                l++;
            }
            if(distinct < K) {
                continue;
            }
            int distinct1 = K;
            int ll = l;
            while(ll <= r && distinct1 == K) {
                cnt++;
                freq[A[ll]]--;
                if(freq[A[ll]] == 0) {
                    distinct1--;
                }
                ll++;
            }
            // 恢复窗口
            for(int i = ll - 1; i >= l; i--) {
                freq[A[i]]++;
            }
        }
        return cnt;
    }


    public int subarraysWithKDistinct3(int[] A, int K) {
        return mostK(A, K) - mostK(A, K - 1);
    }
    int mostK(int[] A, int K){
        int n = A.length;
        int[] map = new int[n + 1];
        int i = 0, j = 0, cnt = 0, res = 0;
        while(j < n){
            if(map[A[j++]]++ == 0) cnt++;
            while(cnt > K) if(--map[A[i++]] == 0) cnt--;
            res += j - i;
        }
        return res;
    }
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
        map.size();
    }
}
