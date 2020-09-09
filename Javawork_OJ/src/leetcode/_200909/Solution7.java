package leetcode._200909;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，
 * 如果反转后整数溢出那么就返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author hyc
 * @date 2020/9/9
 */
public class Solution7 {
    public int reverse(int x) {
        String str = x + "";
        long num = Long.parseLong(reverseStr(str.toCharArray()));
//        System.out.println(num);
        if (num > Integer.MAX_VALUE || num <Integer.MIN_VALUE){
            return 0;
        }
        return (int)num;
    }
    public String reverseStr(char[] arr){
        int i = 0,j = arr.length - 1;
        if (arr[0] == '-'){
            i = 1;
        }
        while (i < j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        Solution7 test = new Solution7();
        System.out.println(test.reverse(-454645439));
    }
}
