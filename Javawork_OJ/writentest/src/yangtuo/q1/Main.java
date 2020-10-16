package yangtuo.q1;

import java.util.Scanner;

/**
 * @author hyc
 * @date 2020/10/16
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            System.out.println(countMax(scanner.next()));
        }
    }
    public static int countMax(String str){
        int count = 0;
        if (str.length() != 5){
            return 0;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9'){
                return 0;
            }
        }
        int[] arr = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i) - 48;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0){
                continue;
            }
            for (int j = 0; j < arr.length && i != j; j++) {
                for (int k = 0; k < arr.length && j != k && i != k; k++) {
                    count++;
                }
            }
        }
        return count;
    }
}
