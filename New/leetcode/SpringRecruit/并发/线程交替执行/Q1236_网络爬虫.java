package leetcode.SpringRecruit.并发.线程交替执行;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Q1236_网络爬虫 {

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        Set<String> ans = new HashSet<>();
        Deque<String> q = new LinkedList<>();
        String host = getHost(startUrl);
        q.offer(startUrl);
        ans.add(startUrl);
        while(!q.isEmpty()) {
            String t = q.poll();
            List<String> children = htmlParser.getUrls(t);
            for(String s : children) {
                if(!host.equals(getHost(s)) || ans.contains(s)) {
                    continue;
                }
                ans.add(s);
                q.offer(s);
            }
        }
        return new ArrayList<>(ans);
    }
    public String getHost(String startUrl) {
        int n = startUrl.length();
        int i = 7;
        while(i < n) {
            if(startUrl.charAt(i) == '/') {
                break;
            }
            i++;
        }
        return startUrl.substring(7, i);
    }

    public static void main(String[] args) {
        ConcurrentLinkedDeque<String> q = new ConcurrentLinkedDeque<>();
    }
}
