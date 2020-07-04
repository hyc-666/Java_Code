package everyDayQuestion.july._0702;

/**
 * @author hyc
 * @date 2020/7/4
 */

import java.util.Scanner;

/**
 * 题目描述
 * 密码要求:
 * 1.长度超过8位
 * 2包括大小写字母数字其它符号，以上四种至少三种
 * 3.不能有相同长度超2的子串重复
 * 说明:长度超过2的子串
 * 输入描述:
 * -组或多组长度超过2的子符串。每组占一行
 * 输出描述:
 * 如果符合要求输出: OK， 否则输出NG
 */
public class Main2 {

    //程序没有任何问题，就是牛客的IO问题很大
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String password = scanner.next();
           if (isOK(password)){
               System.out.println("OK");
           }else{
               System.out.println("NG");
           }
        }
    }

    public static boolean isOK(String str){
        if (str.length() < 8){
            return false;
        }
        //构建正则表达式
        int kind = 0;
        if (str.matches(".*[a-z].*")){//小写字母
            kind++;
        }
        if (str.matches(".*[A-Z].*")){//大写字母
            kind++;
        }
        if (str.matches(".*[\\d].*")){//一位数字
            kind++;
        }
        if (str.matches(".*[\\D].*")  && str.matches(".*[\\W].*")){//匹配一位非数字非字母的字符
            kind++;
        }
       if (kind < 3){
           return false;
       }
        for (int i = 0; i < str.length() - 1; i++) {
            String s = "(" + str.substring(i,i + 2) + ")";
             s = "(.*" + s + ".*){2,}";
            if (str.matches(s)){
                return false;
            }
        }
        return true;
    }
}
