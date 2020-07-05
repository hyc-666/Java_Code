package everyDayQuestion.july._0704;

import java.util.Scanner;

/**
 * @author hyc
 * @date 2020/7/5
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.next();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                System.out.println(trans(ch));
            }
        }
    }
    public static String trans(char ch){
        //一个char不超过8位
        int[] arr = new int[8];
        int n = ch;
        int i = 7;
        int count = 0;
        while (n > 0){
            int bit = n & 1;
            if (bit == 1){
                //顺便统计1的个数
                count++;
            }
            arr[i] = bit;
            i--;
            n = n >>> 1;
        }
        if (count % 2 == 0){
            arr[0] = 1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < arr.length; j++) {
            stringBuilder.append(arr[j]);
        }
        return stringBuilder.toString();
    }
}
