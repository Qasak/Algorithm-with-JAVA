package leetcode.JianZhi;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/12 17:03
 */
public class Q3 {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i: nums) {
            if(!set.add(i)) {
                return i;
            }
        }
        return -1;
    }
}
