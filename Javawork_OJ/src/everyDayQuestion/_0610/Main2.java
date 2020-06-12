package everyDayQuestion._0610;

import java.util.Scanner;

/**
 * @author hyc
 * @date 2020/6/10
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int num = scanner.nextInt();
            System.out.println(reverse(num));
        }
    }
    public static String reverse(int num){
        String s = num + "";
        char[] chars = s.toCharArray();
        int i = 0; int j = s.length() - 1;
        while (i < j){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }
}
