package xiaoyu.single;

/**
 * @author hyc
 * @date 2020/10/22
 */
public class Singleton {
    private static volatile Singleton instance;
    private Singleton(){

    }
//    static {
//        instance = new Singleton();
//    }
    public static Singleton getInstance(){
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
