package lesson3;

/**
 * @author hyc
 * @date 2020/5/17
 */
public class UnsafeThread {
    private static int SUM = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        SUM++;
                    }
                }
            }).start();
        }
        while (Thread.activeCount() > 1){ //idea中需要debug运行，否则改为2
            Thread.yield();
        }
        System.out.println(SUM);
    }
}
