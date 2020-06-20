package javawebTest;

/**
 * @author hyc
 * @date 2020/6/20
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * ■题目描述
 * 给定一个不含有重复值的数组arr,找到每-个i位置左边和右边离i位置最近且值
 * 比arr[i]小的位置。返回所有位置相应的信息。
 * 输入描述:
 * 第一行输入一个数字n,表示数组arr的长度。
 * 以下一行输出n个数字，表示数组的值。
 * 输出描述:
 * 输出n行，每行两个数字L和R，如果不存在，则值为-1，下标从0开始。
 */
public class Main2 {
    //擦，题目看错， 说的是位置不是具体值
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            int[][] result = getArr(arr);
            for (int[] item : result){
                System.out.println(item[0] + " " + item[1]);
            }
        }
    }
    public static int[][] getArr(int[] arr){
        int n = arr.length;
        int[][] resArr = new int[n][2];
        for (int[] item : resArr){
            Arrays.fill(item,-1);
        }
        for (int i = 0; i < n; i++) {
            int l = i - 1;
            while (l >= 0){//先找左边
                if (arr[l] < arr[i]){
                    resArr[i][0] = l;
                    break;
                }
                l--;
            }
            int r = i + 1;
            while (r < n){
                if (arr[r] < arr[i]){
                    resArr[i][1] = r;
                    break;
                }
                r++;
            }
        }
        return resArr;
    }
}
