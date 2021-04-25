package leetcode.SpringRecruit.并发.线程交替执行;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */
public class Q1242_多线程网页爬虫_DFS_BFS手动创建线程 {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        ConcurrentMap<String, Boolean> map = new ConcurrentHashMap<>();
        String host = Worker.getHost(startUrl);
        map.put(startUrl, true);
        Worker w = new Worker(startUrl, host, htmlParser);
        Worker.map = map;
        Thread t = new Thread(w);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(map.keySet());
    }
}
class Worker implements Runnable {
    String url;
    String host;
    HtmlParser htmlParser;
    public static ConcurrentMap<String, Boolean> map;
    public Worker(String url, String host, HtmlParser htmlParser) {
        this.url = url;
        this.host = host;
        this.htmlParser = htmlParser;
    }
    @Override
    public void run() {
        map.put(url, true);
        List<String> urls = htmlParser.getUrls(url);
        List<Thread> threads = new ArrayList<>(urls.size());
        for(String s : urls) {
            if(!host.equals(getHost(s)) || map.containsKey(s)) {
                continue;
            }
            Thread t = new Thread(new Worker(s, host, htmlParser));
            threads.add(t);
            t.start();
        }
        joinThread(threads);
    }
    public void joinThread(List<Thread> threads) {
        for(Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static String getHost(String startUrl) {
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
}