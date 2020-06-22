package everyDayQuestion._0622;

/**
 * @author hyc
 * @date 2020/6/22
 */
/**
 * 题目描述
 * 现有一个小写英文字母组成的字符串s和一个包含较短小写英文字符串的数组p,请设计一
 * 个高效算法，对于p中的每一个较短字符串， 判断其是否为s的子串。
 * 给定一个string数组p和它的大小n,同时给定strings, 为母串，请返回一个bool数组， 每
 * 个元素代表p中的对应字符串是否为s的子串。保证p中的串长度小于等于8，且p中的串的
 * 个数小于等于500，同时保证s的长度小于等于1000。
 * 测试样例:
 * ["a", "b", "c", "d"] , 4, "abc"
 * 返回: [true, true, true, false]
 */
public class Substr {
    public boolean[] chkSubStr(String[] p, int n, String s) {
        // write code here
        //判断p中的每一个字符串是不是s的字串，返回一个和p一样大的boolean数组
        //其实完全可以调用库函数
        //设计算法这种事并不是每个人都可以的
        //还好之前了解过一些算法，但是不是我设计出来的，不知道算不算呢
        /**
         * KMP字符串匹配算法是一个解决字串是否在指定字符串中出现过的算法，
         * 如果出现过，则返回最早出现的位置，如果没有出现过就返回一个非法下标
         * 由于这里只是检测是否出现过，所以，实现的时候就可以值判断是否出现过
         * 出现过返回true，没有出现过返回false
         */
        //KMP算法需要借助一个子串的部分匹配值表，比较复杂，不多做介绍
        boolean[] res = new boolean[n];
        for (int i = 0; i < n; i++) {
            int[] next = kmpNext(p[i]);
            res[i] = kmpSearch(s,p[i],next);
        }
        return res;
    }

    /**
     * kmp搜索算法
     * @param str1 原字符串
     * @param str2 需要匹配的子串
     * @param next 子串的部分匹配值表
     * @return 返回字符串开始匹配位置的下标，如果不匹配，则返回一个非法下标，即-1
     */
    public static boolean kmpSearch(String str1,String str2,int[] next){
        for (int i = 0,j = 0; i < str1.length(); i++) {
            //需要考虑str1.charAt(i) ！= str2.charAt(j)时j的位置要重置

            while (j > 0 && str1.charAt(i) != str2.charAt(j)){
                j = next[j - 1];
            }
            if(str1.charAt(i) == str2.charAt(j)){
                j++;
            }
            if(j == str2.length()){
                return true;
            }
        }
        return false;
    }

    //得到子串的部分匹配值表
    public static int[] kmpNext(String dest){
        //创建部分匹配值表
        int[] next = new int[dest.length()];
        next[0] = 0;
        //这个kmp部分匹配表确实有点看不懂
        for (int i = 1,j = 0; i < next.length; i++) {
            while (j > 0 && dest.charAt(i) != dest.charAt(j)){
                j = next[j - 1];
            }
            if (dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
