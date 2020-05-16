package thread_test;
//线程的创建方式
//1、通过继承Thread并且重写run方法
/**
 * @author hyc
 * @date 2020/5/16
 **/
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        new MyThread().start();
    }
}
