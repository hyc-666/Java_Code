package everyDayQuestion.june._0630;

/**
 * @author hyc
 * @date 2020/7/2
 */

import java.util.*;

/**
 * s题目描述
 * 请实现接口:
 * unsigned int AddCandidate (char* pCandidateName);
 * 功能:设置候选人姓名
 * 输入: char* pCandidateName候选人姓名
 * 输出:无
 * 返回:输入值非法返回0，已经添加过返回0，添加成功返回1
 * Void Vote(char* pCandidateName);
 * 功能:投票
 * 输入: char* pCandidateName候选人姓名
 * 输出:无
 * 返回:无
 * unsigned int GetVoteResult (char* pCandidateName);
 * 功能:获取候选人的票数。如果传入为空指针，返回无效的票数，同时说明本次投票
 * 活动结束，释放资源
 * 输入: char* pCandidateName候选人姓名。当输入一个空指针时，返回无效的票数
 * 输出:无
 * 返回:该候选人获取的票数
 * void Clear()
 * /1功能:清除投票结果，释放所有资源
 * /1输入:
 * 11输出:无
 * /1返回
 *
 * 输入描述:
 * 输入候选人的人数，第二行输入候选人的名字，第三行输入投票人的人数，第四行
 * 输入投票。
 * 输出描述:
 * 每行输出候选人的名字和得票数量。
 * 示例1输入输出示例仅供调试， 后台判题数据般不包含示例
 * 输入
 * 复制
 * 4
 * ABCD
 * ABCDEFGH
 * 输出
 * | 复制
 * A:1
 * B:1
 * C:1
 * Invalid : 4
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
            Map<String,Integer> map = new HashMap<>(n);
            List<String> candidates = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                String candidate = scanner.next();
                candidates.add(candidate);
                map.put(candidate,0);
            }
            int num = scanner.nextInt();
            int Invalid = 0;
            for (int i = 0; i < num; i++) {
                String name = scanner.next();
                if (!map.containsKey(name)){
                    Invalid++;
                }else{
                    int value = map.get(name);
                    map.put(name,value + 1);
                }
            }
            for (int i = 0; i < n; i++) {
                System.out.println(candidates.get(i) + " : " + map.get(candidates.get(i)));
            }
            System.out.printf("Invalid : %d",Invalid);
        }
    }
}