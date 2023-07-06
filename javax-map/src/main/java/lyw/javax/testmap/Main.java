package lyw.javax.testmap;


import java.util.*;

/**
 * @Author: luohx
 * @Description: 集合map
 * @Date: 2021/2/23 14:46
 */
public class Main {

    public static void main(String[] args) throws Exception{

        int mod = 3 % 4;
        System.out.println("取模mod=" + mod);


        Map<String, String> map = new HashMap<>(16);
        map.put("1", "11");
        map.put("2", "22");
        map.put("3", "33");

        //遍历HashMap的entrySet键值对集合（强转）
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            System.out.println("iterator迭代器，key:" + entry.getKey() + "----" + "value:" + entry.getValue());
        }

        //遍历HashMap键的Set集合（二次取值）
        for (String key0 : map.keySet()) {
            System.out.println("map.keySet()，key:" + key0 + "----" + "value:" + map.get(key0));
        }

        //遍历map的entry，推荐，尤其是容量大时
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("map.entrySet()，key:" + entry.getKey() + "----" + "value:" + entry.getValue());
        }

        //遍历map的values()，但不能遍历key
        for (String val: map.values()) {
            System.out.println("map.values()，value:" + val);
        }


        System.out.println("123");
    }
}
