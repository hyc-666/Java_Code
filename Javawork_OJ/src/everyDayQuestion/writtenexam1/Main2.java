package everyDayQuestion.writtenexam1;

/**
 * @author hyc
 * @date 2020/8/3
 */

import java.util.*;

/**
 * ■题目描述
 * 某餐馆有n张桌子，每张桌子有一个参数: a可容纳的最大人数;有m批客人， 每批
 * 客人有两个参数:b人数，c预计消费金额。在不允许拼桌的情况下， 请实现-个算法
 * 选择其中一部分客人，使得总预计消费金额最大
 * 输入描述:
 * 输入包括m+2行。第一 -行两个整数n(1 <= n <= 50000),m(1<= m <=
 * 50000)第二行为n个参数a, 即每个桌子可容纳的最大人数,以空格分隔，范围均
 * 在32位int范围内。接下来m行，每行两个参数b,C。分别表示第i批客人的人数
 * 和预计消费金额，以空格分隔,范围均在32位int范围内。
 * 输出描述:
 * 输出一个整数,表示最大的总预计消费金额
 * 示例1输入输出示例仅供调试， 后台判题数据一般不包含示例
 * 输入
 * 复制
 * 3524213353759110
 * 输出
 * 复制
 * 20
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            List<Table> tables = new ArrayList<>(n);
            List<People> peoples = new ArrayList<>(m);
            for (int i = 0; i < n; i++) {
                int a = scanner.nextInt();
                tables.add(new Table(a));
            }
            for (int i = 0; i < m; i++) {
                int b = scanner.nextInt();
                int c = scanner.nextInt();
                peoples.add(new People(b,c));
            }
            tables.sort(new Comparator<Table>() {
                @Override
                public int compare(Table o1, Table o2) {
                    return o1.a - o2.a;
                }
            });
            peoples.sort(new Comparator<People>() {
                @Override
                public int compare(People o1, People o2) {
                    return o2.c - o1.c;
                }
            });
            int[] used = new int[n];//记录哪些左子被使用了
            long maxPrice = 0;

            for (int i = 0; i < m; i++) {
                if (tables.get(n - 1).a < peoples.get(0).b){
                    continue;
                }
                int num = peoples.get(i).b;//第i批人数
                int price = peoples.get(i).c;//第i批消费金额
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j < tables.size(); j++) {
                    list.add(tables.get(j).a);
                }
                int index = binarySearch(num,list);
                while(index<n && used[index]==1){
                    index++;
                }

                if(index<n){
                    maxPrice += price;
                    used[index] = 1;
                }
            }
            System.out.println(maxPrice);
        }
    }

    //二分查找
    public static int binarySearch(int num, List<Integer> a){
        int left = 0;
        int right = a.size() - 1;
        int mid = 0;
        while(left <= right){
            mid = (right + left) / 2;
            if(num <= a.get(mid)){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
}

class Table{
    int a;//每张桌子最大可容纳人数

    public Table(int a) {
        this.a = a;
    }
}

class People{
    int b;//客人的人数
    int c;//预计消费金额

    public People(int b, int c) {
        this.b = b;
        this.c = c;
    }
}