package leetcode.Test;
//比较含推个的字符串

import java.util.Stack;

/**
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 */
public class solution844 {
    public boolean backspaceCompare(String S, String T) {
        //定义两个栈，一次对两个字符串进行遍历，遇到字符就压栈，#出栈，然后比较
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != '#'){
                stackS.push(S.charAt(i));
            }else{
                if (stackS.empty()){
                    continue;
                }
                stackS.pop();
            }
        }

        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) != '#'){
                stackT.push(T.charAt(i));
            }else{
                if (stackT.empty()){
                    continue;
                }
                stackT.pop();
            }
        }
        //如果两个栈的size不一样，那么两个字符串也就不一样，返回false
        if (stackS.size() != stackT.size()){
            return false;
        }
        //然后依次出栈比较
        while (!stackS.empty() && !stackT.empty()){
            if (stackS.pop() != stackT.pop()){
                return false;
            }
        }
        return true;
    }
}
