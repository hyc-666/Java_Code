package everyDayQuestion.june._0606;

/**
 * @author hyc
 * @date 2020/6/7
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述
 * 输入n个整数，输出出现次数大于等于数组长度一半的数。
 * 输入描述:
 * 每个测试输入包含n个空格分割的n个整数，n不超过100， 其中有- -个整数出现次
 * 数大于等于n/2。
 * 输出描述:
 * 输出出现次数大于等于n/ 2的数。
 * 示例1输入输出示例仅供调试，后台判题数据一般不包含示例
 * 输入
 * 复制
 * 39325673233 3
 * 输出
 * 复制
 * 3
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            List<Integer> list = new ArrayList<>();
            list.add(scanner.nextInt());
        }
        /*int n = 0;
        Map<Integer,Integer> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int num = scanner.nextInt();
            n++;
            if (!map.containsKey(num)){
                map.put(num,1);
            }else{
                int count = map.get(num);
                map.put(num,count + 1);
            }
        }
        for (Map.Entry entry : map.entrySet()){
            if ((int)entry.getValue() > (n / 2)){
                System.out.println(entry.getKey());
                break;
            }
        }*/
    }
}
