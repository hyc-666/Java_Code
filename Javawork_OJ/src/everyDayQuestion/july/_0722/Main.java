package everyDayQuestion.july._0722;

/**
 * @author hyc
 * @date 2020/7/22
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * ■题目描述
 * nowcoder有两盒(A、 B)乓球，有红双喜的、有亚力亚的.... 现在他需要判别A盒
 * 是否包含了B盒中所有的种类，并且每种球的数量不少于B盒中的数量，该怎么办呢?
 * 输入描述:
 * 输入有多组数据。
 * 每组数据包含两个字符串A、B， 代表A盒与8盒中的乒乓球，每个乒乓球用-个大
 * 写字母表示，即相同类型的乒乓球为相同的大写字母。
 * 字符串长度不大于10000。
 * 输出描述:
 * 每一组输入对应一行输出:如果B盒中所有球的类型在A中都有，并且每种球的数
 * 量都不大于A，则输出"Yes”;否则输出“No”。
 * 示例1输入输出示例仅供调试， 后台判题数据一般不包含示例
 * 输入
 * 复制
 * ABCDFYE CDE
 * ABCDGEAS CDECDE
 * 输出
 * 复制
 * Yes
 * No
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s1 = scanner.next();
            String s2 = scanner.next();
            Map<Character,Integer> map1 = new HashMap<>();
            Map<Character,Integer> map2 = new HashMap<>();

            for (int i = 0; i < s1.length(); i++) {
                Character ch = s1.charAt(i);
                if (!map1.containsKey(ch)){
                    map1.put(ch,1);
                }else{
                    int value = map1.get(ch);
                    map1.put(ch,value + 1);
                }
            }

            for (int i = 0; i < s2.length(); i++) {
                Character ch = s2.charAt(i);
                if (!map2.containsKey(ch)){
                    map2.put(ch,1);
                }else{
                    int value = map2.get(ch);
                    map2.put(ch,value + 1);
                }
            }
            boolean isOK = true;
            for (Map.Entry entry : map2.entrySet()){
                Character ch = (Character) entry.getKey();
                int value = (int) entry.getValue();
                if (map1.get(ch) == null){
                    isOK = false;
                    break;
                }else {
                    if (map1.get(ch) < value){
                        isOK = false;
                        break;
                    }
                }
            }
            if (isOK){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
}
