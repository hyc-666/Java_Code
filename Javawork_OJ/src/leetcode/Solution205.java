package leetcode;
//同构字符串

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        if (s.length() == 0){
            return true;
        }
        Map<Character,Character> characterMap = new HashMap<>();
        //把s中的字符逐个映射到t上，对应位置为一个K-V,因此，对应位置就建立了联系
        //建立字符之间的映射就可以，重复值不处理
        for (int i = 0; i < s.length(); i++) {
            if (!characterMap.containsKey(s.charAt(i))){
                //如果现存map中没有包含s中一个字符的key，就建立映射关系
                //同时如果不包含，还应该检查t中的value是否在s中作为key，映射应该是双向映射，一一对应的
                if (characterMap.containsValue(t.charAt(i))){
                    return false;
                }
                characterMap.put(s.charAt(i),t.charAt(i));
            }else{//如果包含s的key，就检查映射关系是否正确
                if (characterMap.get(s.charAt(i)) != t.charAt(i)){
                    return false;
                }

            }
        }
        return true;
    }
}
