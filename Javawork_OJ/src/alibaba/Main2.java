package alibaba;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 转换密码的对应关系
 * @author hyc
 * @date 2020/9/8
 */
public class Main2 {
    public static void main(String[] args) {
        //题目都看不懂。。。。。
        //对应的替换关系要自己找吗？
        //要一个一个去试？
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
            if (n == 0){
                break;
            }
            List<String> stringList = new ArrayList<>(n + 1);
            for (int i = 0; i <= n; i++) {
                stringList.add(scanner.next());
            }

        }
    }
}
