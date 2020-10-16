package yangtuo.q2;

import java.util.Scanner;

/**
 * @author hyc
 * @date 2020/10/16
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
        }

        }

    public static int getCoins(int n) {
        int count = 0;
        int[] arr = {1, 2, 5, 10};
        for (int i = 0; i <= n / arr[0]; i++) {
            for (int j = 0; j <= n / arr[1]; j++) {
                for (int k = 0; k <= n / arr[2]; k++) {
                    for (int l = 0; l <= n / arr[3]; l++) {
                        if (arr[0] * i +arr[1] * j +arr[2] * k + arr[3] * l == n){
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
