package leetcode.template.DoublePtr;

import leetcode.contest.WeekContest_218.B;
import leetcode.contest.WeekContest_218.D;

import javax.xml.crypto.Data;
import java.sql.Time;
import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/26 13:30
 */
public class Q15_ThreeSum {
    // 1. set去重
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        // -4 -1 -1 0 1 2
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int target = -nums[i];
            int l = i + 1; int r = n - 1;
            for(; l < r && l < n - 1; ) {
                if(nums[l] + nums[r] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]); list.add(nums[l]); list.add(nums[r]);
                    ans.add(list);
                    l++; r--;
                } else if(nums[l] + nums[r] < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return new ArrayList<>(ans);
    }
    // 2. 手动去重
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        // -4 -1 -1 0 1 2
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(i != 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int target = -nums[i];
            int l = i + 1; int r = n - 1;
            for(; l < r && l < n - 1; ) {
                if(nums[l] + nums[r] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]); list.add(nums[l]); list.add(nums[r]);
                    ans.add(list);
                    while(nums[l]==nums[++l]&&l<r) {
                        ;
                    }
                    while(nums[r]==nums[--r]&&l<r) {
                        ;
                    }
                } else if(nums[l] + nums[r] < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return ans;
    }
    // 官方题解
    public List<List<Integer>> threeSum3(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        // 枚举 a
        for (int i = 0; i < n; ++i) {
            // 需要和上一次枚举的数不相同
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int r = n - 1;
            int target = -nums[i];
            // 枚举 b
            for (int l = i + 1; l < n; ++l) {
                // 需要和上一次枚举的数不相同
                if (l > i + 1 && nums[l] == nums[l - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (l < r && nums[l] + nums[r] > target) {
                    --r;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (l == r) {
                    break;
                }
                if (nums[l] + nums[r] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]); list.add(nums[l]); list.add(nums[r]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Date d = new Date();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date d1 = new Date();
        System.out.println(d.getTime());
        System.out.println(d1.getTime());
        System.out.println(d.getTime());
        System.out.println(d1.getTime());
    }
}
