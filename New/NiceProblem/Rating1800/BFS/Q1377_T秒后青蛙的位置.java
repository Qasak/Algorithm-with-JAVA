package leetcode.contest.Rating1800.BFS;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/19 9:59
 */
public class Q1377_T秒后青蛙的位置 {
    class Solution {
        public double frogPosition(int n, int[][] edges, int t, int target) {
            // if(target == 1) {
            //     return 0.0;
            // }
            if(edges.length == 0) {
                return 1.0;
            }
            // 点：能到的点
            Map<Integer, List<Integer>> map = new HashMap<>();
            for(int[] edge : edges) {
                map.putIfAbsent(edge[0], new ArrayList<>());
                map.putIfAbsent(edge[1], new ArrayList<>());
                map.get(edge[0]).add(edge[1]);
                map.get(edge[1]).add(edge[0]);
            }


            Deque<Integer> q = new LinkedList<>();
            q.offer(1);

            // 点：概率
            Map<Integer, Double> prob = new HashMap<>();
            prob.put(1, 1.0);

            // 已经访问
            Set<Integer> vis = new HashSet<>();
            vis.add(1);

            while(t-- > 0 && !q.isEmpty()) {
                int size = q.size();
                while(size-- > 0) {
                    int node = q.poll();

                    List<Integer> list = new ArrayList<>();
                    for(int sub : map.getOrDefault(node, new ArrayList<>())) {
                        if(!vis.contains(sub)) {
                            vis.add(sub);
                            q.offer(sub);
                            list.add(sub);
                        }
                    }
                    for(int sub: list) {
                        prob.put(sub, prob.get(node) / list.size());
                        if((t == 0 || map.get(sub).size() == 1) && sub == target) {
                            return prob.get(sub);
                        }
                    }
                }
            }
            return 0.0;
        }
    }
}
