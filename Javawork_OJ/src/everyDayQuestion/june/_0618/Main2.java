package everyDayQuestion.june._0618;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author hyc
 * @date 2020/6/18
 */
public class Main2 {
    public static void main(String[] args) {
        //有时候，题目确实不难，就是这个I/O让人迷惑的很
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int N = scanner.nextInt();
            if (N == 0){
                break;
            }
            //使用map来统计每个分数出现的次数
            //其中键为分数，值为该分数出现的次数
            Map<Integer,Integer> map = new HashMap<>(N);
            for (int i = 0; i < N; i++) {
                int stu = scanner.nextInt();
                if (!map.containsKey(stu)){
                    map.put(stu,1);
                }else{
                    int count = map.get(stu);
                    map.put(stu,count + 1);
                }
            }
            int score = scanner.nextInt();
            if (map.get(score) == null){
                System.out.println(0);
            }else {
                System.out.println(map.get(score));
            }
        }
    }
}
