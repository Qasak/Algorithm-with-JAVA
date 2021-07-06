package leetcode.contest.NiceProblem.CRUD技巧;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/6 15:58
 */
public class Q535_TinyURL的加密与解密 {
    Map<String, String> map = new HashMap<>();
    Random rand = new Random();
    String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    // Encodes a URL to a shortened URL.
    public String getKey() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 6; i++) {
            sb.append(alphabet.charAt(rand.nextInt(62)));
        }
        return sb.toString();
    }
    public String encode(String longUrl) {
        String id = "";
        do {
            id = getKey();
        } while(map.containsKey(id));
        map.put(id, longUrl);
        return "http://tinyurl.com/" + id;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        // System.out.println(shortUrl);
        return map.get(shortUrl.replace("http://tinyurl.com/", ""));
    }
    public static void main(String[] args) {

        // String的hashCode计算方法: s[0] * 31^(n - 1) + s[1] * 31^(n - 2)
        String a = "111111111111111111";
        System.out.println((int)('1'));
        System.out.println(a.hashCode());
    }
}
