package everyDayQuestion.july._0725;

/**
 * @author hyc
 * @date 2020/7/26
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述
 * 对于一个矩阵，请设计一个算法从左上角(mat[0][0])开始，顺时针打印矩阵元素。
 * 给定int矩阵mat以及它的维数nxm,请返回一个数组，数组中的元素为矩阵元素的顺时
 * 针输出。
 * 测试样例:
 * [[1,2], [3,4]],2,2
 * 返回: [1,2,4,3]
 */
public class Printer {
    public int[] clockwisePrint(int[][] mat, int n, int m) {
        // write code here
        List<Integer> list = printMatrix(mat);
        int[] arr = new int[n * m];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.remove(0);
        }
        return arr;
    }

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        ArrayList<Integer> list = new ArrayList<Integer>();

        if(row == 0 || col == 0){
            return list;//输入的二维数组非法，返回的是一个空的数组
        }

        int left = 0; int top = 0; int right = col - 1; int buttom = row - 1;
        while(left <= right && top <= buttom){
            for(int i = left; i <= right; i ++){
                list.add(matrix[top][i]);
            }
            for(int i = top + 1; i <= buttom; i ++){
                list.add(matrix[i][right]);
            }
            if(top != buttom){
                for(int i = right - 1; i >= left; i --){
                    list.add(matrix[buttom][i]);
                }
            }
            if(left != right){
                for(int i = buttom -1; i > top ; i --){
                    list.add(matrix[i][left]);
                }
            }
            left ++; top ++; right --; buttom --;
        }
        return list;

    }
}
