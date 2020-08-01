package thread.safesingleton;

import com.sun.org.apache.xalan.internal.xsltc.dom.SingletonIterator;

/**
 * 线程安全的单例模式--懒汉式
 *
 * @author hyc
 * @date 2020/8/1
 */
public class SingleTone {
    //构造器私有化
    private SingleTone(){

    }

    private static SingleTone instance = null;

//    public static synchronized SingleTone getInstance(){//可以直接将方法声明为同步静态方法
    public static SingleTone getInstance(){
        //实际中采用效率更高的方法
        if (instance == null) {
            synchronized (SingleTone.class) {
                instance = new SingleTone();
            }
        }
        return instance;
    }
}
