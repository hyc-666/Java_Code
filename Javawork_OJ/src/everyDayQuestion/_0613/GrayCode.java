package everyDayQuestion._0613;

/**
 * @author hyc
 * @date 2020/6/13
 */
public class GrayCode {
    //这不，意外不是就来了么

    /**
     *■题目描述
     * 在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同，则称这种编码为格
     * 雷码(Gray Code)，请编写一个函数， 使用递归的方法生成N位的格雷码。
     * 给定一个整数n，请返回n位的格雷码，顺序为从0开始。
     * 测试样例:
     * |
     * 返回: ["0", "1"]
     */
    public String[] getGray(int n) {
        // write code here
        //关键信息：每次生成的格雷码是把上一次的格雷码顺序一次再倒序一次，一半前面加上0，一半前面加上1
        if (n == 1){
            return new String[]{"0","1"};
        }else {
            //想算本轮的格雷码，就得知道上一轮的格雷码
            String[] prev = getGray(n - 1);
            //本轮的格雷码的数量是前一轮的一倍
            String[] cur = new String[prev.length * 2];
            //分别在上一轮的前面加上1和0
            for (int i = 0; i < prev.length; i++) {
                cur[i] = "0" + prev[i];
                cur[cur.length - 1 - i] = "1" + prev[i];
                //还必须从后往前装，顺序也不能错，还要对称
            }
            return cur;
        }
    }
}
