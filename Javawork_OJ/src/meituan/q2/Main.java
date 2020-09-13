package meituan.q2;

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
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            int count = 0;
            for (int i = 0; i < n - m + 1; i++) {
                if (isOK(arr,m,k,i)){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
    //写一个方案来判断连续的m个是不是符合要求
    public static boolean isOK(int[] arr,int m,int k,int index){
        for (int i = index; i < index + m; i++) {
            if (arr[i] < k){
                return false;
            }
        }
        return true;
    }
}
