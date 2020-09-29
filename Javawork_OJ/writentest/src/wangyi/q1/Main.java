package wangyi.q1;

import java.util.Scanner;

/**
 * @author hyc
 * @date 2020/9/27
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();//c组数据
        for (int i = 0; i < c; i++) {

            int n = scanner.nextInt();//n阶方阵
            int m = scanner.nextInt();//m次查询
            //得到这个蛇形方阵
            int[][] arr =getArr(n);
            for (int j = 0; j < m; j++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                System.out.println(arr[x][y]);
            }
            //开始查询
        }

//        int[][] arr = getArr(7);
//        for(int[] item : arr){
//            System.out.println(Arrays.toString(item));

    }
    //构建蛇形矩阵
    public static int[][] getArr(int n){
        int[][] arr = new int[n][n];
        //判断一共有几圈
        int circle = n / 2;
        //如果n是奇数，则中间还有一个数
        boolean forword = true;//顺时针为true
        boolean isOld = n % 2 != 0;
        int num = 1;

        for (int i = 0; i < circle; i++) {
            if (forword){
                for (int j = i; j < n - i - 1; j++) {//上边从左到右
                    arr[i][j] = num++;
                }
                for (int j = i; j < n - i - 1; j++) {//右边从上到下
                    arr[j][n - i - 1] = num++;
                }
                for (int j = n - i - 1; j > i; j--) {//下边从右到左
                    arr[n - i - 1][j] = num++;
                }
                for (int j = n - i - 1; j > i; j--) {//左边从下到上
                    arr[j][i] = num++;
                }
                forword = false;
            }else{
                for (int j = i; j < n - i - 1; j++) {//左边从上往下
                    arr[j][i] = num++;
                }
                for (int j = i; j < n - i - 1; j++) {//下面从左到右
                    arr[n - i - 1][j] = num++;
                }
                for (int j = n - i - 1; j > i; j--) {//右边从下到上
                    arr[j][n - i - 1] = num++;
                }
                for (int j = n - i - 1; j > i;j--) {//上边从右到左
                    arr[i][j] = num++;
                }
                forword = true;
            }
        }
        if (isOld){
            arr[circle][circle] = num;
        }
        return arr;
    }
}
