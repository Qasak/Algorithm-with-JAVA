package leetcode.SpringRecruit.DoublePtr;

import leetcode.SpringRecruit.DP.Pair;

import javax.security.auth.callback.CallbackHandler;
import java.util.TreeMap;


/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/17 11:52
 */
public class Q220_存在重复元素3 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        if(n == 0) {
            return false;
        }
        if(k > n) {
            k = n;
        }
        int l = 0, r = 0;
        TreeMap<Long, Integer> map = new TreeMap<>();
        for(int i = 0; i < n; ) {

            while(r < n && r - l <= k) {
                if(map.ceilingKey((long)nums[r]) != null
                        && Math.abs(map.ceilingKey((long)nums[r]) - nums[r]) <= t) {
                    return true;
                }
                if(map.floorKey((long)nums[r]) != null
                        && Math.abs(map.floorKey((long)nums[r]) - nums[r]) <= t) {
                    return true;
                }
                map.put((long)nums[r], map.getOrDefault((long)nums[r], 0) + 1);
                r++;
            }
            map.put((long)nums[l], map.getOrDefault((long)nums[l], 0) - 1);
            if(map.get((long)nums[l]) == 0) {
                map.remove((long)nums[l]);
            }
            l++;
            i = r;

        }
        return false;
    }
    public static void main(String[] args) throws InterruptedException {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Integer a = map.floorKey(2);
        Integer b = map.ceilingKey(2);
        System.out.println(a + "  " + b);
        Object o = new Object();
        synchronized (o) {
            o.wait();

        }
        System.out.println("x");
//        Pair<Integer, Character> p = new javafx.util.Pair<>();
    }
}
