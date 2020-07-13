package everyDayQuestion.july._0713;

/**
 * @author hyc
 * @date 2020/7/13
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述
 * 有一个由很多木棒构成的集合，每个木棒有对应的长度，请问能否用集合中的这些木
 * 棒以某个顺序首尾相连构成一个面积大于0的简单多边形且所有木棒都要用上，简单
 * 多边形即不会自交的多边形。
 * 初始集合是空的，有两种操作，要么给集合添加一个长度为L的木棒，要么删去集合
 * 中已经有的某个木棒。每次操作结束后你都需要告知是否能用集合中的这些木棒构成
 * 一个简单多边形。
 * 输入描述:
 * 每组测试用例仅包含一-组数据，每组数据第一行为一 个正整数n表示操作的数量
 * (1≤n≤50000)，接下来有n行，每行第一个整数为操作类型i (i∈
 * {1,2})，第二个整数为一个长度L(1≤L≤1,000,000,000)。如果i=1
 * 代表在集合内插入一个长度为工的木棒，如果i=2代表删去在集合内的一-根长
 * 度为L的木棒。输入数据保证删除时集合中必定存在长度为工的木棒，且任意
 * 操作后集合都是非空的。
 * 输出描述:
 * 对于每一-次操作结束有一次输出，如果集合内的木棒可以构成简单多边形，输出
 * "Yes"，否则输出"No"。
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int k = 0; k < n; k++) {
            int i = scanner.nextInt();
            int l = scanner.nextInt();

            if (i == 1){
                list.add(l);
            }else{
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) == l){
                        list.remove(j);
                        break;
                    }
                }
            }
            //判断能否组成多边形
            //如果边少于2，则不能组成多边形
            //如果边数为3，则要判断是否能组成三角形
            //即任意两边之和大于第三边，任意两边之差大于第三边
            if (list.size() < 3){
                System.out.println("No");
            }else if (list.size() == 3){
                list.sort(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1 - o2;
                    }
                });
                if (list.get(0) + list.get(1) > list.get(2) && list.get(2) - list.get(0) < list.get(1)){
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
            }else{//四条边以上就可以组成多边形
                System.out.println("Yes");
            }
        }
    }
    //或许是我对题目的理解有问题，也或许是我不知道什么叫做简单多边形，
    //查了也没有查到，总之通过率只有80%
}
