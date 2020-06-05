package everyDayQuestion._0603;

import java.util.Stack;

/**
 * @author hyc
 * @date 2020/6/5
 */
public class Parenthesis {
    /**
     * 对于-个字符串，请设计-一个算法，判断其是否为一个合法的括号串。
     * 给定- -个字符串A和它的长度n，请返回一-个bool值代表它是否为-一个合法的括号串。
     * 一个合法的括号串定义为: 1. 只包括括号字符; 2.左括号和右括号一-对应
     * 测试样例:
     * "(() ())",6
     * 返回: true
     * 测试样例:
     * "()a() ()",7
     * 返回: false
     * 测试样例:
     * "() (() ()",7
     * 返回: false
     * @param A
     * @param n
     * @return
     */
    public boolean chkParenthesis(String A, int n) {
        if (n < 1){
            return false;
        }
        // write code here
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = A.charAt(i);
            if (ch == '('){
                stack.add(ch);
            }else if(ch == ')'){
                if (stack.empty()){
                    stack.push(ch);
                    continue;
                }
                if (stack.peek() == '('){
                    stack.pop();
                }else{
                    stack.add(ch);
                }
            }else{
                return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        Parenthesis p = new Parenthesis();
        System.out.println(p.chkParenthesis(")))", 3));
    }
}
