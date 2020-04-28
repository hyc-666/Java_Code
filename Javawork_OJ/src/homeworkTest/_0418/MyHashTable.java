package homeworkTest._0418;

//哈希表
public class MyHashTable {
    //使用哈希桶的方式解决冲突，即使用数组+链表的方式完成哈希表的增删改查等操作
    private ListNode[] hashArray;
    public int size = 0;
    /**
     *
     * @param size 指定默认的哈希表的数组长度
     */
    public MyHashTable(int size) {
        hashArray = new ListNode[size];
    }

    public MyHashTable() {
        //如果不指定长度则默认为7
        hashArray = new ListNode[7];
    }

    //增
    public void add(int val){
        int index = hashFun(val);
        if (hashArray[index] == null){
            hashArray[index] = new ListNode();
        }
        hashArray[index].add(val);
        size++;
    }
    //删
    public boolean delete(int val){
        int index = hashFun(val);
        if (hashArray[index] == null){//说明要删除的值不存在，直接返回false
            return false;
        }
        hashArray[index].delete(val);
        size--;
        return true;
    }
    //查
    public Integer get(int val){
        int index = hashFun(val);
        if (hashArray[index] == null){
            return null;
        }
        return hashArray[index].get(val);
    }
    //哈希表不提供改的方法，只能删除旧值插入新值
    public boolean contains(int val){
        int index = hashFun(val);
        if (hashArray[index] == null){
            return false;
        }
        return hashArray[index].contains(val);
    }
    //清除哈希表
    public void clear(){
        hashArray = new ListNode[hashArray.length];
        size = 0;
    }

    //显示哈希表的数据存储情况
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < hashArray.length; i++) {
            str.append(hashArray[i] + "\r\n");
        }
        return str.toString();
    }

    //哈希函数，使用简单取模来计算哈希值
    private int hashFun(int val){
        return val % hashArray.length;
    }

}

//链表的结点
class Node{
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value + "";
    }
}

//定义链表
class ListNode{
    Node head = null;

    public ListNode() {

    }
    //因为只需要实现哈希表的增删查改操作，所以只写能够支持实现哈希表的增删改查方法就可以了
    public boolean add(int val){
        //理论上默认应该为尾插，但是为了实现方便，直接头插即可
        Node node = new Node(val);
        if (head == null){
            head = node;
            return true;
        }
        node.next = head;
        head = node;
        return true;
    }
    public boolean delete(int val){
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
    //根据键值查找节点

    public Integer get(int val) {
        if (head == null){
            return null;
        }

        for (Node node = head;node != null;node = node.next){
            if (node.value == val){
                return node.value;
            }
        }
        return null;
    }
    //哈希表不提供修改方法，因为一改以后可能哈希值会变化，所以修改操作只能是先删除旧值插入新值

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("{");
        for (Node node = head;node != null;node = node.next){
            str.append(node.value + ",");
        }
        str.append("}");
        return str.toString();
    }
}