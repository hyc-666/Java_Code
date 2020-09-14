package didi.q1.q2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author hyc
 * @date 2020/9/13
 */
public class Main {
    public static void main(String[] args) {
        final int N = 65535;//表示不可达
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();

            //创建表示图的矩阵,并赋值
            int[][] test = new int[n][n];
            int[] vertex = new int[n];
            for (int j = 0; j < m; j++) {
                int row = scanner.nextInt() - 1;
                int col = scanner.nextInt() - 1;
                int money = scanner.nextInt();
                test[row][col] = money;
                test[col][row] = money;
            }
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    if (test[j][l] == 0){
                        test[j][l] = N;
                    }
                }

            }
            Graph graph = new Graph(vertex,test);

            graph.dijkstra(0);
        }
    }
}
//图类
class Graph{
    private int[] vertex; //顶点
    private int[][] matrix;  //邻接矩阵
    VisitedVertex vv;

    public Graph(int[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }
    //显示图
    public void showGraph(){
        for (int[] link : matrix){
            System.out.println(Arrays.toString(link));
        }
    }
    //迪杰斯特拉算法实现
    /**
     * @param index 出发顶点
     */
    public void dijkstra(int index){
//        System.out.print("出发点：" + vertex[index]);
        vv = new VisitedVertex(vertex.length,index);
        update(index);//跟新index顶点到其他顶点的距离和其他顶点的前驱节点
        for (int i = 1; i < vertex.length; i++) {
            index = vv.updateArr();//选择并返回新的访问结点
            update(index);//跟新index顶点到其他顶点的距离和其他顶点的前驱节点
        }
        //vv.show();
//        System.out.println(" 到其他顶点的最短路径：");
//        for (int i = 0; i < vertex.length; i++) {
//            System.out.println("->" + vertex[i] + "最短路径:"+ vv.dis[i]);
//        }
    }
    /**
     * @param index 跟新index下标顶点到其他顶点的距离和其他顶点的前驱顶点
     */
    private void update(int index){
        int len = 0;
        for (int i = 0; i < matrix[index].length; i++) {
            //len是从出发点到index顶点的距离+从index到其他顶点的距离
            len = vv.getDis(index) + matrix[index][i];
            //如果i这个顶点还没有访问过并且len的值小于从出发顶点直接到i这个顶点的距离，
            //就需要跟新出发点到i这个顶点的距离
            if(!vv.isVisited(i) && len < vv.getDis(i)){
                vv.updatePre(i,index);//跟新i的前驱结点为index
                vv.updateDis(i,len);//跟新出发点到i这个顶点的距离
            }
        }
    }
}
class VisitedVertex{
    public int[] already_arr;//记录各个顶点是否被访问过，0表示没有，1表示已经访问过
    public int[] pre_visited;//记录每访问一个结点，其他结点的前驱节点
    public int[] dis;// 记录触发顶点到所有结点距离，会动态更新

    /**
     * 构造器
     * @param len 顶点个数
     * @param index 开始顶点的下标
     */
    public VisitedVertex(int len,int index) {
        already_arr = new int[len];
        pre_visited = new int[len];
        dis = new int[len];
        //初始化dis数组，全部初始化为不可达（65535）
//        for (int i = 0; i < dis.length; i++) {
//            dis[i] = 65535;
//        }
        already_arr[index] = 1;//将出发顶点标记为已经访问
        Arrays.fill(dis,65535);
        //设置触发顶点的访问距离为0
        dis[index] = 0;
    }

    /**
     * 判断某个顶点是否已经被访问过
     * @param index 顶点下标
     * @return 访问过是1，返回true，否则返回false
     */
    public boolean isVisited(int index){
        return already_arr[index] == 1;
    }

    /**
     * 跟新出发顶点到index顶点的距离
     * @param index 出发顶点到index顶点
     * @param len 出发顶点到index顶点的距离
     */
    public void updateDis(int index,int len){
        dis[index] = len;
    }

    /**
     * 跟新pre顶点的前驱顶点为index
     * @param pre 需要跟新的顶点
     * @param index  当前顶点的前驱顶点
     */
    public void updatePre(int pre,int index){
        pre_visited[pre] = index;
    }

    /**
     * 返回出发顶点到index顶点的距离
     * @param index 顶点下标
     * @return 返回距离
     */
    public int getDis(int index){
        return dis[index];
    }
    //继续选择并返回新的访问结点，比如G访问完以后就是A，A就是新的访问结点（注意不是出发顶点）
    public int updateArr(){
        int min = 65535;
        int index = 0;
        for (int i = 0; i < already_arr.length; i++) {
            if (already_arr[i] == 0 && dis[i] < min){
                min = dis[i];
                index = i;
            }
        }
        //跟新这个顶点被访问过
        already_arr[index] = 1;
        return index;
    }
//    //显示最后的结果
//    public void show(){
//        System.out.println("=================================");
//        System.out.println("已经访问结果:");
//        System.out.println(Arrays.toString(already_arr));
//        System.out.println("每个顶点的前驱结点;");
//        System.out.println(Arrays.toString(pre_visited));
////        System.out.println("出发点到其他顶点的最短路径：");
////        System.out.println(Arrays.toString(dis));
//    }
}