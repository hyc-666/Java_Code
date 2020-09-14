package didi.q1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author hyc
 * @date 2020/9/13
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNextInt()) {
        List<String> list = new ArrayList<>();
        int n = scanner.nextInt();
//        StringBuilder sb = new StringBuilder();
//            while (scanner.hasNext()){
//                sb.append(scanner.next());
//            }
//            String s = sb.toString();
        scanner.nextLine();
        String s = scanner.nextLine();
            int index = 0;
            while (index + n < s.length()) {
                String str = s.substring(index, index + n);
                list.add(str);
                index = index + n;
            }
            list.add(s.substring(index));
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                stringBuilder.append(reverse(list.get(i)));
            }
            System.out.println(stringBuilder.toString());
//        }
    }
    //将每个字符串逆序
    public static String reverse(String s){
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
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
