package mi.q2;

import java.util.Scanner;

/**
 * @author hyc
 * @date 2020/9/15
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String s = scanner.nextLine();
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (!sb.toString().contains(ch + "")){
                    sb.append(ch);
                }
            }
            System.out.println(sb.toString());
        }
    }
}
