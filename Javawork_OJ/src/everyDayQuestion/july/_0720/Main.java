package everyDayQuestion.july._0720;

/**
 * @author hyc
 * @date 2020/7/22
 */
import java.util.*;

//先用hash表存储字母和数字之间的映射关系
//每次读到一个字符，去hash表中查找

/**
 * 上图是一个电话的九宫格，如你所见一个数字对应一些字母， 因此在国外企业喜欢把
 * 电话号码设计成与自己公司名字相对应。例如公司的Help Desk号码是4357,因为4对
 * 应H、3对应E、5对应L、7对应P，因此4357就是HELP。同理，TUT_GLOP就代表
 * 888-4567、310-GINO代表310-4466。
 * NowCoder刚进入外企，并不习惯这样的命名方式，现在给你一串电话号码列表，请
 * 你帮他转换成数字形式的号码，并去除重复的部分。
 * 输入描述:
 * 输入包含多组数据。
 * 每组数据第一行包含一-个正整数n (1SnS1024) 。
 * 紧接着n行，每行包含一个电话号码，电话号码仅由连字符“一-”、 数字和大写字母
 * 组成。
 * 没有连续出现的连字符，并且排除连字符后长度始终为7 (美国电话号码只有7
 * 位)。
 * 输出描述:
 * 对应每一-组输入， 按照字典顺序输出不重复的标准数字形式电话号码，即*xxx-
 * xxxx"形式。
 * 每个电话号码占一行，每组数据之后输出一个空行作为间隔符。
 */

//真的不知道题目要干什么
public class Main {
    public static void main(String[] args) {
        //借助字符串当成一个表，完成字母和数字之间的转换即可
        String symbol = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String number = "222333444555666777788899991234567890";

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            ArrayList<String> list = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                String str = sc.next();
                str = str.replace("-", "");
                String result = "";
                for(int j = 0; j < 7; j++) {
                    result += number.charAt(symbol.indexOf(str.charAt(j)+""));
                }
                result = result.substring(0, 3) + "-" + result.substring(3, 7);
                if(!list.contains(result)) {
                    list.add(result);
                }
            }
            Collections.sort(list);
            for(int j = 0; j < list.size(); j++) {
                System.out.println(list.get(j));
            }
            System.out.println();
        }
    }
}