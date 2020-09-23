package daotong.q1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author hyc
 * @date 2020/9/23
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            List<String> stringList = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                stringList.add(scanner.next());
            }
            stringList.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    int len = Math.min(o1.length(), o2.length());
                    for (int i = 0; i < len; i++) {
                        if (o1.charAt(i) != o2.charAt(i)) {
                            return o1.charAt(i) - o2.charAt(i);
                        }
                    }
                    return o1.length() - o2.length();
                }
            });
            StringBuilder sb1 = new StringBuilder();
            for (String s : stringList) {
               sb1.append(s + " ");
            }

            System.out.println(sb1.substring(0,sb1.length() - 1));

            stringList.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.length() - o2.length();
                }
            });
            StringBuilder sb2 = new StringBuilder();
            for (String s : stringList) {
                sb2.append(s + " ");
            }
            System.out.println(sb2.substring(0,sb2.length() - 1));
        }
    }
}
