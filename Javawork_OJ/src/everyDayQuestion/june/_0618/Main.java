package everyDayQuestion.june._0618;

/**
 * @author hyc
 * @date 2020/6/18
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述
 * 洗牌在生活中十分常见，现在需要写一个程序模拟洗牌的过程。 现在需要洗2n张牌，
 * 从上到下依次是第1张，第2张，第3张- 直到第2n张。 首先，我们把这2n张牌分成两
 * 堆，左手拿着第1张到第n张(上半堆)，右手拿着第n+ 1张到第2n张(下半堆)。接
 * 着就开始洗牌的过程，先放下右手的最后- -张牌， 再放下左手的最后- -张牌，接着放
 * 下右手的倒数第二张牌，再放下左手的倒数第二张牌，直到最后放下左手的第一张
 * 牌。接着把牌合并起来就可以了。例如有6张牌，最开始牌的序列是1,2,3,4,5,6。 首先
 * 分成两组，左手拿着1,2,3;右手拿着4,5,6。 在洗牌过程中按序放下了6,3,5,2,4,1。
 * 把这六张牌再次合成一组牌之后， 我们按照从上往下的顺序看这组牌，就变成了序列
 * 1,4,2,5,3,6。现在给出一个原始牌组，请输出这副牌洗牌k次之后从上往下的序列。
 * 输入描述:
 * 第一行一个数T(T≤100)， 表示数据组数。对于每组数据，第一-行两个数n, k(1
 * ≤n,k≤100)，接下来一行有2n个数a1,a2,...a2n(1≤ai≤
 * 1000000000)。表示原始牌组从上到下的序列。
 * 输出描述:
 * 对于每组数据，输出一行，最终的序列。数字之间用空格隔开，不要在行末输出多
 * 余的空格。
 */

public class Main {
    //对于大多数不通过的题目来说，牛客的许多题目都是倒在了输入与输出上面
    //它的这个输入输出迷的一批
    //描述与示例完全不一样
    //不过，结果居然一次过了
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();//表示数组组数
        //循环T次
        for (int i = 0; i < T; i++) {
            //第一行两个数n，k
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            //把数据存到list里
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < 2 * n; j++) {
                list.add(scanner.nextInt());
            }
            //开始洗牌
            for (int j = 0; j < k; j++) {
                poker(list);
            }
            //输出结果
            //最后不能带空格，就只能拼接字符串或者是最后一个单独输出
            StringBuilder stringBuilder = new StringBuilder();
            while (!list.isEmpty()){
                stringBuilder.append(list.remove(0) + " ");
            }
            System.out.println(stringBuilder.substring(0,stringBuilder.length() - 1));
        }


    }
    public static void poker(List<Integer> list){
        int n = list.size() / 2;
        //分成两份
        List<Integer> listL = new ArrayList<>(n);
        List<Integer> listR = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            listL.add(list.remove(0));
        }
        for (int i = 0; i < n; i++) {
            listR.add(list.remove(0));
        }
        //开始洗牌，是从后往前洗的
        boolean right = true;
        while (!listL.isEmpty() || !listR.isEmpty()){
            //先放右手的最后一张牌
            if (right){
                list.add(0,listR.remove(listR.size() - 1));
                right = false;
            }else{
                list.add(0,listL.remove(listL.size() - 1));
                right = true;
            }
        }
    }
}
