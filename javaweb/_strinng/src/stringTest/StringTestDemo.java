package stringTest;

/**
 * @author hyc
 * @date 2020/8/29
 */
public class StringTestDemo {
    /**
     * 查找两个字符串的最大相同子串
     * @param s1
     * @param s2
     * @return 返回最大相同子串
     */
    public String maxSameSubString(String s1,String s2){
        //确定两个字符串哪个长
        String maxString = s1.length() >= s2.length() ? s1 : s2;
        String minString = s1.length() < s2.length() ? s1 : s2;
        for (int i = 0; i < minString.length(); i++) {
            for (int x = 0,y = minString.length() - i;y <= minString.length();x++,y++) {
                String substring = minString.substring(x, y);
                if (maxString.contains(substring)){
                    return substring;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String s1 = "hellowordnihaobuhao";
        String s2 = "hellwoganjuebuhao";
        StringTestDemo t = new StringTestDemo();
        System.out.println(t.maxSameSubString(s1,s2));
    }
}
