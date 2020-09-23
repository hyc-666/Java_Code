package duxiaoman.q1;

import java.util.Scanner;

/**
 * @author hyc
 * @date 2020/9/20
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.next();//已有的
            String t = scanner.next();//需要的
            char[] arr = s.toCharArray();
            System.out.println(count(arr,t));
        }
    }
    public static int count(char[] arr,String s){
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            if (contains(arr,s.charAt(i))){
                ret++;
            }
        }
        return ret;
    }

    private static boolean contains(char[] arr, char ch) {
        for (int i = 0; i < arr.length; i++) {
            if (ch == arr[i]){
                arr[i] = '=';
                return true;
            }
        }
        return false;
    }
}
