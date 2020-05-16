package thread_test;

/**
 * @author hyc
 * @date 2020/5/16
 **/
public class Lesson2thread {
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {
            final int j = i;
            threads[i] = new  Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(j);
                }
            });
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        System.out.println("main");
    }
}
