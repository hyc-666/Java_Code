package xiaoyu.single;

import java.util.*;

/**
 * @author hyc
 * @date 2020/10/22
 */
public class Test {
    public static void main(String[] args) {
        String s = "asdgyuahsdiah";
        Map<Character,Integer> map = new HashMap<>();

        char[] arr = s.toCharArray();
        for (Character ch :arr){
            if (!map.containsKey(ch)){
                map.put(ch,1);
            }else {
                int value = map.get(ch);
                map.put(ch,value + 1);
            }
        }
        List<Map.Entry> list = new ArrayList<>();
        for (Map.Entry entry : map.entrySet()){
            list.add(entry);
        }
        list.sort(new Comparator<Map.Entry>() {
            @Override
            public int compare(Map.Entry o1, Map.Entry o2) {
                return (int)o2.getValue() - (int)o1.getValue();
            }
        });

        for (Map.Entry entry : list){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
