package leetcode.template.Hash;

import java.io.*;
import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/18 13:38
 */
public class Q632_SmallestRange {
    // 超时
    public static int[] smallestRange(List<List<Integer>> nums) {
        // 5 20
        // 列表id: 出现次数
        Map<Integer, Integer> window = new HashMap<>();
        // 值: 出现过的列表ids
        Map<Integer, List<Integer>> map = new HashMap<>();
        // pq: 所有的值
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 外层：扫所有列表
        // 内层：每个值 ： 当前列表id
        for(int i = 0; i < nums.size(); i++) {
            window.put(i, 0);
            for(int j: nums.get(i) ) {
                if(!map.containsKey(j)) {
                    map.put(j, new ArrayList<>());
                }
                map.get(j).add(i);
                pq.add(j);
            }
        }
        int[] ans = {-100001, 100001};
        int[] tmp = new int[pq.size()];
        int idx = 0;
        while(!pq.isEmpty()) {
            tmp[idx++] = pq.poll();
        }
        int l = 0;
        //0 4 5 9 10 12 15 18 20 22 24 26 30
        for(int i = 0; i < tmp.length; i++) {
            for(int id: map.get(tmp[i])) {
                window.put(id, window.get(id) + 1);
                // System.out.println(window);
            }
            // System.out.println(tmp[i]);

            while(check(window)) {
                // System.out.println(tmp[l] + " " + tmp[i]);
                if(tmp[i] - tmp[l] < ans[1] - ans[0]) {
                    ans[0] = tmp[l];
                    ans[1] = tmp[i];
                }
                for(int id: map.get(tmp[l++])) {
                    window.put(id, window.get(id) - 1);
                }
            }

        }
        return ans;
    }
    private static boolean check(Map<Integer, Integer> window) {
        for(int j : window.values()) {
            if(j == 0) {
                return false;
            }
        }
        return true;
    }
    public static int[] smallestRange1(List<List<Integer>> nums) {
//        if(nums.size() >= 3192) {
//            return new int[]{99999, 100000};
//        }
        // 5 20
        // 列表id: 出现次数
        Map<Integer, Integer> window = new HashMap<>();
        // 值: 出现过的列表ids
        Map<Integer, List<Integer>> map = new HashMap<>();
        // pq: 所有的值
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 外层：扫所有列表
        // 内层：每个值 ： 当前列表id
        for(int i = 0; i < nums.size(); i++) {
            window.put(i, 0);
            for(int j: nums.get(i) ) {
                if(!map.containsKey(j)) {
                    map.put(j, new ArrayList<>());
                }
                map.get(j).add(i);
                pq.add(j);
            }
        }
        int[] ans = {-100001, 100001};
        int[] tmp = new int[pq.size()];
        int idx = 0;
        while(!pq.isEmpty()) {
            tmp[idx++] = pq.poll();
        }
        int l = 0;
        int need = nums.size();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < tmp.length; i++) {
            for(int id: map.get(tmp[i])) {
                window.put(id, window.get(id) + 1);
                if(set.add(id)) {
                    need--;
                }
            }
            while(need == 0) {
                System.out.println(set.size());
                if(tmp[i] - tmp[l] < ans[1] - ans[0]) {
                    ans[0] = tmp[l];
                    ans[1] = tmp[i];
                }
                for(int id: map.get(tmp[l++])) {
                    window.put(id, window.get(id) - 1);
                    if(window.get(id) == 0) {
                        set.remove(id);
                        need++;
                    }
                }
            }
        }
        return ans;
    }
    // 用pair代替map<Integer, List<Integer>>
    public int[] smallestRange2(List<List<Integer>> nums) {
        //记录答案
        //将nums合并到一个数组，该数组用all表示
        List<Pair> all = new ArrayList<>();
        //用来在滑动窗口的时候记录哪个数组出现的次数
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0 ; i<nums.size() ; i++){
            for(int num : nums.get(i)){
                all.add(new Pair(num, i));
            }
        }
        //对all数组排序
        all.sort((a, b) -> a.num - b.num);
        //滑动窗口
        int left = 0 , right = 0;
        int n = all.size();
        int[] ans = new int[]{-100001, 100001};
        int need = nums.size();
        while(right < n){
            //增加right
            Pair cur = all.get(right);
            if(!map.containsKey(cur.idx)){
                need--;
                map.put(cur.idx,0);
            }
            map.put(cur.idx,map.get(cur.idx)+1);
            //缩小left区间找最小。能缩小的条件是当前cnt == k
            while(need == 0  && left <= right){
                if(ans[1] - ans[0] > all.get(right).num-all.get(left).num){
                    ans[0] = all.get(left).num;
                    ans[1] = all.get(right).num;
                }
                map.put(all.get(left).idx,map.get(all.get(left).idx)-1);
                if(map.get(all.get(left).idx) == 0){
                    need++;
                    map.remove(all.get(left).idx);
                }
                left++;
            }
            right++;
        }
        return ans;
    }
    static class Pair{
        int num;
        int idx;
        public Pair(int num , int idx){
            this.num = num;
            this.idx = idx;
        }
    }
    public static void main(String[] args) throws IOException {
        String path = "C:/Users/qasak/Desktop/case.txt";
        String encoding = "UTF-8";
        InputStreamReader read =  new InputStreamReader(new FileInputStream(path), encoding);
        BufferedReader bufferedReader = new BufferedReader(read);
        String t = bufferedReader.readLine();
        int l = 1, r = 2;
        List<List<Integer>> in = new ArrayList<>();
        while(r < t.length() - 1 && l < r) {
            while(r < t.length() - 1 && t.charAt(r) != ']') {
                r++;
            }

            String s = t.substring(l + 1, r);

            String[] tmp = s.split(",");
            List<Integer> list = new ArrayList<>();
            for(String s1: tmp) {
                list.add(Integer.valueOf(s1));
            }
            in.add(list);
            l = r + 2;
            r += 3;
        }
        System.out.println(Arrays.toString(smallestRange1(in)));
    }
}
