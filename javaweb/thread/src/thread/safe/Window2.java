package thread.safe;

/**
 * @author hyc
 * @date 2020/8/1
 */
//这个类继承自Thread类
public class Window2 extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    private static synchronized void show(){//需要将方法声明为静态方法才能使得锁唯一
//    private synchronized void show() {//这种情况下，由于下文有t1，t2，t3三个对象，因此这里的锁不唯一
        if (ticket > 0) {
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": " + ticket);
            ticket--;
        }
    }
}

class Test2{
    public static void main(String[] args) {
        Thread t1 = new Window2();
        Thread t2 = new Window2();
        Thread t3 = new Window2();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}