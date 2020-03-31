package leetcode;
//实现链表707
/**
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 *
 * 在链表类中实现这些功能：
 *
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class MyLinkedList {
    Node head = null;
    int size = 0;

    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index >= size || index < 0){
            return -1;
        }
        if (index == 0){
            return head.val;
        }
        Node node = head;
        for(int i = 0;i < index;i++){
            node = node.next;
        }
        return node.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if(head == null){
            head = new Node(val);
            size++;
            return;
        }
        Node node = new Node(val);
        node.next = head;
        head = node;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (head == null){
            addAtHead(val);
            return;
        }
        Node node = head;
       for (int i = 0;i < size - 1;i++){//要让node走到最后一个结点但是不是null
           node = node.next;
       }
        node.next = new Node(val);
        size ++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index <= 0){
            addAtHead(val);
            return;
        }
        if (index == size){
            addAtTail(val);
            return;
        }
        if (index > size){
            return;
        }
        Node node = new Node(val);
        Node prev = head;
        for (int i = 0;i < index - 1;i++){
            prev = prev.next;
        }
        node.next = prev.next;
        prev.next = node;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (head == null){
            return;
        }
        if (index >= size || index < 0){
            return;
        }
        if (index == 0){
            if(head.next == null){
                head = null;
                size--;
                return;
            }
            head = head.next;
            size--;
            return;
        }
//        if (index == size){//相当于尾删
//            Node prev = head;
//            for (int i = 0;i < index - 1;i++){
//                prev = prev.next;
//            }
//            prev.next = null;
//            size--;
//            return;
//        }
        Node node = head;
        for (int i = 0; i < index - 1; i++) {
            node = node.next;
        }
        node.next = node.next.next;
        size--;
    }

//    public static void main(String[] args) {
//        MyLinkedList list = new MyLinkedList();
//        list.addAtHead(2);
//        list.deleteAtIndex(1);
//        list.addAtHead(2);
//        list.addAtHead(7);
//        list.addAtHead(3);
//        list.addAtHead(2);
//        list.addAtHead(5);
//        list.addAtTail(5);
//        list.get(5);
//        list.deleteAtIndex(6);
//        list.deleteAtIndex(4);
//    }
}
class Node{
    Node next;
    int val;
    public Node(int val){
        this.val = val;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */