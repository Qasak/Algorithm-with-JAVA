package leetcode.contest.NiceProblem;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/25 11:06
 */
public class Q127_单词接龙 {
    // 一次改一个位置：BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String s : wordList) {
            set.add(s);
        }
        if(!set.contains(endWord)) {
            return 0;
        }
        set.remove(beginWord);
        Deque<String> q = new LinkedList<>();
        q.offer(beginWord);
        int step = 1;
        while(!q.isEmpty()) {
            int n = q.size();
            for(int i = 0; i < n; i++) {
                String cur = q.poll();
                int m = cur.length();
                char[] cs = cur.toCharArray();
                for(int j = 0; j < m; j++) {
                    char p = cs[j];
                    for(int k = 0; k < 26; k++) {
                        cs[j] = (char) ('a' + k);
                        if(cs[j] != p) {
                            String tmp = new String(cs);
                            if(endWord.equals(tmp)) {
                                return step + 1;
                            }
                            if(set.contains(tmp)) {
                                set.remove(tmp);
                                q.offer(tmp);
                            }
                        }
                    }
                    cs[j] = p;
                }
            }
            step++;
        }
        return 0;
    }
}
