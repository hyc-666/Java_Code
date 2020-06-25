package everyDayQuestion.june._0622;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author hyc
 * @date 2020/6/22
 */

/**
 * ■题目描述
 * 查找和排序
 * 题目:输入任意(用户，成绩)列，可以获得成绩从高到低或从低到高的排列,相同
 * 成绩
 * 都按先录入排列在前的规则处理。
 * 例示:
 * jack 70
 * peter
 * 96
 * Tom
 * 70
 * smith
 * 67
 * 从高到低成绩
 * peter
 * 96
 * jack 70
 * Tom
 * 70
 * smith
 * 从低到高
 * smith
 * 67
 * Tom
 * 70
 * jack 70
 * peter
 * 96
 * 输入描述:
 * 输入多行，先输入要排序的人的个数，然后分别输入他们的名字和成绩，以- 一个空
 * 格隔开
 * 输出描述:
 * 按照指定方式输出名字和成绩，名字和成绩之间以-一个空格隔开
 */
public class Main {
    //主观上来看，最好的办法是使用map来存储类似于这样的键-值类型的数据，但是map达不到排序的功能
    //因此还是要自己写一个类来自定义排序方式
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int method = scanner.nextInt();//排序方式
            List<User> list = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                String name = scanner.next();
                int score = scanner.nextInt();
                list.add(new User(name, score));
            }
            //按照题目中给出的示例方式来看，0应该是表示降序
            //那么其他的就应该是升序了
            if (method == 0) {
                list.sort(new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {//自定义排序方式
                        //题目示例中是降序的
                        return o2.score - o1.score;
                    }
                });
            }else {
                list.sort(new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        return o1.score - o2.score;
                    }
                });
            }
            //然后输出
            //果然题目还是要靠着自己去摸索着理解了
            for (User item : list) {
                System.out.println(item.name + " " + item.score);
            }
        }
    }
}

class User {
    String name;
    int score;

    public User(String name, int score) {
        this.name = name;
        this.score = score;
    }
}