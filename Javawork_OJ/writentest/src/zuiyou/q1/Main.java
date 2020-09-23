package zuiyou.q1;

import java.util.Scanner;

/**
 * @author hyc
 * @date 2020/9/23
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String input = scanner.next();
            boolean flag = false;
            if (input.charAt(0) == '-'){
                flag = true;
                input = input.substring(1);
            }
            int len = input.length();
            long sum = 0l;
            for (int i = 0; i < len; i++) {
                char ch = input.charAt(i);
                int x = 0;
                if (ch >= 'a' && ch <= 'z'){
                    x = ch - 87;
                }else{
                    x = ch - 48;
                }
                long a = (long)Math.pow(36,len - i - 1);
                if (sum >= (9223372036854775807L / a)){
                    sum = 9223372036854775807L;
                }
                sum = sum + x * a;

            }
            if (flag){
                sum = -1 * sum;
            }
            System.out.println(sum);
        }
    }
}
