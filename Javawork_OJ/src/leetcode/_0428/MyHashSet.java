package leetcode._0428;

/**
 * 不使用任何内建的哈希表库设计一个哈希集合
 *
 * 具体地说，你的设计应该包含以下的功能
 *
 * add(value)：向哈希集合中插入一个值。
 * contains(value) ：返回哈希集合中是否存在这个值。
 * remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-hashset
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//讲真这个跟前面的hashtable有什么区别，也没要求处理重复啊·
    //直接拿过来改一改算了，
public class MyHashSet {//这个耗时25ms，
    /** Initialize your data structure here. */
    private ListNode[] hashSetArray;
    public MyHashSet() {
        hashSetArray = new ListNode[101];//为了减少冲突
    }

    public void add(int key) {
        int index = hashFun(key);
        if (hashSetArray[index] == null){
            hashSetArray[index] = new ListNode();
        }
        hashSetArray[index].add(key);
    }

    public void remove(int key) {
        int index = hashFun(key);
        if (hashSetArray[index] == null){
            return;
        }
        hashSetArray[index].remove(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = hashFun(key);
        if (hashSetArray[index] == null){
            return false;
        }
        return hashSetArray[index].contains(key);
    }
    //不过，还要写一个哈希函数，还是取模吧
    private int hashFun(int key){
        return Math.abs(key % 101);//为了防止出现负数
    }
}
class Node{
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}
class ListNode{
    Node head = null;

    public ListNode() {

    }
    //因为只需要实现哈希表的增删查改操作，所以只写能够支持实现哈希表的增删改查方法就可以了
    public boolean add(int val){
        //理论上默认应该为尾插，但是为了实现方便，直接头插即可
        //因为要改为set，因此插入之前还要判断是否已经存在
        if (contains(val)){//如果有重复值直接返回
            return false;
        }
        Node node = new Node(val);
        if (head == null){
            head = node;
            return true;
        }
        node.next = head;
        head = node;
        return true;
    }
    public boolean remove(int val){
        if (head == null){
            return false;
        }
        if (head.value == val){//说明删除头节点
            head = head.next;
            return true;
        }
        //需要先找到前驱结点
        Node prev = findPrev(val);
        if (prev == null){
            //如果没有找到前驱结点说明要删除的结点不存在
            return false;
        }
        //然后删除结点
        prev.next = prev.next.next;
        return true;
    }
    public boolean contains(int val){
        for (Node node = head;node != null;node = node.next){
            if (node.value == val){
                return true;
            }
        }
        return false;
    }
    //查找前驱结点
    private Node findPrev(int val){
        //前面已经排除删除头节点的情况，所以这里不对头节点做判断，删除的一定不是头节点
        Node node = head;
        while (node!= null && node.next != null){
            if (node.next.value == val){
                return node;
            }
            node = node.next;
        }
        return null;
    }
    //不需要的方法全部删掉
    //哈希表不提供修改方法，因为一改以后可能哈希值会变化，所以修改操作只能是先删除旧值插入新值
}