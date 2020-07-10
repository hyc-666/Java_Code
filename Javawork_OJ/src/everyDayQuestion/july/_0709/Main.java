package everyDayQuestion.july._0709;

/**
 * @author hyc
 * @date 2020/7/10
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * a题目描述
 * On a broken keyboard, some of the keys are worn out. So when you type some
 * sentences, the characters
 * corresponding to those keys will not appear on screen.
 * Now given a string that you are supposed to type, and the string that you actually
 * type out, please list those keys
 * which are for sure worn out.
 * 输入描述:
 * Each input file contains one test case. For each case， the
 * 1st line contains the original string, and the 2nd line
 * contains the typed-out string. Each string contains
 * no more than 80 characters which are either English letters
 * [A-Z] (case
 * insensitive), digital numbers [0-9]， or "”(representing
 * the space) . It is guaranteed that both strings are non-
 * empty .
 * 输出描述:
 * For each test case， print in one line the keys that are worn
 * out，in the order of being detected. The English letters
 * must be capitalized.
 * Each worn out key must be printed once only.工七is
 * guaranteed that there is at least one worn out key.
 *
 * 机翻的比我看着都难受
 * 在坏了的键盘上，有些键已经磨损了。所以当你键入一些。
 * 句子，人物。
 * 与这些键对应的按钮将不会出现在屏幕上。
 * 现在给出一个您应该键入的字符串，以及您实际输入的字符串。
 * 打出来，请把那些键列出来。
 * 它们肯定是破旧的。
 * 输入描述：
 * 每个输入文件都包含一个测试用例。对于每种情况，
 * 第一行包含原始字符串，第二行包含原始字符串。
 * 包含键入的字符串。每个字符串都包含。
 * 不超过80个字符，可以是英文字母。
 * [A-Z](案例。
 * 不敏感)、数字[0-9]或“”(表示。
 * 空格)。可以保证这两个字符串都不是。
 * 空的。
 * 输出描述：
 * 对于每个测试用例，在一行中打印使用的密钥。
 * OUT，按照被检测的顺序。英文字母。
 * 必须大写。
 * 每个破损的钥匙只能打印一次。工七是。
 * 保证至少有一把破旧的钥匙。
 */
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.next().toUpperCase();
//        String output = scanner.next().toUpperCase();
//
//
//        Stack<Character> stack1 = new Stack<>();
//        Stack<Character> stack2 = new Stack<>();
//
//        int len1 = input.length();
//        int len2 = output.length();
//
//        for (int i = len1 - 1; i >= 0; i--) {
//            stack1.push(input.charAt(i));
//        }
//        for (int i = len2 - 1; i >= 0; i--) {
//            stack2.push(output.charAt(i));
//        }
//
//        List<Character> list = new ArrayList<>();
//
//        while (!stack1.empty() && !stack2.empty()){
//            char ch = stack1.pop();
//            if (ch == stack2.peek()){
//                stack2.pop();
//            }else{
//                if (!list.contains(ch)){
//                    list.add(ch);
//                }
//            }
//        }
//        if (!stack1.empty()){
//            char ch = stack1.pop();
//            if (!list.contains(ch)){
//                list.add(ch);
//            }
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < list.size(); i++) {
//            sb.append(list.get(i));
//        }
//        System.out.println(sb.toString());
//    }
//}
class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next().toUpperCase();
        String output = scanner.next().toUpperCase();

        if (input.length() < output.length()){
            return;
        }

        List<Character> list = check(input,output);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }

    }

    public static List<Character> check(String s1,String s2){
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        int i = 0,j = 0;
        List<Character> list = new ArrayList<>();
        while (i < arr1.length && j < arr2.length){
            if (arr1[i] != arr2[j]){
                if (!list.contains(arr1[i])) {
                    list.add(arr1[i]);
                }
                i++;
            }else{
                i++;
                j++;
            }
        }
        for (int l = i; l < arr1.length; l++) {
            if (!list.contains(arr1[l])) {
                list.add(arr1[i]);
            }
        }
        return list;
    }
}