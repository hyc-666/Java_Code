package thread.demo;

/**
 * @author hyc
 * @date 2020/7/31
 */
//方法二，通过实现Runnable接口来创建线程，讲Runnable作为线程构造参数传进去
public class Demo2 implements Runnable {
    private int ticket = 100;
    @Override
    public void run() {

        while (true){

            if (ticket > 0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ": " + ticket);
                ticket--;
            }else{
                break;
            }
        }
    }
}
class Test2{
    public static void main(String[] args) {
        Runnable t = new Demo2();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}