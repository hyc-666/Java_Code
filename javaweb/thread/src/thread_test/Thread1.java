package thread_test;

/**
 * @author hyc
 * @date 2020/5/14
 **/
public class Thread1 {
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(999999999999L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"thread1").start();
        Thread.sleep(999999999999L);
    }
}
