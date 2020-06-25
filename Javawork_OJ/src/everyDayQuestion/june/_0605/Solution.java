package everyDayQuestion.june._0605;
//用两个占实现队列

import java.util.Stack;

/**
 * @author hyc
 * @date 2020/6/7
 */
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack2.push(node);
    }

    public int pop() {
        if (stack1.empty() && stack2.empty()) {
            System.out.println();
        }
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        int res = stack1.pop();
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        return res;
    }
}
