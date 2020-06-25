package everyDayQuestion.june._0603;

/**
 * @author hyc
 * @date 2020/6/5
 */

/**
 * a题目描述
 * 读入一个字符串str,输出字符串str中的连续最长的数字串
 * 输入描述:
 * 个测试输入包含1个测试用例，- -个字符串str，长度不超过255。
 * 输出描述:
 * 在一行内输出stc中里连续最长的数字串。
 * 示例1输入输出示例仅供调试，后台判题数据一般不包含示例
 * 输入
 * abcd1234 5ed12533123456789
 * 输出
 * 123456789
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String s = scanner.nextLine();
            int len = s.length();
            StringBuilder stringBuilder = new StringBuilder();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    stringBuilder.append(s.charAt(i));
                }else{
                    if (stringBuilder.length() < 1){
                        continue;
                    }
                    list.add(stringBuilder.toString());
                    stringBuilder = new StringBuilder();
                }
            }
            if (stringBuilder.length() > 1) {
                list.add(stringBuilder.toString());
            }
            if (list.isEmpty()){
                System.out.println();
                continue;
            }
            int maxLength = 0;
            int index = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).length() > maxLength){
                    maxLength = list.get(i).length();
                    index = i;
                }
            }
            System.out.println(list.get(index));
        }
    }
}
