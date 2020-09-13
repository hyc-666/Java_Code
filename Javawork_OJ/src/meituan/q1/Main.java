package meituan.q1;

import java.util.Scanner;

/**
 * @author hyc
 * @date 2020/9/13
 */
public class Main {
    public static void main(String[] args) {
        //读入矩阵
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }
            //查看这个矩阵是否是对称的
            while (isMin(arr,n,m)){
                n = n / 2;
            }
            //输出新的n * m 的矩阵
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
    //写一个方法来判断这个矩阵是不是对称的
    public static boolean isMin(int[][] arr,int n,int m){
        int mid = n / 2;
//        //判断mid是否为奇数,如果奇数则mid行是对称轴
//        if (mid % 2 != 0){
//            return false;
//        }
        //而按照规则变换时则不可能出现奇数的情况,所以mid为奇数的时候一定就是最原始的矩阵
        //依次判断第0行的数据是否和第最后行的数据是否相同,如果有不同则不是上下对称,返回false
        for (int i = 0; i < mid; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != arr[n - i - 1][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
