package everyDayQuestion.july._0709;

import java.util.Scanner;

/**
 * @author hyc
 * @date 2020/7/10
 */

/**
 * 题目描述
 * 输入球的中心点和球上某-点的坐标，计算球的半径和体积
 * 输入描述:
 * 球的中心点和球上某一点的坐标， 以如下形式输入: x0 y0 z0 x1 y1 z1
 * 输出描述:
 * 输入可能有多组，对于每组输入，输出球的半径和体积，并且结果保留三位小数
 * 为避免精度问题，PI值 请使用arccos(-1)。
 * 示例1输入输出示例仅供调试， 后台判题数据一般不包含示例
 * 输入
 * | 复制
 * 0 0 0 1 1 1
 * 输出
 * |复制
 * 1.732 21.766
 */

//疏学公式都已经快忘光了
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            double x0 = scanner.nextInt();
            double y0 = scanner.nextInt();
            double z0 = scanner.nextInt();
            double x1 = scanner.nextInt();
            double y1 = scanner.nextInt();
            double z1 = scanner.nextInt();
            //球的半径即为球中心点到球面的距离，也就是给出两点之间的距离
            double radius = Math.sqrt(Math.pow(x0 - x1,2) + Math.pow(y0 - y1,2) + Math.pow(z0 - z1,2));
            //球的体积没记错的话应该是4/3 * PI * r =^3;
            double V = (4 / 3.0) * Math.acos(-1) * Math.pow(radius,3);

            System.out.println(String.format("%.3f ",radius) + String.format("%.3f",V));
        }
    }
}
