package everyDayQuestion.july._0711;

import java.util.Scanner;

/**
 * @author hyc
 * @date 2020/7/13
 */

/**
 * 写出一个程序，接受-个十六进制的数值字符串，输出该数值的十进制字符串(注意可
 * 能存在的一个测试用例里的多组数据)。
 * 输入描述:
 * 输入一个十六进制的数值字符串。
 * 输出描述:
 * 输出该数值的十进制字符串。
 * 示例1输入输出示例仅供调试， 后台判题数据一般不包含示例
 * 输入
 * 复制
 * 0xA
 * 输出
 * 复制
 * 10
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //对于这种持续型的字符串输入，开头采用scanner.HasNext()来判断还有输入，
        //输入的时候使用scanner.nextLine()来接收
        while (scanner.hasNext()){
            String input = scanner.nextLine();
            if (input.charAt(0) == '0' && input.length() > 2){
                input = input.substring(2);
            }else {
                break;
            }
            StringBuilder binary = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                binary.append(format(input.charAt(i)));
            }
            int len = binary.length() - 1;
            int sum = 0;
            int k = 0;
            for (int i = len; i >= 0; i--) {
                int temp = binary.charAt(i) - 48;
                sum += temp * Math.pow(2,k);
                k++;
            }
            System.out.println(sum);
        }
    }

    public static String format(char ch){
        //将一个十六进制对应的字符转为二进制序列
        switch (ch){
            case '0':
                return "0000";
            case '1':
                return "0001";
            case '2':
                return "0010";
            case '3':
                return "0011";
            case '4':
                return "0100";
            case '5':
                return "0101";
            case '6':
                return "0110";
            case '7':
                return "0111";
            case '8':
                return "1000";
            case '9':
                return "1001";
            case 'A':
                return "1010";
            case 'B':
                return "1011";
            case 'C':
                return "1100";
            case 'D':
                return "1101";
            case 'E':
                return "1110";
            case 'F':
                return "1111";
            default:
                return "";
        }
    }
}
