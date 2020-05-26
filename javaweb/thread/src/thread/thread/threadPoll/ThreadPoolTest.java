package thread.thread.threadPoll;
//Java线程池

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author hyc
 * @date 2020/5/26
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                4,//核心线程数
                10,//最大线程数
                60L,//空闲时间
                TimeUnit.SECONDS,//空闲时间单位
                new ArrayBlockingQueue<>(100),//阻塞队列，存放线程的队列
                new ThreadFactory(){//线程创建工厂
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r);
                    }
                },
                //拒绝策略
//                new ThreadPoolExecutor.AbortPolicy()
//                new ThreadPoolExecutor.CallerRunsPolicy()
//                new ThreadPoolExecutor.DiscardOldestPolicy()
                new ThreadPoolExecutor.DiscardPolicy()
        );
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("送快递到北京");
            }
        });
    }
}
