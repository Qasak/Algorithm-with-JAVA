package leetcode.template.BIT;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/4 12:54
 * 315. 计算右侧小于当前元素的个数
 * (每个数的逆序对)
 */
public class Q315_CountSmaller {
    static int[] idx;
    static int[] res;
    // int[] tmp;
    public static List<Integer> countSmaller(int[] nums) {
        // [5,2,6,1] 5:1 6:1
        // [2,5,1,6] 5:2 6:1 2:1
        // [1,2,5,6]


        // [5,4,3,2]
        //
        // - > [2,1,1,0]
        int n = nums.length;
        idx = new int[n];
        res = new int[n];
        // tmp = new int[n];
        for(int i = 0; i < n; i++) {
            idx[i] = i;
        }
        mergeSort(nums, 0, nums.length - 1);
        List<Integer> ans = new ArrayList<>();
        // System.out.println(Arrays.toString(nums));
        for(int i : res) {
            ans.add(i);
        }
        return ans;

    }
    private static void mergeSort(int[] nums, int l, int r) {
        if(l < r) {
            // [5,3,4,5,2]
            // [0,1,2,3,4]
            //
            // [2,3,4,5,5]
            // [4,1,2,0,3]

            int m = (l + r) / 2;
            mergeSort(nums, l, m);
            mergeSort(nums, m + 1, r);
            int p1 = l, p2 = m + 1;
            int n = r - l + 1;
            int[] tmp = new int[n];

            int i = 0;
            while(p1 <= m && p2 <= r) {
                // 左边元素p1出列时计算
                // [m + 1, p2)[p2, r]
                // 共比p2 - m - 1个元素大
                if(nums[idx[p1]] <= nums[idx[p2]]) {
                    res[idx[p1]] += p2 - m - 1;
                    tmp[i++] = idx[p1++];
                } else {
                    tmp[i++] = idx[p2++];
                }
            }
            while(p1 <= m) {
                // 左边元素出列时计算
                res[idx[p1]] += p2 - m - 1;
                tmp[i++] = idx[p1++];
            }
            while(p2 <= r) {
                tmp[i++] = idx[p2++];
            }
            for(int j = 0; j < n; j++) {
                idx[j + l] = tmp[j];
            }
        }
    }
    // 二分
    public List<Integer> countSmaller1(int[] nums) {
        // 最后一个数肯定没有比他小的
        // 倒序插入，然后二分搜索应该插入的位置
        // [5,3,4,5,2]
        // list:
        // []
        // [2]
        // [2,5]
        // [2,4,5]
        // [2,3,4,5]
        // [2,3,4,5,5]

        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        for(int i = n - 1; i >= 0; i--) {
            int idx = lowerBound(list, nums[i]);
            // idx == list.size() 则再最后一个位置插入
            // idx也是比当前元素小的元素数量
            list.add(idx, nums[i]);
            ans.add(idx);
        }
        Collections.reverse(ans);
        return ans;
    }
    private int lowerBound(List<Integer> list, int target) {
        // [l, r) 中没有比target小的 返回0
        // [l, r) 中没有比target大的 返回r
        int l = 0, r = list.size();
        while(l < r) {
            int m = (l + r) >>> 1;
            if(list.get(m) < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        // System.out.println(l);
        return l;
    }
    // BIT树状数组
    /**
     * 「树状数组」是一种可以动态维护序列前缀和的数据结构，它的功能是：
     *
     * 单点更新 update(i, v)： 把序列 i 位置的数加上一个值 v，在该题中 v = 1
     * 区间查询 query(i)： 查询序列  [1⋯i] 区间的区间和，即 i 位置的前缀和
     * 修改和查询的时间代价都是  O(logn)，其中 n为需要维护前缀和的序列的长度
     * */
    // nums:[5,2,6,1]
    //
    // 有序无重复 a :[1,2,5,6]
    // 编号：        1,2,3,4
    //

    //c:数状数组：c[i - 1] : 有多少个数比 i小
    private int[] c;
    private int[] a;

    public List<Integer> countSmaller3(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        discretization(nums);
        init(n);
        for (int i = n - 1; i >= 0; --i) {
            // int id = getId(nums[i]);
            int id = lowerBound(nums[i]) + 1;
            ans.add(query(id - 1));
            update(id);
        }
        Collections.reverse(ans);
        return ans;
    }

    private void init(int length) {
        c = new int[length];
        Arrays.fill(c, 0);
    }

    private int lowBit(int x) {
        return x & (-x);
    }

    private void update(int pos) {
        while (pos < c.length) {
            c[pos] += 1;
            pos += lowBit(pos);
        }
    }

    private int query(int pos) {
        int ret = 0;
        while (pos > 0) {
            ret += c[pos];
            pos -= lowBit(pos);
        }

        return ret;
    }

    private void discretization(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        int size = set.size();
        a = new int[size];
        int index = 0;
        for (int num : set) {
            a[index++] = num;
        }
        Arrays.sort(a);
    }

    private int getId(int x) {
        return Arrays.binarySearch(a, x) + 1;
    }
    private int lowerBound(int target) {
        // [l, r) 中没有比target小的 返回0
        // [l, r) 中没有比target大的 返回r
        int l = 0, r = a.length;
        while(l < r) {
            int m = (l + r) >>> 1;
            if(a[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        // System.out.println(l);
        return l;
    }

    // 绑定下标实验
    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // [0, end)
        // 外层循环控制有边界
        // 每趟把最大的放在最后
        for (int end = arr.length - 1; end > 0; end--) {
            boolean flag = false;
            for (int i = 0; i < end; i++) {
                if (arr[idx[i]] > arr[idx[i + 1]]) {
                    flag = true;
                    swap(idx, i, i + 1);
                }
            }
            if(!flag) {
                break;
            }
        }
    }
    public static int lowbit(int x) {
        return x & (-x);
    }
    // 绑定下标
    public static void main(String[] args) {
        int[] a = new int[]{1,3,2,3,1};
        //idx:              0,1,2,3,4
        // arr[0] = 5
        // arr[1] = 3
        //
//        idx = new int[a.length];
//        for(int i = 0; i < a.length; i++) {
//            idx[i] = i;
//        }
//        bubbleSort(a);
//        System.out.println(Arrays.toString(idx));
//        List<Integer> list = new ArrayList<>();
//        list.add(0, 0);
//        list.add(1, 1);
//        System.out.println(list);
//        System.out.println(countSmaller(a));
//        System.out.println(lowbit(5));
        String c = "c";
        String b = "b";
        System.out.println(c + b);
        String[] s = c.split("c");
        System.out.println(s[0]);
    }
}
