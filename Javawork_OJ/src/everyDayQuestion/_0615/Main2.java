package everyDayQuestion._0615;

/**
 * @author hyc
 * @date 2020/6/15
 */

/**
 * 题目描述
 * 请设计一个算法完成两个超长正整数的加法。
 * 接口说明
 * /*
 * 请设计一个算法完成两个超长正整数的加法。
 * 输入参数:
 * String addend:加数
 * String augend:被加数
 * 返回值:加法结果
 * public String AddL onglnteger(String addend, String augend)
 * /*在这里实现功能*/
     /*return null;
             *}
     */
public class Main2 {
    public String AddLongInteger(String addend, String augend){
        //就是模拟竖式计算
        //直接先转成数组
        int len1 = addend.length();
        int len2 = augend.length();
        int len = Math.max(len1,len2) + 1;
        //取两者中等比较长的字符串然后转成等长的，而且为防止结果有进位，再长一位
        int[] str1 = new int[len];
        int[] str2 = new int[len];
        int[] res = new int[len];
        int k = 0;
        for (int i = len1 - 1; i >= 0; i--) {
            str1[str1.length - k - 1] = addend.charAt(i) - 48;
            k++;
        }
        k = 0;
        for (int i = len2 - 1; i >= 0; i--) {
            str2[str2.length - k - 1] = augend.charAt(i) - 48;
            k++;
        }
        //开始计算竖式计算加法
        boolean carry = false;//还要标志是否有进位
        int i = len - 1;
        while (i >= 0) {
            int sum = str1[i] + str2[i];
            if (sum > 9 && carry){
                res[i] = sum - 9;
                carry = true;
            }else if (sum < 10 && carry){
                if (sum + 1 > 9){
                    res[i] = sum - 9;
                    carry = true;
                }else {
                    res[i] = sum + 1;
                    carry = false;
                }
            }else if (sum > 9 && !carry){
                res[i] = sum - 10;
                carry = true;
            }else{
                res[i] = sum;
                carry = false;
            }
            i--;
        }
        StringBuilder stringBuilder = new StringBuilder();
        //判断第一位是不是有进位被占了
        for (int j = 0; j < res.length; j++) {
            stringBuilder.append(res[j]);
        }
        return res[0] == 0 ? stringBuilder.substring(1).toString() : stringBuilder.toString();
    }
}
