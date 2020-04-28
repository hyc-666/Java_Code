package leetcode._0428;

import java.util.Arrays;

public class MyHashMap2 {
    //居然超时，那就只能放大招了
    int[] hashMapValue = new int[1000005];

    /** Initialize your data structure here. */
    public MyHashMap2() {
        Arrays.fill(hashMapValue,-1);
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        hashMapValue[key] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return hashMapValue[key];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        hashMapValue[key] = -1;
    }

}
