package thread.demo;

/**
 * @author hyc
 * @date 2020/7/31
 */

//线程的两种创建方式
    //1、创建类继承自Thread类，并且重写run方法
public class Demo1 extends Thread{
    //比如有三个窗口买票
    private static int ticket = 100;
    @Override
    public void run() {
        while (true){
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (ticket > 0) {
                System.out.println(getName() + ": " + ticket);
                ticket--;
            }else{
                break;
            }
        }
    }
}
class Test1{
    public static void main(String[] args) {
        //使用的呃时候创建自定义线程对象，调用start方法
        Thread t1 = new Demo1();
        Thread t2 = new Demo1();
        Thread  t3 = new Demo1();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}