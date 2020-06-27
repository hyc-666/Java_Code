package everyDayQuestion.june._0627;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author hyc
 * @date 2020/6/27
 */

/**
 * a题目描述
 * 老师想知道从某某同学当中，分数最高的是多少，现在请你编程模拟老师的询问。当
 * 然，老师有时候需要更新某位同学的成绩
 * 输入描述:
 * 输入包括多组测试数据。
 * 每组输入第一行是两个正整数v和M (0 < N <= 30000,0 < M < 5000) ,分别
 * 代表学生的数目和操作的数目。
 * 学生ID编号从1编到N。
 * 第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生
 * 的成绩
 * 接下来又M行，每一行有一个字符c (只取、Q'或心')，和两个正整数A,B,当c
 * 为'Q'的时候，表示这是一-条询问操作，他询问ID从A到B (包括A,B)的学生当
 * 中，成绩最高的是多少
 * 当c为'U'的时候，表示这是一条更新操作， 要求把ID为a的学生的成绩更改为B。
 * 输出描述:
 * 对于每- -次询问操作，在一行里面输出最高成绩.
 *
 * 示例：
 * 输入：
 * 5 7
 * 1 2 3 4 5
 * Q 1 5
 * U 3 6
 * Q 3 4
 * Q 4 5
 * U 4 5
 * U 2 9
 * Q 1 5
 *
 *输出：
 * 5
 * 6
 * 5
 * 9
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int N = scanner.nextInt();//学生人数
            int M = scanner.nextInt();//操作次数
            List<Student> students = new ArrayList<>(N);
            for (int i = 1; i <= N; i++) {
                int score = scanner.nextInt();
                students.add(new Student(i,score));
            }
            for (int i = 0; i < M; i++) {
                String s = scanner.next();
                char ch = s.charAt(0);
                int A = scanner.nextInt();
                int B = scanner.nextInt();
                if (ch == 'Q'){
                    int height = students.get(A - 1).score;
                    for (int j = A; j <= B; j++) {
                        if (height < students.get(j - 1).score){
                            height = students.get(j - 1).score;
                        }
                    }
                    System.out.println(height);
                }else{
                    students.get(A - 1).score = B;
                }

            }
        }
    }
}
class Student{
    int id;
    int score;

    public Student(int id, int score) {
        this.id = id;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", score=" + score +
                '}';
    }
}
