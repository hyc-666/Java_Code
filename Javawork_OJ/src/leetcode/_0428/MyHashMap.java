package leetcode._0428;
//设计哈希映射

/**
 * 不使用任何内建的哈希表库设计一个哈希映射
 *
 * 具体地说，你的设计应该包含以下的功能
 *
 * put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。
 * get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。
 * remove(key)：如果映射中存在这个键，删除这个数值对。
 *
 * 示例：
 *
 * MyHashMap hashMap = new MyHashMap();
 * hashMap.put(1, 1);          
 * hashMap.put(2, 2);        
 * hashMap.get(1);            // 返回 1
 * hashMap.get(3);            // 返回 -1 (未找到)
 * hashMap.put(2, 1);         // 更新已有的值
 * hashMap.get(2);            // 返回 1
 * hashMap.remove(2);         // 删除键为2的数据
 * hashMap.get(2);            // 返回 -1 (未找到)
 *
 * 注意：
 *
 * 所有的值都在 [0, 1000000]的范围内。
 * 操作的总数目在[1, 10000]范围内。
 * 不要使用内建的哈希库。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-hashmap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MyHashMap {
    //精心设计半天居然超时，那只好牺牲空间了
    private ListEntry[] hashMapArray;

    /** Initialize your data structure here. */
    public MyHashMap() {
        hashMapArray = new ListEntry[10001];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = hashMapFun(key);
        if (hashMapArray[index] == null){
            hashMapArray[index] = new ListEntry();
        }
        hashMapArray[index].put(key,value);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = hashMapFun(key);
        if (hashMapArray[index] == null){
            return -1;
        }
        return hashMapArray[index].get(key);
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = hashMapFun(key);
        if (hashMapArray[index] == null){
            return;
        }
        hashMapArray[index].remove(key);
    }
    //不过，还要设计一个hash函数，还是取模吧
    private int hashMapFun(int key){
        return Math.abs(key % hashMapArray.length);
    }
}
//设计一个能存储键值对的类
class MyEntry{
    int key;
    int value;
    //还是设计成链表吧
    MyEntry next;
    public MyEntry(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
//还得需要一个类来组织这些键值对
class ListEntry{
    MyEntry head = null;
    //四个功能，put,remove,contains和get

    public ListEntry() {
    }
    //add
    public void put(int key,int value){
        //键值不许重复
        if (contains(key)){//如果存在则进行修改
            //查询这个键值对
            MyEntry entry = search(key);
            entry.value = value;
            return;
        }
        MyEntry myEntry = new MyEntry(key,value);
        if (head == null){
            head = myEntry;
            return;
        }
        myEntry.next = head;
        head = myEntry;
    }
    public boolean contains(int key){
        MyEntry myEntry = head;
        while (myEntry != null){
            if (myEntry.key == key){
                return true;
            }
            myEntry = myEntry.next;
        }
        return false;
    }
    public void remove(int key){
        if (head == null){
            return;
        }
        //判断是否删除头节点
        if (head.key == key){
            head = head.next;
            return;
        }
        //remove需要先查找前驱节点
        MyEntry prev = searchPrev(key);
        if (prev == null){//如果没找到则说明删除的值不存在
            return;
        }
        //如果找到，那么prev.next一定不为空
        prev.next = prev.next.next;

    }
    //根据键值查找键值对
    private MyEntry search(int key){
        for (MyEntry entry = head;entry != null;entry = entry.next){
            if (entry.key == key){
                return entry;
            }
        }
        return null;
    }
    //根据键值查找前驱节点
    private MyEntry searchPrev(int key){
        MyEntry prev = head;
        while (prev != null && prev.next != null){
            if (prev.next.key == key){
                return prev;
            }
        }
        return null;
    }
    //还有一个get方法
    public int get(int key){
        for (MyEntry entry = head;entry != null;entry = entry.next){
            if (entry.key == key){
                return entry.value;
            }
        }
        return -1;
    }
}
