package everyDayQuestion.july._0706;

/**
 * @author hyc
 * @date 2020/7/7
 */

import java.io.File;
import java.util.*;

/**
 * ■题目描述
 * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
 * 处理:
 * 1.记录最多8条错误记录，对相同的错误记录(即文件名称和行号完全匹配)只记录一
 * 条，错误计数增加; (文件所在的目录不同，文件名和行号相同也要合并)
 * 2超过16个字符的文件名称，只记录文件的最后有效16个字符; (如果文件名不同，而
 * 只是文件名的后16个字符和行号相同，也不要合并)
 * 3.输入的文件可能带路径，记录文件名称不能带路径
 * 输入描述:
 * 一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。
 * 文件路径为windows格式
 * 如: E:\V1R2\product\ fpgadrive.c 1325
 * 输出描述:
 * 将所有的记录统计并将结果输出，格式:文件名代码行数数目，一个空格隔开，
 * 如: fpgadrive.c 1325 1
 * 结果根据数目从多到少排序，数目相同的情况下，按照输入第一-次出现顺序排
 * 序。
 * 如果超过8条记录，则只输出前8条记录.
 * 如果文件名的长度超过16个字符，则只输出后16个字符
 * 示例1输入输出示例仅供调试，后台判题数据一般不包含示例
 * 输入
 * E: \V1R2\product \ fpgadrive.c 1325
 * 输出
 * fpgadrive.c 1325 1
 */

//题目真的迷得我看不懂
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Count> list = new ArrayList<>();
        while (scanner.hasNextLine()){
            String filename = scanner.next();
            int hang = scanner.nextInt();
            File file = new File(filename);
            Count c = new Count(file.getName(),hang);
            if (!list.contains(c)){
                list.add(c);
            }
        }
        Map<Count,Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (!map.containsKey(list.get(i))){
                map.put(list.get(i),1);
            }else{
                int value = map.get(list.get(i));
                map.put(list.get(i),value + 1);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).filename + " " + list.get(i).hang + map.get(list.get(i)));
        }
    }
}
class Count{
    String filename;
    int hang;

    public Count(String filename, int hang) {
        this.filename = filename;
        this.hang = hang;
    }

    @Override
    public boolean equals(Object obj) {
        Count other = (Count)obj;
        if (this.filename.equals(other.filename) && this.hang == other.hang){
            return true;
        }
        return false;
    }
}