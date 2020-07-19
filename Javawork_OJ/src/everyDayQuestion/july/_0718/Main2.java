package everyDayQuestion.july._0718;

import java.util.Scanner;

/**
 * @author hyc
 * @date 2020/7/19
 */

/**
 * ■题目描述
 * 1、对输入的字符串进行加解密，并输出。
 * 2加密方法为:
 * 当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写，如字母
 * a时则替换为B;字母Z时则替换为a;
 * 当内容是数字时则把该数字加1,如0替换1，1替换2，9替换0;
 * 其他字符不做变化。
 * 3、解密方法为加密的逆过程。
 * 接口描述:
 * 实现接口，每个接口实现1个基本操作:
 * void Encrypt (char aucPassword[, char aucResult]):在该函数中实现字符串加密并
 * 输出
 * 说明:
 * 1、字符串以0结尾。
 * 2、字符串最长100个字符。
 * int unEncrypt (char result], char password[):在该函数中实现字符串解密并输出
 * 说明:
 * 1、字符串以0结尾。
 * 2、字符串最长100个字符。
 * 输入描述:
 * 输入说明
 * 输入一串要加密的密码
 * 输入一串加过密的密码
 * 输出描述:
 * 输出说明
 * 输出加密后的字符
 * 输出解密后的字符
 * 示例1输入输出示例仅供调试， 后台判题数据一般不包含示例
 * 输入
 * abcdefg
 * BCDEFGH
 * 输出
 * BCDEFGH
 * abcdefg
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String password = scanner.nextLine();
            String s = scanner.nextLine();
            Password p1 = new Password(password);
            Password p2 = new Password(s);
            System.out.println(p1.encrypt());
            System.out.println(p2.unEncrypt());
        }
    }

}

class Password{
    String psw;//原文
    public Password(String psw) {
        this.psw = psw;
    }
    //加密方法
    public String encrypt(){
        char[] arr = psw.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            if (ch >= 'A' && ch <= 'Z'){
                if (ch == 'Z'){
                    arr[i] = Character.toLowerCase('A');
                }else{
                    ch += 1;
                    arr[i] = Character.toLowerCase(ch);
                }
            } else if (ch >= 'a' && ch <= 'z'){
                if (ch == 'z'){
                    arr[i] = Character.toUpperCase('a');
                }else{
                    ch += 1;
                    arr[i] = Character.toUpperCase(ch);
                }
            } else if (ch >= '0' && ch <= '9'){
                if (ch == '9'){
                    arr[i] = '0';
                }else{
                    ch += 1;
                    arr[i] = ch;
                }
            }
        }
        return new String(arr);
    }

    public String unEncrypt(){
        char[] arr = psw.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            if (ch >= 'A' && ch <= 'Z'){
                if (ch == 'A'){
                    arr[i] = Character.toLowerCase('Z');
                }else{
                    ch -= 1;
                    arr[i] = Character.toLowerCase(ch);
                }
            } else if (ch >= 'a' && ch <= 'z'){
                if (ch == 'a'){
                    arr[i] = Character.toUpperCase('z');
                }else{
                    ch -= 1;
                    arr[i] = Character.toUpperCase(ch);
                }
            } else if (ch >= '0' && ch <= '9'){
                if (ch == '0'){
                    arr[i] = '9';
                }else{
                    ch -= 1;
                    arr[i] = ch;
                }
            }
        }
        return new String(arr);
    }
}