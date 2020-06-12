package everyDayQuestion._0610;

import java.util.Scanner;

/**
 * @author hyc
 * @date 2020/6/10
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
            long sum = factorial(n);//计算阶乘
            String str = sum + "";
            int count = 0;
            for (int i = str.length() - 1; i >= 0; i--) {
                if (str.charAt(i) == '0'){
                    count++;
                }else{
                    break;
                }
            }
//            System.out.println(sum);
//            while (sum % 10 == 0){
//                count++;
//                sum = sum / 10;
//            }
            System.out.println(count);
        }
    }
    public static long factorial(int n){
        long sum = 1L;
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }
        return sum;
    }
}
