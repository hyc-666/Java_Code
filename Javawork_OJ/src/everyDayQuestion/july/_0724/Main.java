package everyDayQuestion.july._0724;

/**
 * @author hyc
 * @date 2020/7/26
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * ■题目描述
 * 搜狐员工小王最近利用假期在外地旅游，在某个小镇碰到一个马戏团表演，精彩的表
 * 演结束后发现团长正和大伙在帐篷前激烈讨论，小王打听了下了解到，马戏团正打算
 * 出一个新节目“最高罗汉塔”，即马戏团员叠罗汉表演。考虑到安全因素，要求叠罗汉
 * 过程中，站在某个人肩上的人应该既比自己矮又比自己瘦，或相等。团长想要本次节
 * 目中的罗汉塔叠的最高，由于人数众多，正在头疼如何安排人员的问题。小王觉得这
 * 个问题很简单，于是统计了参与最高罗汉塔表演的所有团员的身高体重,并且很快找
 * 到叠最高罗汉塔的人员序列。现在你手上也拿到了这样一份身高体重表，请找出可以
 * 叠出的最高罗汉塔的高度，这份表中马戏团员依次编号为1到N。
 * 输入描述:
 * 首先一个正整数N，表示人员个数。
 * 之后M行，每行三个数，分别对应马戏团员编号，体重和身高。
 * 输出描述:
 * 正整数m，表示罗汉塔的高度。
 */

//还动态规划，什么难度，
    //什么水平自己还没点逼数么
public class Main {

    static class People {
        private int weight;
        private int height;

        public People(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            People[] array = new People[n];
            for (int i = 0; i < n; i++) {
                int index = sc.nextInt();
                array[index - 1] = new People(sc.nextInt(), sc.nextInt());
            }
            Arrays.sort(array, new Comparator<People>() {

                @Override
                public int compare(People o1, People o2) {
                    int result = Integer.compare(o1.height, o2.height);  //按照身高为第一顺序排序
                    if (result != 0) {
                        return result;
                    } else {
                        return Integer.compare(o1.weight, o2.weight);  //身高相等时，按照体重排序
                    }
                }
            });
            int max = Integer.MIN_VALUE;
            int[] dp = new int[n];
            for(int i=0;i<dp.length;i++){
                dp[i] = 1;
                for(int j=i-1;j>=0;j--){
                    if((array[i].weight > array[j].weight) ||
                            (array[i].weight == array[j].weight && array[i].height == array[j].height)){
                        dp[i] = Math.max(dp[i],dp[j]+1);   //第i个人上面能够叠多少个人
                    }
                }
                max = Math.max(dp[i], max);
            }
            System.out.println(max);
        }
    }

}
