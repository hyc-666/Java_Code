package thread.safe;

/**
 * @author hyc
 * @date 2020/7/31
 */
//线程的安全性问题解决

import javafx.beans.binding.ObjectBinding;

/**
 * 方法一：同步代码块
 * 格式：
 *   synchronized(同步监视器){
 *      需要同步的代码
 *   }
 *
 *   解释：
 *   同步监视器：俗称锁，是任何一个类的对象都可以作为同步监视器
 *   要求是操作共享数据的线程都必须使用同一把锁
 *
 *   补充：
 *   同步监视器也可以使用某个类来充当，而且也是唯一的，类也是对象，并且一个类只会加载一次
 *
 *   方法二：同步方法
 *   通过将操作贡献数据的操作声明为一个同步方法，在声明中并没有显式的出现锁，但是也是有的
 *   在实现Runnable接口创建的线程里，默认使用this作为锁，但是在继承自Thread类创建的
 *   线程里，由于关键字this在这种情况下不唯一，因此锁是无效的，在这种情况下，一般将同步方法声明为静态方法
 *   此时的锁是这个类本身，是唯一的。
 *
 */
public class Window implements Runnable {
    private int ticket = 100;

//    Object obj = new Object();//作为同步锁来使用

    @Override
    public void run() {
        while (true) {
            //在这里加上同步代码块
            synchronized (this) { //这里，可以直接使用当前对象来作为唯一的锁，
                //在这个场景下， 这里的对象是动态获取的，但是也是唯一的
                //如果是使用继承自Thread类则可能不唯一

                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
class Test{
    public static void main(String[] args) {
        Window w = new Window();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}