package thread.threadPool;
//自定义的线程池

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author hyc
 * @date 2020/5/26
 */
public class MyThreadPool {
    private BlockingQueue<Runnable> queue;

    /**
     * 自定义线程池
     * @param corePoolSize 核心线程数，且只有核心线程
     * @param capacity 阻塞队列的容量
     */
    public MyThreadPool(int corePoolSize,int capacity) {
        queue = new ArrayBlockingQueue<Runnable>(capacity);
        //创建线程并启动线程
        for (int i = 0; i < corePoolSize; i++) {
            new MyThread(queue).start();
        }
    }
    public void execute(Runnable task){
        try {
            queue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static class MyThread extends Thread{
        private BlockingQueue<Runnable> queue;

        public MyThread( BlockingQueue<Runnable> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                while (!queue.isEmpty()) {
                    Runnable task = queue.take();
                    task.run();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
