package duxiaoman.q2;

import java.util.Scanner;

/**
 * @author hyc
 * @date 2020/9/20
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int sum = 0;//使用特异功能的次数
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            char[][] maze = new char[n][m];
            for (int j = 0; j < n; j++) {
                maze[j] = scanner.next().toCharArray();
            }
            //确定起始位置
            Point start = getStart(maze);

            if(setWay(maze,start.x,start.y)){
                //遍历走过以后的地图,用于确定使用了多少次特异功能
                sum = countSp(maze);
            }else{
                sum = -1;
            }
            System.out.println(sum);
        }
    }

    private static int countSp(char[][] maze) {
        int sum = 0;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == 'd'){
                    sum++;
                }
            }
        }
        return sum;
    }

    public static Point getStart(char[][] maze){
        Point p = new Point();
        for (int j = 0; j < maze.length; j++) {
            for (int k = 0; k < maze[0].length; k++) {
                if (maze[j][k] == '@'){
                    p.x = j;
                    p.y = k;
                    maze[j][k] = '.';
                    return p;
                }
            }
        }
        return p;
    }

    public static boolean setWay(char[][] maze,int x,int y){
        if(x >= maze.length || y >= maze[0].length || x <= 0 || y <= 0){
            return true;
        }else {
            if (maze[x][y] == '.'){
                maze[x][y] = 'y';//标记已走
                if(setWay(maze,x + 1,y )){//向下走
                    return true;
                }else if(setWay(maze,x,y + 1)){//向右走
                    return true;
                }else if(setWay(maze,x - 1,y)){//向上走
                    return true;
                }else if(setWay(maze,x,y - 1)){//向左走
                    return true;
                }
                else{//表示此路不通，开始回溯
                    maze[x][y] = '#';
                    return false;
                }
            }else if (maze[x][y] == '*'){
                maze[x][y] = 'd';//将此点破坏
                if(setWay(maze,x + 1,y )){//向下走
                    return true;
                }else if(setWay(maze,x,y + 1)){//向右走
                    return true;
                }else if(setWay(maze,x - 1,y)){//向上走
                    return true;
                }else if(setWay(maze,x,y - 1)){//向左走
                    return true;
                }
                else{//表示此路不通，开始回溯
                    maze[x][y] = '#';
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}
class Point{
    int x;
    int y;
}