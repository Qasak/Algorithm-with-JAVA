package leetcode.SpringRecruit.并发.线程交替执行;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/8 22:39
 */
public class Q1242_多线程网页爬虫_ThreadPoolExecutor {
    class HtmlParser {
        public List<String> getUrls(String s) {
            return new ArrayList<>();
        }
    }
    class Solution {
        class Worker implements Runnable {
            String url;
            ConcurrentMap<String, Boolean> ans;
            ConcurrentLinkedDeque<String> q;
            String host;
            AtomicInteger cnt;
            ThreadPoolExecutor executor;
            HtmlParser htmlParser;
            public Worker(String url, ConcurrentMap<String, Boolean> ans, ConcurrentLinkedDeque<String> q, String host, AtomicInteger cnt, ThreadPoolExecutor executor, HtmlParser htmlParser) {
                this.url = url;
                this.ans = ans;
                this.q = q;
                this.host = host;
                this.cnt = cnt;
                this.executor = executor;
                this.htmlParser = htmlParser;
            }
            @Override
            public void run() {
                if(!host.equals(getHost(url)) || ans.containsKey(url)) {
                    cnt.getAndDecrement();
                    return;
                }
                List<String> children = htmlParser.getUrls(url);
                for(String s : children) {
                    // System.out.println(s);
                    cnt.getAndIncrement();
                    executor.execute(new Worker(s, ans, q, host, cnt, executor, htmlParser));
                }
                ans.put(url, true);
                q.offer(url);
                cnt.getAndDecrement();
            }
        }

        public List<String> crawl(String startUrl, HtmlParser htmlParser) {
            ConcurrentMap<String, Boolean> ans = new ConcurrentHashMap<>();
            ConcurrentLinkedDeque<String> q = new ConcurrentLinkedDeque<>();
            String host = getHost(startUrl);
            ans.put(startUrl, true);
            AtomicInteger cnt = new AtomicInteger(0);
            ThreadPoolExecutor executor = new ThreadPoolExecutor(
                    200,
                    2000,
                    2000,
                    TimeUnit.MILLISECONDS,
                    new ArrayBlockingQueue<>(200000),
                    Executors.defaultThreadFactory());
            List<String> layer1 = htmlParser.getUrls(startUrl);
            for(String s : layer1) {
                if(!host.equals(getHost(s))) {
                    continue;
                }
                q.offer(s);
            }
            while(!q.isEmpty() || cnt.get() != 0) {
                if(q.isEmpty()) {
                    continue;
                }
                // System.out.println(q);
                String t = q.poll();
                // 线程池
                cnt.getAndIncrement();
                executor.execute(new Worker(t, ans, q, host, cnt, executor, htmlParser));


                // 手动开线程
                // int n = children.size();
                // Thread[] tt = new Thread[n];
                // for(int i = 0; i < n; i++) {
                //     tt[i] = new Thread(new Worker(children.get(i), ans, q, host));
                //     tt[i].start();
                // }
                // for(int i = 0; i < n; i++) {
                //     try {
                //         tt[i].join();
                //     } catch (InterruptedException e) {

                //     }
                // }

                // 单线程
//            for(String s : children) {
//                if(!host.equals(getHost(s)) || ans.containsKey(s)) {
//                    continue;
//                }
//                ans.put(s, true);
//                q.offer(s);
//            }
            }
            executor.shutdown();
            while(true) {
                if(executor.isShutdown()) {
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return new ArrayList<>(ans.keySet());
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
    }
}
