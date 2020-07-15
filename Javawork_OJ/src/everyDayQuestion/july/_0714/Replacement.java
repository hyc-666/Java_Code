package everyDayQuestion.july._0714;

/**
 * @author hyc
 * @date 2020/7/15
 */
/**
 * ■题目描述
 * 请编写一个方法，将字符串中的空格全部替换为“%20"。假定该字符串有足够的空间
 * 存放新增的字符，并且知道字符串的真实长度(小于等于1000)，同时保证字符串由大
 * 小写的英文字母组成。
 * 给定一个string iniString为原始的串，以及串的长度int len,返回替换后的string。
 * 测试样例:
 * "Mr John Smith", 13
 * 返回: "Mr号20John号20Smi th"
 * "Hello World",12
 * 返回: "He1lo号2082 0World"
 */
// 简直就是在送分
public class Replacement {
    public String replaceSpace(String iniString, int length) {
        // write code here
        return iniString.replaceAll(" ","%20");
    }
}