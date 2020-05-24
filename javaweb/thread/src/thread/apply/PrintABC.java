package thread.apply;
/**
 * @author hyc
 * @date 2020/5/24
 */
public class PrintABC {
    /**
     * 有三个线程，只能单独的打印ABC，现在要使者三个线程同时运行
     * 要求有序的打印出ABC
     */
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Print("A",null));
        Thread t2 = new Thread(new Print("B",t1));
        Thread t3 = new Thread(new Print("C",t2));
        t1.start();
        t2.start();
        t3.start();
    }

    private static class Print implements Runnable{
        private String str;
        private Thread t;

        public Print(String str, Thread t) {
            this.str = str;
            this.t = t;
        }

        @Override
        public void run() {
            try{
                if (t != null){
                    t.join();
                }
                System.out.println(str);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
