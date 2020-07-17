package everyDayQuestion.july._0717;

/**
 * @author hyc
 * @date 2020/7/17
 */

import java.util.Scanner;

/**
 * ■题目描述
 * 开发一个坐标计算工具，A表示向左移动， D表示向右移动，W表示向上移动，S表示
 * 向下移动。从(0,0)点开始移动，从输入字符串里面读取一些坐标， 并将最终输入结
 * 果输出到输出文件里面。
 * 输入:
 * 合法坐标为A(或者D或者W或者S) +数字(两位以内)
 * 坐标之间以;分隔。
 * 非法坐标点需要进行丢弃。如AA10; A1A; $%$; YAD; 等。
 * 下面是一个简单的例子如:
 * A10;S20;W10;D30;X;A1A;B1011;A10;
 * 处理过程:
 * 起点(0,0)
 * + A10 = (-10,0)
 * +
 * S20
 * ) = (-10,-20)
 * + W10= (-10,-10)
 * +D30=
 * (20,-10)
 * +X=无效
 * +A1A=无效
 * + B10A11 =无效
 * +一个空不影响
 * + A10= (10,-10)
 * 结果(10， -10)
 * 输入描述:
 * - -行字符串
 * 输出描述:
 * 最终坐标，以，分隔
 * 示例1输入输出示例仅供调试， 后台判题数据般不包含示例
 * 输入
 * A10;S20;W10;D30;X;A1A;B10A11; ;A10;
 * 输出
 * 10,-10
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] strings = scanner.nextLine().split(";");
            Point point = new Point();
            for (int i = 0; i < strings.length; i++) {
                if (strings[i] == null || strings[i].length() < 2 || strings[i].length() > 3) {
                    continue;
                }
                char handle = strings[i].charAt(0);
                String s = strings[i].substring(1);
                try {
                    int len = Integer.parseInt(s);
                    switch (handle) {
                        case 'A':
                            point.moveA(len);
                            break;
                        case 'D':
                            point.moveD(len);
                            break;
                        case 'W':
                            point.moveW(len);
                            break;
                        case 'S':
                            point.moveS(len);
                            break;
                        default:
                            break;
                    }
                } catch (Exception e) {

                }
            }
            System.out.println(point.x + "," + point.y);
        }
    }
}

class Point{
    int x = 0;
    int y = 0;

    public void moveA(int len){
        x = x - len;
    }
    public void moveD(int len){
        x = x + len;
    }
    public void moveW(int len){
        y = y + len;
    }
    public void moveS(int len){
        y = y - len;
    }

}