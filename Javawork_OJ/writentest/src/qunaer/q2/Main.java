package qunaer.q2;

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
        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
            StringBuilder s1 = new StringBuilder();//用于拼接两个字符串
            StringBuilder s2 = new StringBuilder();

            for (int i = 0; i < n; i++) {
                s1.append(scanner.next());
            }
            for (int i = 0; i < n; i++) {
                s2.append(scanner.next());
            }
            String str1 = s1.toString();
            String str2 = s2.toString();
            List<Integer> list = new ArrayList<>(n);
            for (int i = 0; i < str1.length(); i++) {
                list.add(maxSame(str1,str2));
            }
            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2- o1;
                }
            });
            System.out.println(list.remove(0));
        }
    }

    //找s1中每一个字符串在s2中第一次出现的次数并计算其后出现次序相同的.然后挑选出最长的
    public static int maxSubString(String s1,String s2,int index){
        return s2.indexOf(s1.charAt(index));
    }
    //计算后续有多少个顺序相同
    public static int maxSame(String s1,String s2){
        int count = 0;
        int i = 1;
        while (i < s1.length()){
            int index = maxSubString(s1,s2,i);
            i++;
            if (i  >= s1.length()){
                break;
            }
            int in = maxSubString(s1,s2,i);
            if (index > in){
                count++;
            }
            i++;
        }
        return count;
    }

}
