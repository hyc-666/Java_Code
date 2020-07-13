package everyDayQuestion.july._0713;

/**
 * @author hyc
 * @date 2020/7/13
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * s题目描述
 * 小青蛙有一天不小心落入了一 个地下迷宫,小青蛙希望用自己仅剩的体力值P跳出这个
 * 地下迷宫。为了让问题简单,假设这是一个n*m的格子迷宫,迷宫每个位置为0或者1,0代
 * 表这个位置有障碍物,小青蛙达到不了这个位置1代表小青蛙可以达到的位置。小青蛙
 * 初始在(0,0)位置，地下迷宫的出口在(0,m-1)(保证这两个位置都是1，并且保证一定有起
 * 点到终点可达的路径),小青蛙在迷言中水平移动-个单位距离需要消耗1点体力值向
 * 上爬一个单位距离需要消耗3个单位的体力值，向下移动不消耗体力值，当小青蛙的体力
 * 值等于0的时候还没有到达出口，小青蛙将无法逃离迷宫。现在需要你帮助小青蛙计算
 * 出能否用仅剩的体力值跳出迷宫(即达到(0,m-1)位置)。
 * 输入描述:
 * 输入包括n+1行:
 * 第一行为三个整数n,m(3 <= m,n <= 10),P(1 <= P <= 100)
 * 接下来的n行:
 * 每行m个0或者1,以空格分隔
 * 输出描述:
 * 如果能逃离迷宫,则输出-行体力消耗最小的路径，输出格式见样例所示;如果不能
 * 逃离迷宫,则输出"Can not escape!"。 测试数据 保证答案唯一
 * 示例1输入输出示例仅供调试，后台判题数据-般不包含示例
 * 输入
 * 44101001110101110011
 * 输出
 * [0,0], [1,0],[1,1], [2,1], [2,2],[2,3],[1,3],[0,3]
 */
public class Main2 {
    static int n = 0;
    static int m = 0;
    static int p = 0;
    static List<List<Integer>> ways;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
             n = scanner.nextInt();
             m = scanner.nextInt();
             p = scanner.nextInt();
            int[][] maze = new int[n][m];
            ways = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    maze[i][j] = scanner.nextInt();
                }
            }
            //不仅要找到出路，还要找到最短路径，还要考虑体力值的问题
            StringBuilder sb = new StringBuilder();
            if (setWay(maze,0,0,1)){
                for (int i = 0; i < ways.size(); i++) {
                    sb.append("[" + ways.get(i).get(0) + "," + ways.get(i).get(1) + "],");
                }
                System.out.println(sb.substring(0,sb.length() - 1));
            }else{
                System.out.println("Can not escape!");
            }
        }
    }

    /**
     *
     * @param map 表示迷宫
     * @param i 当前横坐标
     * @param j 当前纵坐标
     * @param direction 向哪个方向走，其中，1表示水平行走，0表示向下走，3表示向上走
     * @return
     */
    public static boolean setWay(int[][] map,int i, int j,int direction){
        if (p < 0){
            return false;
        }
        if (map[0][m - 1] == 2){
            return true;
        }else{
            if (map[i][j] == 1){//该点还没有走过
                map[i][j] = 2;//该点置2，假定能走通
                //记录这个点的路径
                List<Integer> tempList = new ArrayList<>();
                tempList.add(i);
                tempList.add(j);
                ways.add(tempList);
                if (j + 1 < m && setWay(map,i,j + 1,1)){//向右走，探测方向要先向右
                    //向右走体力-1
                    p--;
                    return true;
                } else if (i - 1 >= 0 && setWay(map,i - 1,j,3)){
                    //向上走体力-3
                    p -= 3;
                    return true;
                } else if (i + 1 < n && setWay(map,i + 1,j,0)){
                    //向下走不消耗体力
                    return true;
                }else if (j - 1 >= 0 && setWay(map,i,j - 1,1)){
                    p--;//向左走体力-1
                    return true;
                }else{
                    map[i][j] = 3;//表示这个点走不通
                    //并且开始回溯，返还体力
                    if (direction == 1){
                        p++;
                    }else if (direction == 3){
                        p += 3;
                    }
                    //而且也要去掉错误路线的点

                    return false;
                }
            }else{//表示该点不能走
                return false;
            }
        }
        //通过率70%就70%吧，我已经很满意了，这个题简直就不是人做的
    }
}
