import Others.RedPack;
import Others.RedPackage;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/30 13:20
 */
public class RedPackTest {
    @Test
    public void testDouble() {
        int n = 10;
        double total = 120;
        // 测试次数
        int times = 3999;
        double[] ans = new double[n];
        for(int m = 0; m < times; m++) {
            double sum = 0;
            RedPack r = new RedPack(n, total);
            for(int i = 0; i < n; i++) {
                double t = r.getRandomMoney();
                sum += t;
                ans[i] += t;
            }
            if(sum >= total) {
                System.out.println(sum);
            }
        }

        for (double s : ans) {
            double t = (double) Math.round(s / times * 10000) / 10000;
            System.out.print(t + " ");
        }
        System.out.println();
    }

    @Test
    public void testBigDecimal() {
        int n = 10;
        BigDecimal total = new BigDecimal(120);
        // 测试次数
        int times = 500;
        int cnt = 0;
        BigDecimal[] ans = new BigDecimal[n];
        for(int i = 0; i < n; i++) {
            ans[i] = new BigDecimal(0);
        }
        for(int m = 0; m < times; m++) {
            RedPackage r = new RedPackage(n, total);
            BigDecimal sum = new BigDecimal(0);
            for(int i = 0; i < n; i++) {
                BigDecimal t = r.getRandomMoney();
                sum = sum.add(t);
                ans[i] = ans[i].add(t);
            }
            if(sum.compareTo(total) == 0) {
                cnt++;
            }
        }
        System.out.println(cnt);
        for (BigDecimal s : ans) {
            BigDecimal t = s.divide(new BigDecimal(times), 2, BigDecimal.ROUND_HALF_UP);
            System.out.print(t + " ");
        }
    }

}
