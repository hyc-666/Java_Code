package thread.lesson4;
//线程安全的写法
/**
 * @author hyc
 * @date 2020/5/19
 */
public class SafeThread {
    static int SUM = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        increment();
                    }
                }
            }).start();
        }
        while (Thread.activeCount() > 1){
            Thread.yield();
        }
        System.out.println(SUM);
    }
    public static synchronized void increment(){
        SUM ++;
    }
}
