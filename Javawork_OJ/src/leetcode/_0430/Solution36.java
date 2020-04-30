package leetcode._0430;
//有效的数独
/**
 * @author hyc
 * @date 2020/4/30
 */

import java.util.HashSet;
import java.util.Set;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 *
 * 上图是一个部分填充的有效的数独。
 *
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 *      但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * 说明:
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        //验证三遍
        //第一遍，逐行

        for (int i = 0; i < board[0].length; i++) {
            Set<Integer> set = new HashSet<>(9);
            for (int j = 0; j < board.length; j++) {
                int num = board[i][j] - 49;
                if (num > 0 && num <= 9){
                    if (!set.contains(num)){
                        set.add(num);
                    }else{
                        return false;
                    }
                }
            }
            set.clear();
        }
        //第二遍，逐列
        for (int i = 0; i < board[0].length; i++) {
            Set<Integer> set = new HashSet<>(9);
            for (int j = 0; j < board.length; j++) {
                int num = board[j][i] - 49;
                if (num > 0 && num <= 9){
                    if (!set.contains(num)){
                        set.add(num);
                    }else{
                        return false;
                    }
                }
            }
            set.clear();
        }
        //第三遍，检查每个小方格
        for (int i = 0; i < 9; i++) {
            Set<Integer> set = new HashSet<>(9);
            for (int j = 0; j < 3; j++) {
                int num = board[j][i] - 49;
                if (num > 0 && num <= 9){
                    if (!set.contains(num)){
                        set.add(num);
                    }else{
                        return false;
                    }
                }
                if ((i + 1) % 3 == 0){
                    set.clear();
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            Set<Integer> set = new HashSet<>(9);
            for (int j = 3; j < 6; j++) {
                int num = board[j][i] - 49;
                if (num > 0 && num <= 9){
                    if (!set.contains(num)){
                        set.add(num);
                    }else{
                        return false;
                    }
                }
                if ((i + 1) % 3 == 0){
                    set.clear();
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            Set<Integer> set = new HashSet<>(9);
            for (int j = 6; j < 9; j++) {
                int num = board[j][i] - 49;
                if (num > 0 && num <= 9){
                    if (!set.contains(num)){
                        set.add(num);
                    }else{
                        return false;
                    }
                }
                if ((i + 1) % 3 == 0){
                    set.clear();
                }
            }
        }
        return true;
    }
    //那个算九宫格的我也看不懂
   /* public boolean isValidSudoku(char[][] board) {
        Map<Character,Integer> count = new HashMap<Character,Integer>();

        //每一行处理
        for(int row=0;row<9;row++){
            count.clear();
            for(int col=0;col<9;col++){
                //遇到空白就略过
                if(board[row][col]=='.'){continue;}
                //首次出现的数字
                if(count.get(board[row][col])==null){
                    count.put(board[row][col],1);
                    //再次出现的数字
                }else{

                    return false;
                }

            }
        }

        //每一列处理
        for(int col1=0;col1<9;col1++){
            count.clear();
            for(int row1=0;row1<9;row1++){
                //遇到空白就略过
                if(board[row1][col1]=='.'){continue;}
                //首次出现的数字
                if(count.get(board[row1][col1])==null){
                    count.put(board[row1][col1],1);
                    //再次出现的数字
                }else{

                    return false;
                }

            }

        }

        int i=0;
        int j=0;
        //九宫格处理
        while(i<9){
            count.clear();
            //每个3*3的处理
            for(int row2=i;row2<i+3;row2++){
                for(int col2=j;col2<j+3;col2++){
                    if(board[row2][col2]=='.'){continue;}
                    if(count.get(board[row2][col2])==null){
                        count.put(board[row2][col2],1);
                    }else{
                        return false;
                    }
                }
            }
            //同一行相邻九宫格移动
            if(j+3!=9){
                j=j+3;
                //同一行相邻九宫格遍历完毕，下一行首个九宫格移动
            }else{
                i=i+3;
                j=0;
            }
        }
        return true;
    }*/
}
