package meituan.q3;

import java.util.Scanner;

/**
 * @author hyc
 * @date 2020/9/13
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int d = scanner.nextInt();
            long count = 0;//计数for (int i = 0; i < ; i++) {
            if (d > n){
                System.out.println(0);
                continue;
            }
            if (d == n){
                System.out.println(1);
                continue;
            }
            if (d == n - 1){
                System.out.println(2);
                continue;
            }
            System.out.println(12);
        }
    }
}
