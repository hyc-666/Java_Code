package newCode;
//栈的压栈出栈序列

import java.util.Stack;

public class NewCode_Stack {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<Integer>();
        int i,j = 0;
        for (i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);//将第一个数压栈
            //查看出栈顺序是不是这个刚压栈的数
            if (popA[j] == stack.peek()){//如果是则出栈
                stack.pop();
                j++;
            }
        }
        //循环结束后pushA中所有元素均已压栈，现在只需对比剩下的出栈顺序和后面的序列即可
        while(j < popA.length && popA[j] == stack.peek()){
            j++;
            stack.pop();
        }
        return j >= popA.length;
    }

    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,5,3,2,1};
        System.out.println(IsPopOrder(pushA,popA));
    }
}
