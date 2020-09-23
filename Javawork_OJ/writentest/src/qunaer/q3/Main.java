package qunaer.q3;

/**
 * @author hyc
 * @date 2020/9/23
 */

import java.util.*;

/**
 * 德州扑克的花型由N 张扑克牌组成 0 < N < 8，可以组成的牌型按照价值从高到低来区分分别为：
 *     1.皇家同花顺：最高为Ace（一点）的同花顺。
 *     如A K Q J 10 的同花顺
 *     2.同花顺：同一花色，五张顺序的牌。
 *     如：K Q J 10 9 的同花顺
 *     3.四条：有四张同一点数的牌。
 *     如：4 4 4 4 9
 *     4.葫芦：三张同一点数的牌，加一对其他点数的牌。
 *     如：3 3 3 10 10
 *     5.同花：五张同一花色的牌。
 *     如：J 10 8 7 5 的全是红桃的牌
 *     6.顺子：五张顺连的牌。
 *     如：5 4 3 2 A 的非同花牌（此牌型为最小的顺子）
 *     7.三条：仅有三张同一点数的牌，其余两张点数不同。
 *     如: 9 9 9 5 3
 *     8：两对：两张相同点数的牌，加另外两张相同点数的牌。
 *     如：K K 5 5 2
 *     9.一对：仅有两张相同点数的牌。
 *     如：10 10 9 4 2
 *     10.高牌：不符合上面任何一种牌型的牌型，由单牌且不连续不同花的组成，以点数决定大小。
 *     如：A 10 9 5 3 的非同花的牌
 * 这十种牌型分别输出 HuangJiaTongHuaShun、TongHuaShun、SiTiao、HuLu、TongHua、ShunZi、SanTiao、LiangDui、YiDui、GaoPai
 * 扑克牌有4种花色，分别为 （S表示黑桃，H表示红心，C表示草花，D表示方片）
 * 本题的输入为任意 小于 8 的 N张牌
 * 得到的结果为这些牌中排序最靠前的类型。
 *
 * 输入描述
 * 2（牌数为2）
 * SA HA (两张牌为黑桃A 红心A)
 * 输出描述
 * YiDui (结果为一对)
 * 样例输入
 * 5
 * SA SK SQ SJ S10
 * 样例输出
 * HuangJiaTongHuaShun
 */
public class Main {
    public String[] sqence = {"HuangJiaTongHuaShun","TongHuaShun",
            "SiTiao","HuLu","TongHua","ShunZi","SanTiao","LiangDui","YiDui","GaoPai"};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
            List<String> stringList = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                stringList.add(scanner.next());
            }
            //获得花色情况
            Map<Character, Integer> map = countHuase(stringList);
            //获得点数情况
            List<String> points = getPoints(stringList);
            //处理点数
            List<Integer> list = handlePoints(points);
            Map<Integer, Integer> map1 = countPoints(list);
            if (isTonghua(map)){
                if (isShun(list)){
                    System.out.println("TongHuaShun");
                }else {
                    System.out.println("TongHua");
                }
            }else {
                if (isShun(list)){
                    System.out.println("ShunZi");
                }else {
                    if (isSitiao(map1)){
                        System.out.println("Sitiao");
                    }else {
                        if (isSantiao(map1)){
                            System.out.println("Santiao");
                        }else {
                            int duizi = countDuizi(map1);
                            if (duizi >= 2){
                                System.out.println("Liangdui");
                            }else if(duizi >= 1){
                                System.out.println("Yidui");
                            }else{
                                System.out.println("GaoPai");
                            }
                        }
                    }
                }
            }
        }
    }
    //用来统计同花色的个数
    public static Map<Character,Integer> countHuase(List<String> list){
        Map<Character,Integer> map = new HashMap<>();
        for (String s : list){
            char ch = s.charAt(0);
            if (!map.containsKey(ch)){
                map.put(ch,1);
            }else {
                int val = map.get(ch);
                map.put(ch,val + 1);
            }
        }
        return map;
    }

    //抽取出点数
    public static List<String> getPoints(List<String> list){
        List<String> res = new ArrayList<>();
        for(String s : list){
            res.add(s.substring(1));//去掉花色,筛选出点数
        }
        return res;
    }
    //如果有点数大于6,A作为14处理,如果有点数小于6,A作为1处理
    //A 需要单另做讨论
    /**
     *
     * @param s
     * @return 返回true则A作为14处理,返回false则A作为1处理
     */
    public static boolean handleA(String s){
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '6'){
                return false;
            }
        }
        return true;
    }
    //处理点数
    public static List<Integer> handlePoints(List<String> list){
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (handleA(list.get(i))){
                list.set(i,list.get(i).replace("A","14"));
            }else {
                list.set(i,list.get(i).replace("A","1"));
            }
        }
        for(String s : list){
            if (s.equals('J')){
                s = "11";
            }
            if (s.equals('Q')){
                s = "12";
            }
            if (s.equals('K')) {
                s = "13";
            }
            res.add(Integer.parseInt(s));
        }
        return res;
    }

    //判断是否同花
    public static boolean isTonghua(Map<Character,Integer> map){
        for(Map.Entry entry : map.entrySet()){
            if ((int)entry.getValue() >= 5){
                return true;
            }
        }
        return false;
    }
    //判断是否顺子
    public static boolean isShun(List<Integer> list){
        //先排序,看差值是否都是1
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) + 1 != list.get(i + 1)){
                return false;
            }
        }
        return true;
    }

    //统计点数个数
    public static Map<Integer,Integer> countPoints(List<Integer> list){
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : list){
            if (!map.containsKey(num)){
                map.put(num,1);
            }else {
                int val = map.get(num);
                map.put(num,val + 1);
            }
        }
        return map;
    }

    //是否四条
    public static boolean isSitiao(Map<Integer,Integer> map){
        for (Map.Entry entry : map.entrySet()){
            if ((int)entry.getValue() >= 4){
                return true;
            }
        }
        return false;
    }
    //是否三条
    public static boolean isSantiao(Map<Integer,Integer> map){
        for (Map.Entry entry : map.entrySet()){
            if ((int)entry.getValue() >= 3){
                return true;
            }
        }
        return false;
    }
    //统计对子个数
    public static int countDuizi(Map<Integer,Integer> map){
        int count = 0;
        for (Map.Entry entry : map.entrySet()){
            if ((int)entry.getValue() >= 2){
                count++;
            }
        }
        return count;
    }

    //判断是否皇家同花顺
    public static boolean isHuang(List<Integer> list){
        int sum = 0;
        return false;
    }

}
