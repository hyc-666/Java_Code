package everyDayQuestion.july._0715;

/**
 * @author hyc
 * @date 2020/7/15
 */

import java.util.Scanner;

/**
 * ■题目描述
 * 给定一个字符串，问是否能通过添加一个字母将其变为回文串。
 * 输入描述:
 * -行一个由小写字母构成的字符串，字符串长度小于等于10。
 * 输出描述:
 * 输出答案(YES\NO) .
 * 示例1输入输出示例仅供调试，后台判题数据般不包含示例
 * 输入
 * COCO
 * 输出
 * YES
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String src = scanner.nextLine();
            String dest = new StringBuilder(src).reverse().toString();
            int len = lcs(src,dest);
            if (src.length() - len <= 1){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    //计算原字符串和反转字符串的最大公共子序列的长度
    //这个算法真难，最近的算法题难的一批
    public static int lcs(String s, String s1) {
        if(s == null|| s1 == null) {
            return 0;
        }
        int m = s.length();
        int n = s1.length();
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for(int i = 1; i < m; i++) {
            dp[0][i] = 0;
        }
        for(int i = 1; i < m; i++) {
            dp[i][0] = 0;
        }
        for(int i = 1;i < m + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                if(s.charAt(i - 1) == s1.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
