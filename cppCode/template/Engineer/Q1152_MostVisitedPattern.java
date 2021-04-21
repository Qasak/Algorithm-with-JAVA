package leetcode.template.Engineer;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/30 16:54
 */
class Q1152_MostVisitedPattern {
    public List<String> mostVisitedPattern1(String[] username, int[] timestamp, String[] website) {
        List<String[]> list = new ArrayList<>();
        for(int i = 0; i < timestamp.length; i++)  {
            String[] temp = new String[3];
            temp[0] = username[i];
            temp[1] = timestamp[i] + "";
            temp[2] = website[i];
            list.add(temp);
        }

        list.sort((a, b) -> Integer.parseInt(a[1]) - Integer.parseInt(b[1]));
        Map<String, List<String>> map = new HashMap<>();
        for(String[] arr: list) {
            map.putIfAbsent(arr[0], new ArrayList<>());
            map.get(arr[0]).add(arr[2]);
        }

        Map<String, Integer> count = new HashMap<>();
        int max = 0;
        String s = "";
        for(String name: map.keySet())  {
            List<String> temp = map.get(name);
            if(temp.size() < 3) {
                continue;
            }
            Set<String> set = new HashSet<>();
            for(int i = 0; i < temp.size() - 2; i++) {
                for(int j = i + 1; j < temp.size() - 1; j++) {
                    for(int k = j + 1; k < temp.size(); k++) {
                        set.add(temp.get(i) + "," + temp.get(j) + "," + temp.get(k));
                    }
                }
            }
            for(String str: set) {
                count.put(str, count.getOrDefault(str, 0) + 1);
                if(count.get(str) > max) {
                    max = count.get(str);
                    s = str;
                }
                else if(count.get(str) == max) {
                    if(str.compareTo(s) < 0) {
                        s = str;
                    }
                }
            }
        }
        return Arrays.asList(s.split(","));
    }



    class Log {
        String name;
        int timeStamp;
        String webSite;
        public Log(String n, int t, String w) {
            this.name = n;
            this.timeStamp = t;
            this.webSite = w;
        }
    }
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int n = username.length;
        Log[] logs = new Log[n];
        for(int i = 0; i < n; i++) {
            logs[i] = new Log(username[i], timestamp[i], website[i]);
        }
        Arrays.sort(logs, (a, b) -> a.timeStamp - b.timeStamp);


        Map<String, ArrayList<String>> map = new HashMap<>();
        for(Log l: logs) {
            map.putIfAbsent(l.name, new ArrayList<>());
            map.get(l.name).add(l.webSite);
        }
        int maxCnt = 0;
        String ans = null;
        Map<String, Integer> cnt = new HashMap<>();
        for(String name : map.keySet()) {
            ArrayList<String> t = map.get(name);
            Set<String> set = new HashSet<>();
            if(t.size() < 3) {
                continue;
            }
            int m = t.size();
            for (int i = 0; i < m - 2; i++) {
                for (int j = i + 1; j < m - 1; j++) {
                    for (int k = j + 1; k < m; k++) {
                        set.add(t.get(i) + "," + t.get(j) + "," + t.get(k));
                    }
                }
            }
            for(String s: set) {
                cnt.putIfAbsent(s, 0);
                cnt.put(s, cnt.get(s) + 1);
            }
        }
        for(String s: cnt.keySet()) {
            if(cnt.get(s) > maxCnt) {
                maxCnt = cnt.get(s);
                ans = s;
            } else if(cnt.get(s) == maxCnt) {
                ans = ans.compareTo(s) < 0 ? ans : s;
            }
        }
        return Arrays.asList(ans.split(","));
    }
    public List<String> mostVisitedPattern3(String[] username, int[] timestamp, String[] website) {
        Map<String, Integer> users = new HashMap<>();
        Map<String, Integer> sites = new HashMap<>();
        Map<Integer, Integer> times = new HashMap<>();
        String[] strings = website.clone();
        int[] ints = timestamp.clone();
        Arrays.sort(strings);
        Arrays.sort(ints);
        int n = username.length;

        for (int i = 0, j = 0; i < n; i++) {
            String u = username[i], s = strings[i];
            if (!users.containsKey(u)) {
                users.put(u, users.size());
            }
            if (!sites.containsKey(s)) {
                sites.put(s, sites.size());
                strings[j++] = s;
            }
            if (!times.containsKey(ints[i])) {
                times.put(ints[i], times.size());
            }
        }

        int sc = sites.size();
        int[] visits = new int[n];
        for (int i = 0; i < n; i++) {
            int u = users.get(username[i]);
            int t = times.get(timestamp[i]);
            int s = sites.get(website[i]);
            visits[i] = u << 12 | t << 6 | s;
        }

        Arrays.sort(visits);
        long[] seq = new long[sc * sc * sc];
        int bestSeq = -1, bestCount = 0;
        for (int i = 0; i < n; i++) {
            int v = visits[i], u = v >> 12, s1 = (v & 0x3f) * sc * sc;
            for (int k = i + 2; k < n && (visits[k] >> 12) == u; k++) {
                int s2 = s1 + (visits[k] & 0x3f);
                for (int j = i + 1; j < k; j++) {
                    int s = s2 + (visits[j] & 0x3f) * sc;
                    long f = 1L << u;
                    if ((seq[s] & f) == 0) {
                        int bc = Long.bitCount(seq[s] |= f);
                        if (bc > bestCount || bc == bestCount && s < bestSeq) {
                            bestCount = bc;
                            bestSeq = s;
                        }
                    }
                }
            }
        }
        return Arrays.asList(
                strings[bestSeq / sc / sc],
                strings[(bestSeq / sc) % sc],
                strings[bestSeq % sc]);
    }


    public static void main(String[] args) {
        String[] name = new String[]{"vvmuq","ik","vvmuq","ik","ik","ik","vvmuq","ik","ik","ik","ik","ik","ik","vvmuq","ik","ik","ik","ik","vvmuq","ik","vvmuq","vvmuq","ik","ik","vvmuq","ik","ik","vvmuq","ik","vvmuq","ik","ik","ik","ik","ik","ik","vvmuq","ik","ik","vvmuq","ik","ik","ik","ik","vvmuq","ik","vvmuq","ik"};
        int[] time = new int[]{737116207,404491249,163392926,547826228,247036655,161878059,119469501,284431940,619942148,843353597,476779662,68349233,157693127,910502248,428410180,725978547,290017537,486408630,450590323,363612173,457001318,402405956,837215004,566391149,172783421,484369534,421422273,425711796,186010241,776465464,433243528,996223233,32454685,380298053,532073728,855334928,30752426,609370747,67640612,505827481,223745957,51438114,90204420,540298878,82670951,420671014,502588374,971108794};
        String[] web = new String[]{"lhuylcfsee","uljtaq","ztvoafcxbr","lpxep","lpxep","p","aeittp","yzmvwewgh","jyaggkh","x","nirindikx","zhng","jyaggkh","ctxtsjeo","iaoxch","lhuylcfsee","jyaggkh","ctxtsjeo","rv","dzsyauevy","hfgglj","hfgglj","hfgglj","zhng","zhng","zhng","nxb","oxzxzhy","ztvoafcxbr","iaoxch","aeittp","x","bwkmavorzr","g","nirindikx","lpxep","dzsyauevy","pudqbeneuo","nxb","iaoxch","bjfykhkio","g","iaoxch","yxh","pudqbeneuo","svaa","rv","pb"};
        Q1152_MostVisitedPattern q = new Q1152_MostVisitedPattern();
        System.out.println(q.mostVisitedPattern(name,time, web));
    }
}

