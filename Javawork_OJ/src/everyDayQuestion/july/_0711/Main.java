package everyDayQuestion.july._0711;

/**
 * @author hyc
 * @date 2020/7/13
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * ■题目描述
 * 输入- -行字符串，计算其中A-Z大写字母出现的次数
 * 输入描述:
 * 案例可能有多组，每个案例输入为一行字符串。
 * 输出描述:
 * 对每个案例按A- z的顺序输出其中大写字母出现的次数。
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String input = scanner.next();
            Map<Character,Integer> map = new HashMap<>(26);
            for (int i = 0; i < input.length(); i++) {
                Character ch = input.charAt(i);
                if (map.containsKey(ch)){
                    int value = map.get(ch);
                    map.put(ch,value + 1);
                }else{
                    map.put(ch,1);
                }
            }
            for (char i = 'A'; i <= 'Z'; i++) {
                Integer value = map.get(i);
                if (value == null){
                    value = 0;
                }
                System.out.println(i + ":" + value);

            }
        }
    }
}
