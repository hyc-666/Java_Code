package xiaoyu.single;

/**
 * @author hyc
 * @date 2020/10/22
 */
public class Singleton {
    private static Singleton instance;
    private Singleton(){

    }
//    static {
//        instance = new Singleton();
//    }
    public static Singleton getInstance(){
        synchronized (Singleton.class){
            if (instance == null){
                instance = new Singleton();
            }
        }
        return instance;
    }
}
