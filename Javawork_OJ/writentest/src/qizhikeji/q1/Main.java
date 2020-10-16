package qizhikeji.q1;

/**
 * @author hyc
 * @date 2020/10/14
 */
public class Main {
    public static void main(String[] args) {
        //输出101到200之间的素数
        int count = 0;//用于统计有多少个素数
        for (int i = 101; i < 200; i++) {
            if (isPrime(i)){
                count++;
                //是素数就输出,并记录
                System.out.println(i);
            }
            System.out.println("一共有 " + count + "个素数");
        }
    }
    //用于判断是否素数
    public static boolean isPrime(int num){
        if (num == 0){//这个题目里面可以不用判断0,1,2
            return false;
        }
        if (num == 1){
            return false;
        }
        if (num == 2){
            return true;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
}
