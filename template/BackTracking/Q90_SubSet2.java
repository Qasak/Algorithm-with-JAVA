package leetcode.template.BackTracking;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/29 18:14
 */
public class Q90_SubSet2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        // 1 10 11 100 101 110 111
        for(int mask = 1; mask < (1 << n); mask++) {
            boolean illegal = false;
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                if(((mask >> i) & 1) == 1) {
                    // list.add(nums[i]);
                    //
 
                    // 2 2 2 2 2
                    //1 1 0 0 0 -> [  2 2       ]
                    //1 0 1 0 0 -> [  2 2       ]
                    //0 1 1 0 0 -> [  2 2       ]
                    //0 1 0 1 0 -> [  2 2       ]
                    //0 0 0 1 1 -> [  2 2       ]

                    if(i > 0 && nums[i] == nums[i - 1] && ((mask >> (i - 1)) & 1) == 0 ) {
                        illegal = true;
                        break;
                    } else {
                        list.add(nums[i]);
                    }
                }
            }
            if(!illegal) {
                ans.add(list);
            }
        }
        ans.add(new ArrayList<Integer>());
        return ans;
    }

    public static void main(String[] args) {
        String a = String.valueOf(2);
        System.out.println(a);
    }
}
