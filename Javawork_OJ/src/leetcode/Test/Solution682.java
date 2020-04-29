package leetcode.Test;
//棒球比赛
/**
 * 你现在是棒球比赛记录员。
 * 给定一个字符串列表，每个字符串可以是以下四种类型之一：
 * 1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
 * 2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
 * 3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
 * 4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
 *
 * 每一轮的操作都是永久性的，可能会对前一轮和后一轮产生影响。
 * 你需要返回你在所有回合中得分的总和。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/baseball-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Stack;

public class Solution682 {
    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String s : ops){
            if (s.matches("\\d+") || s.charAt(0) == '-'){
                stack.push(Integer.parseInt(s));
            }else if(s.equals("+")){
                //记录前两轮的得分
                int num1 = stack.pop();
                int num2 = stack.pop();
                //再把前两轮得分压栈
                int sum = num1 + num2;
                stack.push(num2);
                stack.push(num1);
                stack.push(sum);//把本轮得分压栈
            }else if(s.equals("D")){
                int sum = stack.peek() * 2;
                stack.push(sum);
            }else if(s.equals("C")){
                stack.pop();
            }
        }
        int res = 0;
        while (!stack.empty()){
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        String[] str = {"5","-2","4","C","D","9","+","+"};
        System.out.println(calPoints(str));
    }
}
