package everyDayQuestion.june._0606;

/**
 * @author hyc
 * @date 2020/6/7
 */

import java.util.Scanner;

/**
 * ■题目描述
 * A,B,C三个人是好朋友每个人手里都有一些糖果 我们不知道他们每个人手上具体有多
 * 少个糖果，但是我们知道以下的信息:
 * A-B,B-C,A+B, B+ C.这四个数值每个字母代表每个人所拥有的糖果数.
 * 现在需要通过这四个数值计算出每个人手里有多少个糖果，即A,B,C。这里保证最多只
 * 有一组整数A,B,C满足所有题设条件。
 * 输入描述:
 * 输入为一行，-共4个整数，分别为A-B，B-C，A+B，B+c，用空格隔
 * 开。范围均在-30到30之间 (闭区间)。
 * 输出描述:
 * 输出为一-行，如果存在满足的整数A，B，c则按顺序输出A，B，C,用空格隔开，
 * 行末无空格。如果不存 在这样的整数A，B， c，则输出No
 * 示例1输入输出示例仅供调试，后台判题数据一般不包含示例
 * 输入
 * 复制
 * 1-234
 * 输出
 * 复制
 * 213
 */
public class Main {
    //解题思路，设 A-B,B-C,A+B,B+C四个输入的值分别位m,n,p,q,则m+p可以得出A，B，n+q可以得出B，C
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            int A,B,C;
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            A = (m + p) / 2;
            B = p - A;
            C = q - B;
            //验证答案
            if (A - B == m && B - C == n && A + B == p && B + C == q){
                System.out.printf("%d %d %d\n",A,B,C);
            }else{
                System.out.println("No");
            }
        }
    }
}
