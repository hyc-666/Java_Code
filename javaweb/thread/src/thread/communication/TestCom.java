package thread.communication;

import javafx.scene.control.PasswordField;

/**
 * 线程间通信
 * 任务：创建两个线程交替打印1到100
 *
 * 方法说明
 * wait():一旦调用此方法，就会使得当前线程进入阻塞状态，并且会释放锁
 * notify():地方法会唤醒处于阻塞状态中的一个线程线程，如果有多个线程被阻塞，则会优先唤醒优先状态较高的线程
 * notifyAll()；会唤醒所有阻塞中的线程
 * 这三个方法都必须使用在同步代码块或者同步方法中，而且调用者必须是同步监视器。
 * @author hyc
 * @date 2020/8/8
 */
public class TestCom {
    public static void main(String[] args) {
        Printer p = new Printer();

        Thread t1 = new Thread(p);
        Thread t2 = new Thread(p);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}

class Printer implements Runnable{
    private int num = 1;
    @Override
    public void run() {
        while (true){
            synchronized (this) {//很奇怪，这里同步监视器如果写成Printer.class就不行，会出异常
                notify();//notify会唤醒阻塞中的线程
                if (num <= 100) {
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println(Thread.currentThread().getName() + ":" + num);
                    num++;
                    try {
                        //当前线程调用wait时会使得当前线程阻塞，并且会释放锁
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}