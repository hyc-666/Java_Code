package everyDayQuestion.july._0708;

/**
 * @author hyc
 * @date 2020/7/9
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * ■题目描述
 * 大家应该都会玩锤子剪刀布”的游戏:
 * 现给出两人的交锋记录，请统计双方的胜、平、负次数，并且给出双方分别出什么手
 * 势的胜算最大。
 * 输入描述:
 * 输入第1行给出正整数N (<=105)，即双方交锋的次数。随后v行，每行给出一次
 * 交锋的信息，即甲、乙双方同时给出的的手势。c代表“锤子”、J代表剪刀”、B
 * 代
 * 表“布”，第1个字母代表甲方，第2个代表乙方，中间有1个空格。
 * 输出描述:
 * 输出第1、2行分别给出甲、乙的胜、平、负次数，数字间以1个空格分隔。第3行
 * 给出两个字母，分别代表甲、乙获胜次数最多的手势，中间有1个空格。如果解不
 * 唯
 * 一，则输出按字母序最小的解。
 * 示例1输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 * 10
 * CJ
 * JB
 * CB
 * BB
 * BC
 * CC
 * CB
 * BC
 * 输出
 * 532
 * 235
 */
//我隔着屏幕都感受到了这个题满满的恶意
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] countJ = new int[3];
            int[] countY = new int[3];
            Map<String,Integer> mapJ = new HashMap<>(3);//用来统计分别出什么获胜的次数
            Map<String,Integer> mapY = new HashMap<>(3);

            mapJ.put("J",0);
            mapJ.put("C",0);
            mapJ.put("B",0);

            mapY.put("J",0);
            mapY.put("C",0);
            mapY.put("B",0);
            for (int i = 0; i < n; i++) {
                String jia = scanner.next();
                String yi = scanner.next();
                if (jia.equals("C")){//甲出锤子
                    if (yi.equals("C")){//乙也出锤子
                        countJ[1]++;//平+1
                        countY[1]++;
                    }else if (yi.equals("J")){//乙出剪刀
                        countJ[0]++;//甲胜+1
                        int value = mapJ.get("C");//甲出锤子获胜次数+1
                        mapJ.put("C",value + 1);
                        countY[2]++;//乙负+1
                    }else{//乙出布
                        countJ[2]++;//甲负+1
                        int value = mapY.get("B");//乙出布获胜次数+1
                        mapY.put("B",value + 1);
                        countY[0]++;//乙获胜+1
                    }
                }else if (jia.equals("J")){//甲出剪刀
                    if (yi.equals("C")){
                        countJ[2]++;//甲负+1
                        int value = mapY.get("C");//乙出锤子获胜+1
                        mapY.put("C",value + 1);
                        countY[0]++;//乙获胜+1
                    }else if (yi.equals("J")){//乙也出剪刀
                        countJ[1]++;//平各+1
                        countY[1]++;
                    }else{//乙出布
                        countJ[0]++;//甲获胜+1
                        int value = mapJ.get("J");
                        mapJ.put("J",value + 1);//甲出剪刀获胜+1
                        countY[2]++;//乙负+1
                    }
                }else{//甲出布
                    if (yi.equals("C")){//乙出锤子
                        countJ[0]++;//甲获胜+1
                        int value = mapJ.get("B");
                        mapJ.put("B",value + 1);
                        countY[2]++;//乙负+1
                    }else if (yi.equals("J")){//乙出剪刀
                        countJ[2]++;//甲负+1
                        int value = mapY.get("J");
                        mapY.put("J",value + 1);//乙出剪刀获胜+1
                        countY[0]++;//乙获胜+1
                    }else{//乙出布
                        countJ[1]++;//平各+1
                        countY[1]++;
                    }
                }
            }
            System.out.println(countJ[0] + " " + countJ[1] + " " + countJ[2]);
            System.out.println(countY[0] + " " + countY[1] + " " + countY[2]);
            int maxJ = Integer.MIN_VALUE;
            String mj = "B";
            if (maxJ < mapJ.get("B")){
                maxJ = mapJ.get("B");
                mj = "B";
            }
            if (maxJ < mapJ.get("C")){
                maxJ = mapJ.get("C");
                mj = "C";
            }
            if (maxJ < mapJ.get("J")){
                maxJ = mapJ.get("J");
                mj = "J";
            }

            int maxY = Integer.MIN_VALUE;
            String my = "B";
            if (maxY < mapY.get("B")){
                maxY = mapY.get("B");
                my = "B";
            }
            if (maxY < mapY.get("C")){
                maxY = mapY.get("C");
                my = "C";
            }
            if (maxY < mapY.get("J")){
                maxY = mapY.get("J");
                my = "J";
            }
            System.out.println(mj + " " + my);
        }
    }
}
