package weibu.q1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author hyc
 * @date 2020/9/28
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(0.1 * 3 == 0.3);
        System.out.println(0.3 * 1 == 0.3);

        ExecutorService executorService = new ThreadPoolExecutor();
    }
}
