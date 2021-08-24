package leetcode.template.String;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/30 22:05
 */
public class Q748_ShortestCompleting {
    public String shortestCompletingWord(String s, String[] words) {
        StringBuilder t = new StringBuilder();
        int n = s.length();
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == ' ' || ('0' <= s.charAt(i) && s.charAt(i) <= '9')) {
                continue;
            } else {
                t.append(s.charAt(i));
            }
        }
        String a = t.toString().toLowerCase();
        String ans = "";
        int max = 1001;
        int[] cnt = new int[26];
        // System.out.println(a);
        for(int i = 0; i < a.length(); i++) {
            cnt[a.charAt(i) - 'a']++;
        }
        for(String str: words) {
            int[] cnt1 = new int[26];
            for(int i = 0; i < str.length(); i++) {
                cnt1[str.charAt(i) - 'a']++;
            }
            boolean flag = false;
            for(int i = 0; i < 26; i++) {
                if(cnt1[i] - cnt[i] < 0) {
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                if(str.length() < max) {
                    max = str.length();
                    ans = str;
                }
            }
        }
        return ans;
    }
    public String shortestCompletingWord1(String licensePlate, String[] words) {
        char[] arr =  licensePlate.replaceAll("\\d| ", "").toLowerCase().toCharArray(); //清洗licensePlate
        //补全词排序
        TreeSet<String> set = new TreeSet<>((o1, o2) -> o1.length() != o2.length() ? o1.length() - o2.length() : 1);

        for(String word : words) { //查找补全词
            boolean flag = true;
            String copyWord = word;
            for(int i = 0; i < arr.length; i++) {
                if(copyWord.indexOf(arr[i]) < 0) {
                    flag = false;
                }else{
                    copyWord =  copyWord.replaceFirst(arr[i] + "", "#");
                }
            }
            if(flag){
                set.add(word);
            }
        }

        return set.first(); //返回最短补全词
    }


    public String shortestCompletingWord3(String licensePlate, String[] words) {
        int[] target = count(licensePlate);
        String ans = "";
        for (String word: words)
            if ((word.length() < ans.length() || ans.length() == 0) &&
                    dominates(count(word.toLowerCase()), target))
                ans = word;
        return ans;
    }

    public boolean dominates(int[] count1, int[] count2) {
        for (int i = 0; i < 26; ++i)
            if (count1[i] < count2[i])
                return false;
        return true;
    }

    public int[] count(String word) {
        int[] ans = new int[26];
        for (char letter: word.toCharArray()){
            int index = Character.toLowerCase(letter) - 'a';
            if (0 <= index && index < 26)
                ans[index]++;
        }
        return ans;
    }


    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,2);
        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
            System.out.println(e);
        }
    }
}
