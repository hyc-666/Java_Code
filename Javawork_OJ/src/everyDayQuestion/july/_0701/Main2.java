package everyDayQuestion.july._0701;

import java.util.Scanner;

/**
 * @author hyc
 * @date 2020/7/2
 */

//真的难搞
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String ip = scanner.next();
            String[] ipadd = ip.split(".");
            int[] df = new int[ipadd.length];
            for (int i = 0; i < df.length; i++) {
                df[i] = Integer.valueOf(ipadd[i]);
            }
            int[] longInt = new int[32];
            for (int i = 0; i < df.length; i++) {
                int num = df[i];
                int[] binary = fix(num);
                for (int j = 0; j < 8; j++) {
                    longInt[i * 8 + j] = binary[j];
                }
            }
            int res = 0;
            for (int i = 0; i < longInt.length; i++) {
                res += longInt[i] * (int)Math.pow(2,i);
            }
            System.out.println(res);

            int input = scanner.nextInt();
            int[] ipdf = new int[32];
            for (int i = 0; i < ipdf.length; i++) {
                ipdf[i] = input & 1;
                input = input >>> 1;
            }
            int[] result = new int[4];
            for (int i = 0; i < result.length; i++) {
                int[] fin = new int[8];
                for (int j = 0; j < 8; j++) {
                    fin[j] = ipdf[i * 8 + j];
                }
                result[i] = trans(fin);
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < result.length; i++) {
                stringBuilder.append(result[i] + ".");
            }
            System.out.println(stringBuilder.substring(0,stringBuilder.length() - 1));
        }
    }

    //写一个静态方法将十进制转换为二进制的序列
    public static int[] fix(int x){
        int[] binary = new int[8];
        for (int i = 7; i >= 0; i++) {
            binary[i] = x & 1;
            x = x >>> 1;
        }
        return binary;
    }

    public static int trans(int[] arr){
        int df = 0;
        for (int i = 0; i < arr.length; i++) {
            df = arr[i] * (int)Math.pow(2,i);
        }
        return df;
    }
}
