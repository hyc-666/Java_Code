package leetcode._0428;

public class MyHashSet2 {
    //说实话，这个hashSet真的是让我长见识了，耗时19ms
    /** Initialize your data structure here. */
    boolean[] map = new boolean[1000005];
    public MyHashSet2() {

    }

    public void add(int key) {
        map[key] = true;
    }

    public void remove(int key) {
        map[key] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return map[key];
    }
}
