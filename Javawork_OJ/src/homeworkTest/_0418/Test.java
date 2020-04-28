package homeworkTest._0418;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public Test() {
        createMap();
    }

    public static void main(String[] args) {
        //计算出每个字母对应字母表的序号
        Test test = new Test();
//        test.show();
        char[] arr = {'D','B','T','M','C','I','K','X','T'};
        test.getMap(arr);
    }
    private Map<Character,Integer> map = new HashMap<>();

    private void createMap(){
        char[] table = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N',
                'O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        for (int i = 0; i < 26; i++) {
            map.put(table[i],i + 1);
        }
    }
    public void show(){
        for (Map.Entry<Character,Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    //给定一个字母序列，计算出字母表中的序号
    public void getMap(char[] arr){
        Map<Character,Integer> res = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + ": " + map.get(arr[i]));
        }

    }
}
