package mi.q1;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author hyc
 * @date 2020/9/15
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String str = scanner.nextLine();
            System.out.println(isOK(str));
        }
    }
    public static boolean isOK(String s){
        if (s == null || s.length() < 1){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }else{
                if (ch == ')'){
                    if (stack.isEmpty()){
                        return false;
                    }
                    char c = stack.peek();
                    if (c == '('){
                        stack.pop();
                    }else{
                        return false;
                    }
                }else if (ch == ']'){
                    if (stack.isEmpty()){
                        return false;
                    }
                    char c = stack.peek();
                    if (c =='['){
                        stack.pop();
                    }else{
                        stack.push(ch);
                    }
                }else{
                    if (stack.isEmpty()){
                        return false;
                    }
                    char c = stack.peek();
                    if (c == '{'){
                        stack.pop();
                    }else{
                        stack.push(ch);
                    }
                }
            }
        }
        return stack.empty();
    }
}
