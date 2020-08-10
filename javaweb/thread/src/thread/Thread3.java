package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 第三种创建多线陈的方法：实现Callable接口，JDk5.0新增
 * 与runnable不同的是callable功能更强大，call方法可以带有返回值，可以抛异常
 * 还可以指定泛型，指定泛型后，泛型就是call方法返回值的类型
 *
 * @author hyc
 * @date 2020/8/10
 */
public class Thread3 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        //计算100以内奇数的和，并且返回
        int sum = 0;
        for (int i = 1; i <= 100; i ++) {
            sum += i;
        }
        //这里sum是int类型的，是基本类型，而返回值是Object类型
        //于实这里自动装箱，将int包装成为Integer类型，而Integer是Object的子类
        //Integer作为Object的子类返回，是可行的，可以体现出多态
        return sum;
    }
}
class TestThread3{
    public static void main(String[] args) {
        Thread3 t = new Thread3();
        //同样，Callable要借助于一个FutureTask类
        //同样，Futuretask也可以指定泛型
        FutureTask<Integer> task = new FutureTask<>(t);

        //并且FutureTask同样实现了Runnable接口，总之还是需要一个线程的
        //总是需要一个start方法来调用这个线程

        new Thread(task).start();

        //线程开始启动

        try {
            Integer value = task.get();
            //可以调用FutureTask的get方法来获得构造器里重写的Callable方法的call的返回值
            System.out.println(value);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}