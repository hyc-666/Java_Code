package shengzhou.q2;

/**
 * @author hyc
 * @date 2020/9/15
 */
public class Solution {
    /**
     * 数组内数据循环平移
     * @param arr int整型一维数组 输入数组
     * @param pushOffset int整型 位移长度
     * @return int整型一维数组
     */
    public int[] pushIntArray (int[] arr, int pushOffset) {
        // write code here
        if (pushOffset < 1){
            return arr;
        }
        pushOffset = pushOffset % arr.length;
        for (int i = 0; i < pushOffset; i++) {
            moveOnce(arr);
        }
        return arr;
    }

    //先向后移动一次
    public static void moveOnce(int[] arr){
        int temp = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;
    }
}
