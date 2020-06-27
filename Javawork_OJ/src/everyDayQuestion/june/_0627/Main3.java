package everyDayQuestion.june._0627;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author hyc
 * @date 2020/6/27
 */
//用哈希表试试吧
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            Map<Integer,Integer> map = new HashMap<>(N);
            for (int i = 1; i <= N; i++) {
                int score = scanner.nextInt();
                map.put(i,score);
            }
            for (int i = 0; i < M; i++) {
                char C = scanner.next().charAt(0);
                int A = scanner.nextInt();
                int B = scanner.nextInt();
                if (C == 'Q'){
                    int high = map.get(A);
                    for (int j = A; j <= B; j++) {
                        if (high < map.get(j)){
                            high = map.get(j);
                        }
                    }
                    System.out.println(high);
                }else{
                    map.put(A,B);
                }
            }
        }
    }
}

//真的尽力了，每种方法自测都能通过，提交的时候就是0.0%，也不知道哪出了bug
