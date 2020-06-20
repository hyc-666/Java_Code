package javawebTest;

/**
 * @author hyc
 * @date 2020/6/20
 */

import java.util.*;

/**
 * ■题目描述
 * 给定一个数字arr，其中只有有两个数字出现了奇数次，其它数字都出现了偶数次，按
 * 照从小到大顺序输出这两个数。
 * 输入描述:
 * 输入包含两行，第一-行一一个整数n(1≤n≤105)，代表数组arr的长度，第二行n
 * 个整数，代表数组arr, arr [i]为32位整数。
 * 输出描述:
 * 输出出现奇数次的两个数，按照从小到大的顺序。
 * 示例1输入输出示例仅供调试， 后台判题数据一般不包含示例
 * 输入
 * 复制
 * 4
 * 1123
 * 输出
 * | 复制
 * 23
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
            Map<Integer,Integer> map = new HashMap<>(n);
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                int num = scanner.nextInt();
                arr[i] = num;
            }
            for (int i = 0; i < n; i++) {
                int num = arr[i];
                if (!map.containsKey(num)){
                    map.put(num,1);
                }else{
                    int value = map.get(num);
                    map.put(num,value + 1);
                }
            }
            List<Integer> list = new ArrayList<>(2);
            for (int i = 0; i < n; i++) {
                if (map.get(arr[i]) % 2 != 0){
                    list.add(arr[i]);
                }
            }
            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            System.out.println(list.remove(0) + " " + list.remove(0));
        }
    }
}
