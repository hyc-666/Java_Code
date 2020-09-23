package qunaer.q1;

import java.util.Scanner;

/**
 * @author hyc
 * @date 2020/9/23
 */
public class Main {
    public static void main(String[] args) {
        //使用排列组合即可完成任务
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            System.out.println(pai(m,n));
        }
    }
    //下面这个使用排列组合公式用来计算排列组和结果
    //sum = n!/m!(n-m)!
    public static int pai(int n,int m){
        if (n < 0 || m < 0){
            return 0;
        }
        if (n < m){
            return 1;
        }
        return jie(n) / ((jie(m) * jie(n - m)));
    }
    //计算阶乘
    public static int jie(int n){
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }
}
