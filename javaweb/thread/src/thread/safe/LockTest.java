package thread.safe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 在JDK5.0里新加入了一种LOCK锁机制来解决线程安全性的问题
 *
 * @author hyc
 * @date 2020/8/8
 */
public class LockTest {
    public static void main(String[] args) {
        Windows w = new Windows();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");

        t1.start();
        t2.start();
        t3.start();
    }
}
class Windows implements Runnable {
    private int ticket = 100;
    //在这里需要加上一个lock锁
    private Lock lock = new ReentrantLock(true);//构造器有无参和有参
    //无参默认为false，指的是线程竞争是否公平

    @Override
    public void run() {
        while (true){
            try {
                lock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }finally {
                lock.unlock();
            }
        }
    }
}