package meituan.q5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author hyc
 * @date 2020/9/13
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
            List<Thing> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                list.add(new Thing(i,a,b));
            }
            list.sort(new Comparator<Thing>() {
                @Override
                public int compare(Thing o1, Thing o2) {

                    if (o1.b != o2.b){
                        return o2.b - o1.b;
                    }
                    return o2.a - o1.a;
                }
            });
            for (Thing s : list){
                System.out.print(s.n + " ");
            }
        }
    }
}

class Thing  {
    int a;//优先级
    int b;//必要程度
    int n;//事情的编号

    public Thing(int n,int a, int b) {
        this.a = a;
        this.b = b;
        this.n = n;
    }
}