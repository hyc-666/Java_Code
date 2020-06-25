package everyDayQuestion.june._0604;

import java.util.Scanner;

/**
 * @author hyc
 * @date 2020/6/5
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < s1.length(); i++) {
                if (s2.contains(s1.charAt(i) + "")){
                    continue;
                }
                stringBuilder.append(s1.charAt(i));
            }
            System.out.println(stringBuilder.toString());
        }
    }
}
