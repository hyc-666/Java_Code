package newCode;
//猫狗收容所

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述
 *         有家动物收容所只收留猫和狗，但有特殊的收养规则，收养人有两种收养方式，
 *         第一种为直接收养所有动物中最早进入收容所的，第二种为选择收养的动物类型（猫或狗），
 *         并收养该种动物中最早进入收容所的。
 *
 *        给定一个操作序列int[][2] ope(C++中为vector<vector<int>>)代表所有事件。
 *        若第一个元素为1，则代表有动物进入收容所，第二个元素为动物的编号，正数代表狗，负数代表猫；
 *        若第一个元素为2，则代表有人收养动物，第二个元素若为0，则采取第一种收养方式，若为1，则指定收养狗，
 *        若为-1则指定收养猫。请按顺序返回收养的序列。若出现不合法的操作，即没有可以符合领养要求的动物，
 *        则将这次领养操作忽略。
 */
public class CatDogAsylum {
    public ArrayList<Integer> asylum(int[][] ope) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> queue = new ArrayList<>();

        for (int[] link : ope){
            if (link[0] == 1){//有动物进入收容所
                queue.add(link[1]);//加入到收容所的队列
            }else if (link[0] == 2){//有人收养动物
                //查看是否有动物可以被收养
                if (queue.size() <= 0){//如果没有可以被收养的动物则直接返回
                    continue;
                }
                if (link[1] == 0){//直接收养最早进入收容所的动物
                    list.add(queue.remove(0));
                }else if(link[1] == 1){//要收养狗
                    if (queue.get(0) > 0){//如果最早进入的正好是狗
                        list.add(queue.remove(0));//则收养狗
                    }else{//否则找最早进入收养所的狗
                        for (int i = 0; i < queue.size(); i++) {
                            if (queue.get(i) > 0) {//找到最早进入的狗
                                list.add(queue.remove(i));//将最早进入的狗删除并收养
                                break;
                            }
                        }
                        //如果没有找到，则什么都没有发生，执行下一轮
                    }
                }else if (link[1] == -1){//如果收养猫
                    if (queue.get(0) < 0){//如果最早进入的正好是猫
                        list.add(queue.remove(0));//则收养猫
                    }else{//否则找最早进入的猫
                        for (int i = 0; i < queue.size(); i++) {
                            if (queue.get(i) < 0) {//找到最早进入的猫
                                list.add(queue.remove(i));//将最早进入的猫删除并收养
                                break;
                            }
                        }
                        //如果没有找到，则什么都没有发生，执行下一轮
                    }
                }
            }
        }
        return list;
    }
}
