package wuba.q1;

import java.util.Scanner;

/**
 * @author hyc
 * @date 2020/9/14
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] array = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    array[i][j] = scanner.nextInt();
                }
            }
            System.out.println(num(array));
        }
    }
    //递归函数用来统计多少个1
    public static void dfs(int[][] arr,int i,int j){
        if (i < 0 || i == arr.length || j < 0 ||  j == arr[0].length || arr[i][j] == 0){
            return;
        }
        arr[i][j] = 0;
        int[] di = {0,0,1,-1};
        int[] dj = {1,-1,0,0};
        for (int index = 0;index < 4;index++){
            dfs(arr,i + di[index],j + dj[index]);
        }
        return;
    }
    public static int num(int[][] arr){
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1);{
                    ans++;
                    dfs(arr,i,j);
                }
            }
        }
        return ans;
    }
}
