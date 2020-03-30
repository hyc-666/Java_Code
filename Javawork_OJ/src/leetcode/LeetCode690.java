package leetcode;

//员工的重要性
/**
 * 给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。
 *
 * 比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是[2, 10, [3]]，员工3的数据结构是[3, 5, []]。注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，因此没有体现在员工1的数据结构中。
 *
 * 现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/employee-importance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
// Employee info

import java.util.List;

class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
}

public class LeetCode690 {
    public int getImportance(List<Employee> employees, int id) {
        //递归计算
        for(Employee e : employees){//遍历公司所有员工
            if (e.id == id){//先找到需要计算下属的员工id
                if(e.subordinates.size() <= 0){
                    //如果他没有窒息下属直接返回本身的importance
                    return e.importance;
                }
                int ret = e.importance;
                //递归的计算他的每个下属的importance
                for (int imp : e.subordinates){
                    //遍历他的下属表
                    ret += getImportance(employees, imp);
                    //计算下属的下属，如此递归，如果不止一个下属，这个循环会计算出所有的下属的importance的和
                    //有点类似图的深度优先遍历，先到最底层，再逐层返回
                }
                return ret;//然后返回
            }
        }
        return 0;
    }
}
