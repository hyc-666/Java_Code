package everyDayQuestion.june._0629;

/**
 * @author hyc
 * @date 2020/6/29
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ■题目描述
 * 北京大学对本科生的成绩施行平均学分绩点制(GPA) 。既将学生的实际考分根据不同的学科的
 * 不同学分按一定的公式进行计算。 公式如下: 实际成绩绩点90一- 1004.0 85-- 89 3.7 82
 * -843.378-- -81 3.075-一 -772.7 72-- 742.368--- -71 2.064-- 67 1.5 60-- -63 1.0
 * 60以下01.一门课程的学分绩点=该课绩点该课学分2.总评绩点=所有学科绩点之和/所有课程
 * 学分之和现要求你编写程序求出某人A的总评绩点(GPA) 。
 * 输入描述:
 * 第一行总的课程数n (n<10) ;
 * 第二行相应课程的学分(两个学分间用空格隔开) ;
 * 第三行对应课程的实际得分;
 * 此处输入的所有数字均为整数。
 * 输出描述:
 * 输出有一行，总评绩点，精确到小数点后2位小数。(printf ("&.2f",GPA);)
 * 示例1输入输出示例仅供调试，后台判题数据一般不包含示例
 * 输入
 * 复制
 * 43423
 * 9188726956
 * 输出
 * |复制
 * 2.52
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
            List<Integer> credits = new ArrayList<>(n);
            List<Double> scores = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                credits.add(scanner.nextInt());
            }
            for (int i = 0; i < n; i++) {
                int score = scanner.nextInt();
                if (score >= 90){
                    scores.add(4.0);
                }else if(score >= 85){
                    scores.add(3.7);
                }else if(score >= 82){
                    scores.add(3.3);
                }else if(score>= 78){
                    scores.add(3.0);
                }else if (score >= 75){
                    scores.add(2.7);
                }else if( score >= 72){
                    scores.add(2.3);
                }else if(score >= 68){
                    scores.add(2.0);
                }else if(score >= 64){
                    scores.add(1.5);
                }else if (score >= 60){
                    scores.add(1.0);
                }else{
                    scores.add(0.0);
                }
            }
            List<Double> creditPoints = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                creditPoints.add(credits.get(i) * scores.get(i));
            }
            double sumPoint = 0;
            for (int i = 0; i < n; i++) {
                sumPoint += creditPoints.get(i);
            }
            int creditSum = 0;
            for (int i = 0; i < n; i++) {
                creditSum += credits.get(i);
            }
            double res = sumPoint / creditSum;
            System.out.format("%.2f\n",res);
        }
    }
}
