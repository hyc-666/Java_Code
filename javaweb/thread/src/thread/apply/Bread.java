package thread.apply;
//面包店业务模拟

import static java.lang.Thread.sleep;

/**
 * @author hyc
 * @date 2020/5/23
 */
public class Bread {
    /**
     * 假设某面包店呦数位师傅生产面包，同时有消费者可以消费面包，有一个共同的库存
     * 面包师傅每次生产三个面包，消费之一次消费一个
     * 假设最大库存量是100
     */
    private static int SUM;
    private static final int MAX_SIZE = 100;

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {//假设有五个面包师傅，
            //同时启动5个线程
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            synchronized (Bread.class) {
                                if (SUM + 3 > MAX_SIZE) {
                                    Bread.class.wait();
                                }else{
                                    SUM += 3;
                                    System.out.println(Thread.currentThread().getName() + "生产面包+3");
                                    System.out.println("剩余库存 = " + SUM);
                                    Bread.class.notify();
                                }
                            }
                            Thread.sleep(1000);
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            },"面包师傅" + "[" + i + "]").start();
        }
        //20个消费者，
        for (int i = 0; i < 20; i++) {
            //同时启动5个线程
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            synchronized (Bread.class) {
                                if (SUM <= 0) {
                                    Bread.class.wait();
                                } else {
                                    SUM--;
                                    System.out.println(Thread.currentThread().getName() + "面包-1");
                                    System.out.println("库存 = " + SUM);
                                    Bread.class.notify();
                                }
                            }
                            Thread.sleep(1000);
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            },"消费者" + "["+ i + "]").start();
        }
    }
}
