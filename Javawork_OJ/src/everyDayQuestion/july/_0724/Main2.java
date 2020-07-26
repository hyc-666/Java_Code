package everyDayQuestion.july._0724;

/**
 * @author hyc
 * @date 2020/7/26
 */
import java.util.*;

/**
 * s题目描述
 * 有n个学生站成-排，每个学生有一个能力值， 牛牛想从这n个学生中按照顺序选取
 * k名学生，要求相邻两个学生的位置编号的差不超过d,使得这k个学生的能力值的
 * 乘积最大，你能返回最大的乘积吗?
 * 输入描述:
 * 每个输入包含1个测试用例。每个测试数据的第一-行包含一个整数n (1 <= n
 * <= 50)，表示学生的个数，接下来的一-行，包含n个整数，按顺序表示每个学
 * 生的能力值a1 (-50 <= ai <= 50) 。接下来的一-行包含两个整数，k和d
 * (1<=k<=10，1<=d<=50)。
 * 输出描述:
 * 输出一行表示最大的乘积。
 * 示例1输入输出示例仅供调试， 后台判题数据一般不包含示例
 * 输入
 * | 复制
 * 3
 * 747
 * 2 50
 * 输出
 * |复制|
 * 49
 */
//大厂真的不是人人都能够进的，动态规划本来就难的一批
    //还老是考一些动态规划变种的题目
public class Main2{

    public static void main(String[] args){

        //获取学生个数
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n + 1];
        //获取能力值
        for(int i = 1;i <= n; i++) {
            arr[i] = scanner.nextInt();
        }
        //获取k值
        int k = scanner.nextInt();
        //获取d值
        int d = scanner.nextInt();
        //创建最大值和最小值两个辅助数组，long数组存放数值，范围更大
        long[][] f = new long[n + 1][k + 1];
        long[][] g = new long[n + 1][k + 1];
        //初始化两个数组，即K=1的情况
        for(int i = 1; i <= n; i++) {
            f[i][1] = arr[i];
            g[i][1] = arr[i];
        }
        //从k = 2开始填充（遍历每一行）
        for(int curK = 2; curK <= k; curK++) {
            for(int curN = curK; curN <= n; curN++) {  //遍历每一列
                long tempMax = Long.MIN_VALUE;         //临时最大、最小值变量
                long tempMin = Long.MAX_VALUE;
                //根据left的两个边界条件进行遍历
                for(int left = Math.max(curK - 1, curN - d); left <= curN - 1; left++){
                    //根据所得的递推公式更新最小值 最大值
                    if(tempMax < Math.max(f[left][curK - 1] * arr[curN], g[left][curK - 1] * arr[curN])) {
                        tempMax = Math.max(f[left][curK - 1] * arr[curN], g[left][curK - 1] * arr[curN]);
                    }

                    if(tempMin > Math.min(f[left][curK - 1] * arr[curN], g[left][curK - 1] * arr[curN])) {
                        tempMin = Math.min(f[left][curK - 1] * arr[curN], g[left][curK - 1] * arr[curN]);
                    }
                }
                //更新最大值
                f[curN][curK] = tempMax;
                //更新最小值
                g[curN][curK] = tempMin;
            }
        }
        //确定了K值，要得到最大值，则遍历第K列，即搜索f[curN~n][K]  （curN >= k）
        long maxResult = Long.MIN_VALUE;
        for(int curN = k; curN <= n; curN++) {
            if(f[curN][k] > maxResult)
                maxResult = f[curN][k];
        }
        System.out.println(maxResult);
    }
}