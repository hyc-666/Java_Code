package thread.threadPool;

import java.util.concurrent.*;

/**
 * 使用线程池创建你多线程
 *
 * @author hyc
 * @date 2020/8/10
 */
public class ThreadPool {
    public static void main(String[] args) {
//        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        //这里可以指定一些参数
        //其中，ExecutorService是一个接口，不好设置属性
//        System.out.println(service.getClass());//查看service的类
        //service的类型是ThreadPoolExecutor，因此可以直接在申明的时候直接声明为ThreadPoolExecutor，比如
//        ThreadPoolExecutor service = Executors.newFixedThreadPool(10);
        //也可以加强制类型转换
//        ThreadPoolExecutor service = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);;
        /**
         * ThreadPoolExecutor的一些参数说明
         * corePoolSize:核心线程池数
         * keepAliveTime:线程没有任务时等待的最长时间
         * maximumPoolSize:最大线程数
         */
//        service.setCorePoolSize(5);
//        service.setKeepAliveTime();
//        service.setMaximumPoolSize(20);

        Printer printer = new Printer();

        FutureTask<Integer> futureTask = new FutureTask<Integer>(printer);

        service.submit(futureTask);//submit适合执行call实现的线程
        service.execute(printer);//execute适合执行Runnable实现的线程

        service.shutdown();//shutdown方法关闭线程池
    }
}
class Printer implements Runnable, Callable<Integer>{

    @Override
    public void run() {
        //任务一遍历100以内的偶数
        for (int i = 0; i <= 100; i += 2) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }

    @Override
    public Integer call() throws Exception {
        //任务2遍历100以内奇数
        for (int i = 1; i < 100; i += 2) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
        return null;
    }
}