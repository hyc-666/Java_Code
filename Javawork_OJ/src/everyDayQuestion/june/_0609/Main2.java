package everyDayQuestion.june._0609;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author hyc
 * @date 2020/6/9
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNextInt()){
            list.add(scanner.nextInt());
        }
        int k = list.remove(list.size() - 1);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < k; i++) {
            System.out.printf("%d ",list.get(i));
        }
        System.out.println();
    }
}
