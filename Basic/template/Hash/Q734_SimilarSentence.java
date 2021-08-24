package leetcode.template.Hash;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/18 13:01
 */
public class Q734_SimilarSentence {
    public boolean areSentencesSimilar(String[] s1, String[] s2, List<List<String>> p) {
        int n = s1.length;
        int m = s2.length;
        if(n != m) {
            return false;
        }
        Map<String, Set<String>> wordToIdx = new HashMap<>();
        for(int i = 0; i < p.size(); i++) {
            wordToIdx.putIfAbsent(p.get(i).get(0), new HashSet<>());
            wordToIdx.get(p.get(i).get(0)).add(p.get(i).get(1));
            wordToIdx.putIfAbsent(p.get(i).get(1), new HashSet<>());
            wordToIdx.get(p.get(i).get(1)).add(p.get(i).get(0));
        }
        for(int i = 0; i < n; i++) {
            if(s1[i].equals(s2[i])) {
                continue;
            }
            if(wordToIdx.containsKey(s1[i])) {
                if( !( wordToIdx.get(s1[i]).contains(s2[i]) &&
                        wordToIdx.get(s2[i]).contains(s1[i]) ) ) {
                    return false;
                }
            } else {
                if(!s1[i].equals(s2[i])) {
                    return false;
                }
            }
        }
        return true;
    }
    // 更好的判断逻辑
    public boolean areSentencesSimilar1(String[] s1, String[] s2, List<List<String>> p) {
        int n = s1.length;
        int m = s2.length;
        if(n != m) {
            return false;
        }
        Map<String, Set<String>> map = new HashMap<>();
        for(int i = 0; i < p.size(); i++) {
            map.putIfAbsent(p.get(i).get(0), new HashSet<>());
            map.get(p.get(i).get(0)).add(p.get(i).get(1));
            map.putIfAbsent(p.get(i).get(1), new HashSet<>());
            map.get(p.get(i).get(1)).add(p.get(i).get(0));
        }
        for(int i = 0; i < n; i++) {
            if(s1[i].equals(s2[i])) {
                continue;
            }
            // 两个单词不相等:必须在map里面找
            //
            if(!map.containsKey(s1[i]) || !map.containsKey(s2[i])) {
                return false;
            }
            if(!map.get(s1[i]).contains(s2[i]) && !map.get(s2[i]).contains(s1[i])) {
                return false;
            }
        }
        return true;
    }
}
